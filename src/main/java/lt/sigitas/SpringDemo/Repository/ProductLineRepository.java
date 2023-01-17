package lt.sigitas.SpringDemo.Repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductLineRepository extends CrudRepository<ProducLine, String> {

    Optional<ProducLine> findByProductLine(String productLineId);
    Iterable<ProducLine> findByTextDescriptionLike(String textDescription);
}
