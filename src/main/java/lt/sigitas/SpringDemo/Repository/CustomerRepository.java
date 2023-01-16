package lt.sigitas.SpringDemo.Repository;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
