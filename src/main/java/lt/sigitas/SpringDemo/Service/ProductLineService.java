package lt.sigitas.SpringDemo.Service;

import lt.sigitas.SpringDemo.Repository.Customer;
import lt.sigitas.SpringDemo.Repository.CustomerRepository;
import lt.sigitas.SpringDemo.Repository.ProducLine;
import lt.sigitas.SpringDemo.Repository.ProductLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductLineService {

    @Autowired
    private ProductLineRepository productLineRepository;


    public List<ProducLine> getAllProductLines(){
        return (List<ProducLine>) productLineRepository.findAll();
    }
    public ProducLine getProductLineById(String productLineId){
        return productLineRepository.findById(productLineId).get();
    }

}
