package ru.test.freebie_coffee2.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.test.freebie_coffee2.services.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController extends AbstractRootController {

    public AdminController(ProductService productService) {
        super(productService);
    }

    @GetMapping("/page")
    public String adminPage() {
        return "/admin/page";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("products", productService.getAll());
        return "admin/admin_index";
    }
}
