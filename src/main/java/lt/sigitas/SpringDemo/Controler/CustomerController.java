package lt.sigitas.SpringDemo.Controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller// https://localhost:3306//
@RequestMapping(path = "/customermapping" )
public class CustomerController {

    //https://localhost:8080/customermapping/test
    @GetMapping(path = "/test" )
    public @ResponseBody String getTestPage() {
        return "This is text from Spring";
    }

}
