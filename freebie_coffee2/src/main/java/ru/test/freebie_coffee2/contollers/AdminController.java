package ru.test.freebie_coffee2.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.test.freebie_coffee2.services.ProductService;

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
}
