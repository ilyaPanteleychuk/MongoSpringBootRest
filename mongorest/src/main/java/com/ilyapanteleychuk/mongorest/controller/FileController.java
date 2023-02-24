package com.ilyapanteleychuk.mongorest.controller;

import com.ilyapanteleychuk.mongorest.model.FamousPeopleData;
import com.ilyapanteleychuk.mongorest.service.FamousPeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Controller for managing file-uploading endpoints
 *
 * @author Ilya Panteleychuk
 */
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class FileController {
    
    private final FamousPeopleService famousPeopleService;
    
    @PostMapping("/uploadZip")
    public String uploadDB(@RequestParam("file") MultipartFile file){
        famousPeopleService.fillDbFromFile(file);
        return "OK";
    }
}
