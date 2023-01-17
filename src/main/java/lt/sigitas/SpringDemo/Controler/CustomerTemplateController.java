package lt.sigitas.SpringDemo.Controler;


import lt.sigitas.SpringDemo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller// https://localhost:3306//
@RequestMapping(path = "/customertemplate" )
public class CustomerTemplateController {

    @Autowired
    private CustomerService customerService;

    //http://localhost:8080/customertemplate/test
    @GetMapping(path = "/test" )
    public String getTestPage() {
        return "/Files/HTMLpage";
    }


}

