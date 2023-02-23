package com.ilyapanteleychuk.mongorest;

import com.ilyapanteleychuk.mongorest.properties.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties({
		FileStorageProperties.class
})
@SpringBootApplication
public class MongorestApplication {
	
    public static void main(String[] args) {
		SpringApplication.run(MongorestApplication.class, args);
	}
}
