package lt.sigitas.SpringDemo.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {



    Optional<Customer> findByCustomerNumber(int id);
    Optional<Customer> findByCustomerName(String customerName);
    Iterable<Customer> findByCustomerNameLike(String customerName); //tas pats, kas apacioje

    @Query(value = "select * FROM customers WHERE customerName Like :name", nativeQuery = true)
    List<Customer> getCustomerNameLike(@Param("name") String customerName);



}
