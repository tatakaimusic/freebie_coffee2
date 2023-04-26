package ru.test.freebie_coffee2.repositories;


import ru.test.freebie_coffee2.models.Product;

import java.util.List;

public interface ProductRepository {
    Product save(Product product);

    boolean delete(int id);

    Product get(int id);

    List<Product> getAll();
}
