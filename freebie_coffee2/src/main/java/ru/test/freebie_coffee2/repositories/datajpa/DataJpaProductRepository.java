package ru.test.freebie_coffee2.repositories.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.test.freebie_coffee2.models.Product;
import ru.test.freebie_coffee2.repositories.ProductRepository;

import java.util.List;

@Repository
public class DataJpaProductRepository implements ProductRepository {
    private final CrudProductRepository crudProductRepository;

    @Autowired
    public DataJpaProductRepository(CrudProductRepository crudProductRepository) {
        this.crudProductRepository = crudProductRepository;
    }

    @Override
    public Product save(Product product) {
        return crudProductRepository.save(product);
    }

    @Override
    public boolean delete(int id) {
        return crudProductRepository.delete(id) != 0;
    }

    @Override
    public Product get(int id) {
        return crudProductRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return crudProductRepository.findAll();
    }
}
