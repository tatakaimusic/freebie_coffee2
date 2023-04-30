package ru.test.freebie_coffee2.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.test.freebie_coffee2.models.Product;
import ru.test.freebie_coffee2.services.ProductService;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractRootController {
    public AdminController(ProductService productService) {
        super(productService);
    }

    @Override
    protected String getIndex() {
        return "admin/admin_index";
    }

    @GetMapping("/products")
    public String products() {
        return "admin/products/products_list";
    }

    @GetMapping("/products/create")
    public String createProductForm(@ModelAttribute("product") Product product) {
        return "admin/products/create";
    }

    @PostMapping("/products/create")
    public String createProduct(@ModelAttribute("product") @Valid Product product
            , @RequestParam("file1") MultipartFile file1
            , @RequestParam("file2") MultipartFile file2
            , @RequestParam("file3") MultipartFile file3) throws IOException {
        productService.create(product, file1, file2, file3);
        return "redirect:/admin/products";

    }
}
