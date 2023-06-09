package ru.test.freebie_coffee2.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.test.freebie_coffee2.services.ProductService;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractRootController {
    public UserController(ProductService productService) {
        super(productService);
    }

    @Override
    protected String getIndex() {
        return "user/user_index";
    }
}
