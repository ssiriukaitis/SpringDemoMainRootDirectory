package lt.sigitas.SpringDemo.Bootstrap;

import lt.sigitas.SpringDemo.Repository.CustomerRepository;
import lt.sigitas.SpringDemo.Repository.ProductLineRepository;
import org.hibernate.annotations.Comment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private CustomerRepository customerRepository;
    private ProductLineRepository productLineRepository;

    public BootStrapData(CustomerRepository customerRepository, ProductLineRepository productLineRepository) {
        this.customerRepository = customerRepository;
        this.productLineRepository = productLineRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        customerRepository.findAll().forEach(System.out::println);
        System.out.println("\n------------\n");
        System.out.println(customerRepository.findById(112));
        System.out.println("\n------------\n");
        productLineRepository.findAll().forEach(System.out::println);
        System.out.println("\n------------\n");
        System.out.println(productLineRepository.findById("Ships"));

    }

}
