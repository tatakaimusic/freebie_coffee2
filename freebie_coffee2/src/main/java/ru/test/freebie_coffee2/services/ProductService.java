package ru.test.freebie_coffee2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.test.freebie_coffee2.models.Product;
import ru.test.freebie_coffee2.repositories.ProductRepository;
import ru.test.freebie_coffee2.util.ValidationUtil;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product) {
        Assert.notNull(product, "product must not be null");
        return repository.save(product);
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
