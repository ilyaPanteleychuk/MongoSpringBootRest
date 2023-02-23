package com.ilyapanteleychuk.mongorest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilyapanteleychuk.mongorest.exception.FileStorageException;
import com.ilyapanteleychuk.mongorest.model.FamousPeople;
import com.ilyapanteleychuk.mongorest.properties.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


@Service
public class FileProcessorService {
    
    private final Path fileStorageLocation;
    
    @Autowired
    public FileProcessorService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths
                .get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try{
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException e) {
            throw new FileStorageException("Can`t create directory ", e);
        }
    }
    
    public List<FamousPeople> parseJsonContent(MultipartFile file){
        String jsonPath = storeZipFileContent(file);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<FamousPeople> famousPeople = Arrays.asList(objectMapper.readValue
                    (new File(jsonPath), FamousPeople[].class));
            deleteFile(jsonPath);
            return famousPeople;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    private String storeZipFileContent(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! " +
                        "Filename contains invalid path sequence " + fileName);
            }
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation,
                    StandardCopyOption.REPLACE_EXISTING);
            return unZipFileToJson(String.valueOf(targetLocation));
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file "
                    + fileName + ". Please try again!", ex);
        }
    }
    
    private String unZipFileToJson(String fileToUnzip){
        String jsonFilePath = fileToUnzip.substring(0, fileToUnzip.indexOf("."))
                .concat(".json");
        InputStream stream;
        try(ZipFile zipFile = new ZipFile(fileToUnzip)){
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while(entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                stream = zipFile.getInputStream(entry);
                Files.copy(stream, Path.of(jsonFilePath),
                        StandardCopyOption.REPLACE_EXISTING);
                deleteFile("mongorest/src/main/resources/temp/pep.zip");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonFilePath;
    }
    
    private void deleteFile(String filePath) throws IOException {
        File fileToDelete = new File(filePath);
        if(!fileToDelete.delete()){
            throw new IOException("Cannot delete file " + fileToDelete);
        }
    }
}
