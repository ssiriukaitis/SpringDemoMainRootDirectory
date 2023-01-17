package lt.sigitas.SpringDemo.Controler;

import lt.sigitas.SpringDemo.Repository.Customer;
import lt.sigitas.SpringDemo.Repository.CustomerRepository;
import lt.sigitas.SpringDemo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller// https://localhost:3306//
@RequestMapping(path = "/customermapping" )
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    //http://localhost:8080/customermapping/test
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
//   http://localhost:8080/customermapping/mycustomer/112
   @GetMapping(path = "/mycustomer/{id}")
   public @ResponseBody Customer getMyCustomerById(@PathVariable int id){
        return customerService.getMyCustomerById(id);
   }

//   http://localhost:8080/customermapping/mycustomer/name/Diecast%20Collectables
   @GetMapping(path = "/mycustomer/name/{name}")
   public @ResponseBody Customer getMyCustomerByName(@PathVariable String name){
        return customerService.getMyCustomerByName(name);
   }

    //   http://localhost:8080/customermapping/mycustomer/Like/a
    @GetMapping(path = "/mycustomer/Like/{name}")
    public @ResponseBody List<Customer> getMyCustomerByNameLike(@PathVariable String name){
        return customerService.getMyCustomerByNameLike("%" + name + "%");
    }
    //   http://localhost:8080/customermapping/mycustomer/queryLike/Krem
    @GetMapping(path = "/mycustomer/queryLike/{name}")
    public @ResponseBody List<Customer> getQueryCustomerByNameLike(@PathVariable String name) {
        return customerService.getQueryCustomerByNameLike("%" + name + "%");
    }

    // SELECT * FROM customer WHERE customerName Like "%test%"

//    http://localhost:8080/customermapping/mycustomer/id?customerNumber=112
@GetMapping(path = "/mycustomer/id")
public @ResponseBody Customer getMyCustomerByIdWithRequestParam(@RequestParam int customerNumber){
    return customerService.getMyCustomerById(customerNumber);
}

}
