package ru.test.freebie_coffee2.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import ru.test.freebie_coffee2.services.ProductService;

public abstract class AbstractRootController {
    protected final ProductService productService;

    @Autowired
    public AbstractRootController(ProductService productService) {
        this.productService = productService;
    }
}
