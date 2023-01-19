package lt.sigitas.SpringDemo.Controler;


import lt.sigitas.SpringDemo.Repository.Customer;
import lt.sigitas.SpringDemo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    //http://localhost:8080/customertemplate/firstpage/customer/112
    @GetMapping(path = "/firstpage/customer/{id}" )
    public String getCustomerWithFirstPage(Model model, @PathVariable int id) {

        Customer customer = customerService.getMyCustomerById(id);

        model.addAttribute("company_name", customer.getCustomerName());
        model.addAttribute("contact_last_name", customer.getContactLastName());
        model.addAttribute("contact_first_name", customer.getContactFirstName());
        model.addAttribute("country", customer.getCountry());


        return "/Files/firstpage";
    }

    //http://localhost:8080/customertemplate/firstpage/customer/all
    @GetMapping(path = "/firstpage/customer/all" )
    public String getAllCustomers(Model model) {
        List<Customer> customersList = customerService.getAllCustomers();
        model.addAttribute("key_customers_list", customersList);
        return "/Files/firstpage_customers_list";
    }
    //JQuery set up apačioje

    //http://localhost:8080/customertemplate/customers/jquery
    @GetMapping(path = "/customers/jquery" )
    public String getJqueryPage(){
        return "/Files/jquerypage";
    }
    // http://localhost:8080/customertemplate/customers/like/a
    @GetMapping(path = "/customers/like/{name}")
    public @ResponseBody List<Customer> getMyCustomerByNameLike(@PathVariable String name){ // test
        return  customerService.getMyCustomerByNameLike("%" + name + "%"); // %test%
    }


    // CSS styles būdai apačioje


    //http://localhost:8080/customertemplate/customer/112
    @GetMapping(path = "/customer/{id}" )
    public String getCustomer(Model model, @PathVariable int id){

        Customer customer = customerService.getMyCustomerById(id);
        model.addAttribute("key_customer", customer);
        return "/customer/customer_th";
    }
    //http://localhost:8080/customertemplate/customers/all
    @GetMapping(path = "/customers/all" )
    public String getAllCustomersWithNewTemplate(Model model) {
        List<Customer> customersList = customerService.getAllCustomers();
        model.addAttribute("key_customers_list", customersList);
        return "/customer/customers_th";
    }
    ///http://localhost:8080/customertemplate/customers/getandpost
    // example with request mapping
    @RequestMapping(value = "/customers/getandpost", method = RequestMethod.GET)
    public String getCustomerByNameLike(Model model){
        model.addAttribute("key_customer", new Customer());
        model.addAttribute("key_customer_listas", Collections.emptyList());
        return "/customer/post_get_customers_th";
    }
    ///http://localhost:8080/customertemplate/customers/getandpost
    @RequestMapping(value = "/customers/getandpost", method = RequestMethod.POST)
    public String postCustomerByNameLike(Model model, @ ModelAttribute(value = "key_customer") Customer customer){
        List<Customer> customers= customerService.getMyCustomerByNameLike("%" + customer.getCustomerName() + "%");
        model.addAttribute("key_customer_listas", customers);
        return "/customer/post_get_customers_th";
    }

}

