package svs.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author BAD
 * @version 23/02/19
 */
@Controller
public class IndexController {

    @RequestMapping({"", "/", "/index"}) // call method when one of these URL values is called.
    public String getIndexPage() {
        System.out.println("Testing the display of index page");
        return "index";
    }
}
