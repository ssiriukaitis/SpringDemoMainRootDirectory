package lt.sigitas.SpringDemo.Controler;

import lt.sigitas.SpringDemo.Repository.Customer;
import lt.sigitas.SpringDemo.Repository.CustomerRepository;
import lt.sigitas.SpringDemo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller// https://localhost:3306//
@RequestMapping(path = "/customermapping" )
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    //https://localhost:8080/customermapping/test
    @GetMapping(path = "/test" )
    public @ResponseBody String getTestPage() {
        return "This is text from Spring";
    }

    ////http://localhost:8080/customermapping/customer/all
    @GetMapping(path = "/customer/all")
    public @ResponseBody List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();

    }

    @GetMapping(path = "/customer/{id}")
   public @ResponseBody Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
   }
}
