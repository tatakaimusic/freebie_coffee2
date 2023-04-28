package ru.test.freebie_coffee2.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.test.freebie_coffee2.models.Person;
import ru.test.freebie_coffee2.security.PersonDetails;
import ru.test.freebie_coffee2.services.ProductService;

public abstract class AbstractRootController {
    protected final ProductService productService;

    @Autowired
    public AbstractRootController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("products", productService.getAll());
        return getIndex();
    }

    @GetMapping("/profile")
    public String showUserInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person person = ((PersonDetails) authentication.getPrincipal()).getPerson();
        model.addAttribute("person", person);
        return "profile";
    }

    protected abstract String getIndex();

}
