package com.alter.file;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RestController
@RequestMapping("/resource")
@RequiredArgsConstructor
public class FileController {

    private static final String IMAGE_DIR = "./images";
    private static final Path   IMAGE_LOCATION = Paths.get(IMAGE_DIR);


    @PostConstruct
    protected void init () throws Exception {
        if (Files.notExists(IMAGE_LOCATION)) {
            Files.createDirectory(IMAGE_LOCATION);
        }
    }

    @GetMapping("/icon/{iconId}")
    public HttpEntity<Resource> getIcon (@PathVariable("iconId") final String iconId) {
        try {
            Path file = IMAGE_LOCATION.resolve(iconId);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }
        catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
