package lt.sigitas.SpringDemo.Repository;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productlines")
public class ProducLine {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productline")
    private String productLine;
    @Column(name = "textdescription")
    private String textDescription;
    @Column(name = "htmldescription")
    private String htmlDescription;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    @Override
    public String toString() {
        return "ProductLine{" +
                "productLine=" + productLine +
                ", textDescription='" + textDescription + '\'' +
                ", htmlDescription='" + htmlDescription +
                '}';
    }
}


