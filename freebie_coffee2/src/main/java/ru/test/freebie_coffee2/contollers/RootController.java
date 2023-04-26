package ru.test.freebie_coffee2.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.test.freebie_coffee2.services.ProductService;

@Controller
@RequestMapping("/index")
public class RootController {
    private final ProductService productService;

    @Autowired
    public RootController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", productService.getAll());
        return "index";
    }


}