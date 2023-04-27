package repository;
import org.springframework.data.repository.CrudRepository;

import models.Cliente;

public interface ClientesRepository extends CrudRepository<Cliente,Integer>{

}
