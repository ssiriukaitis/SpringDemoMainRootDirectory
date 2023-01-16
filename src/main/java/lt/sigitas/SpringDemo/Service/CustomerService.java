package lt.sigitas.SpringDemo.Service;

import lt.sigitas.SpringDemo.Repository.Customer;
import lt.sigitas.SpringDemo.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getAllCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }
    public Customer getCustomerById(Integer customerId){
        return customerRepository.findById(customerId).get();
    }
}
