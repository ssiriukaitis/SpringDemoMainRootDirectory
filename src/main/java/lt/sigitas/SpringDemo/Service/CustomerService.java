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

    public Customer getMyCustomerById(int id){
        return customerRepository.findByCustomerNumber(id).get();
    }
    public Customer getMyCustomerByName(String customerName){
        return customerRepository.findByCustomerName(customerName).get();
    }
    public List<Customer> getMyCustomerByNameLike(String customerName){
        return (List<Customer>) customerRepository.findByCustomerNameLike(customerName);
    }
    public List<Customer> getQueryCustomerByNameLike(String customerName) {
        return (List<Customer>) customerRepository.getCustomerNameLike(customerName);
    }
}
