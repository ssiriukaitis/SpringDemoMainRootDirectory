package lt.sigitas.SpringDemo.Controler;

import lt.sigitas.SpringDemo.Repository.Customer;
import lt.sigitas.SpringDemo.Repository.ProducLine;
import lt.sigitas.SpringDemo.Service.CustomerService;
import lt.sigitas.SpringDemo.Service.ProductLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller// https://localhost:3306//
@RequestMapping(path = "/productLinesTemplate" )
public class ProductLineTemplateController {

    @Autowired
    private ProductLineService productLineService;

    //http://localhost:8080/productLinesTemplate/test
    @GetMapping(path = "/test" )
    public String getTestPage() {
        return "/Files/HTMLpage";
    }

    //http://localhost:8080/productLinesTemplate/firstPageProductLines/productLines/Ships
    @GetMapping(path = "/firstPageProductLines/productLines/{id}" )
    public String getProductLinesWithFirstPage(Model model, @PathVariable String id) {

        ProducLine productline = productLineService.getMyProductLineById(id);

        model.addAttribute("productline", productline.getProductLine());
        model.addAttribute("textdescription", productline.getTextDescription());
        model.addAttribute("htmldescription", productline.getHtmlDescription());

        return "/Files/firstPageProductLines";
    }
}
