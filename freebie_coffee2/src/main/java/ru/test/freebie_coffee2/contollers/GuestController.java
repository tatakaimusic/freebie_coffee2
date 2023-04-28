package ru.test.freebie_coffee2.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.test.freebie_coffee2.services.ProductService;

@Controller
@RequestMapping("/guest")
public class GuestController extends AbstractRootController {
    public GuestController(ProductService productService) {
        super(productService);
    }

    @Override
    protected String getIndex() {
        return "guest/guest_index";
    }
}
