package lt.sigitas.SpringDemo.Controler;

import lt.sigitas.SpringDemo.Repository.Customer;
import lt.sigitas.SpringDemo.Repository.CustomerRepository;
import lt.sigitas.SpringDemo.Repository.ProducLine;
import lt.sigitas.SpringDemo.Repository.ProductLineRepository;
import lt.sigitas.SpringDemo.Service.CustomerService;
import lt.sigitas.SpringDemo.Service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller// https://localhost:3306//
@RequestMapping(path = "/productLinemapping" )
public class ProductLineController {

    @Autowired
    private ProductLineService productLineService;
    @Autowired
    private ProductLineRepository productLineRepository;

    //https://localhost:8080/productLinemapping/test
    @GetMapping(path = "/test" )
    public @ResponseBody String getTestPage() {
        return "This is text from Spring";
    }

    ////http://localhost:8080/productLinemapping/productLine/all
    @GetMapping(path = "/productLine/all")
    public @ResponseBody List<ProducLine> getAllProductLines(){
        return productLineService.getAllProductLines();

    }

    @GetMapping(path = "/productLine/{id}")
    public @ResponseBody ProducLine getProductLineById(@PathVariable String id){
        return productLineService.getProductLineById(id);
    }

//    http://localhost:8080/productLinemapping/myProductLine/Ships
    @GetMapping(path = "/myProductLine/{id}")
    public @ResponseBody ProducLine getMYProductLineById(@PathVariable String id){
        return productLineService.getMyProductLineById(id);
    }
    //   http://localhost:8080/productLinemapping/myProductLine/Like/Fas
    @GetMapping(path = "/myProductLine/Like/{textDescription}")
    public @ResponseBody List<ProducLine> getMyTextDescriptionLike(@PathVariable String textDescription){
        return productLineService.getMyTextDescriptionLike("%" + textDescription + "%");
    }

}
