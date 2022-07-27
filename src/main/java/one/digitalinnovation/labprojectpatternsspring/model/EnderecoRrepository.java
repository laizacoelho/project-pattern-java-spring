package one.digitalinnovation.labprojectpatternsspring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRrepository extends CrudRepository<Endereco, String> {
}
