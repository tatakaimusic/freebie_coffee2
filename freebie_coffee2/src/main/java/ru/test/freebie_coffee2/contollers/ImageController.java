package ru.test.freebie_coffee2.contollers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.test.freebie_coffee2.models.Image;
import ru.test.freebie_coffee2.repositories.datajpa.CrudImageRepository;

import java.io.ByteArrayInputStream;

@RestController
public class ImageController {
    private final CrudImageRepository imageRepository;

    public ImageController(CrudImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @GetMapping("/image/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Integer id) {
        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
