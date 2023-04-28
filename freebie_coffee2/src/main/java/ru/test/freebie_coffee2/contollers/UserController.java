package ru.test.freebie_coffee2.contollers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.test.freebie_coffee2.models.Person;
import ru.test.freebie_coffee2.security.PersonDetails;
import ru.test.freebie_coffee2.services.ProductService;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractRootController {
    public UserController(ProductService productService) {
        super(productService);
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("products", productService.getAll());
        return "user/user_index";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person person = ((PersonDetails) authentication.getPrincipal()).getPerson();
        return null;
    }
}
