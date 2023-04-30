package ru.test.freebie_coffee2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;
import ru.test.freebie_coffee2.models.Image;
import ru.test.freebie_coffee2.models.Product;
import ru.test.freebie_coffee2.repositories.ProductRepository;
import ru.test.freebie_coffee2.util.ValidationUtil;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            product.addImage(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            product.addImage(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            product.addImage(image3);
        }
        Assert.notNull(product, "product must not be null");
        return repository.save(product);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void update(Product product) {
        Assert.notNull(product, "product must not be null");
        ValidationUtil.checkNotFoundWithId(repository.save(product), product.getId());
    }

    public void delete(int id) {
        ValidationUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    public Product get(int id) {
        return ValidationUtil.checkNotFoundWithId(repository.get(id), id);
    }

    public List<Product> getAll() {
        return repository.getAll();
    }
}
