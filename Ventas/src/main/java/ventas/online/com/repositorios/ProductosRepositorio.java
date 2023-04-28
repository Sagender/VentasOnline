package ventas.online.com.repositorios;

import org.springframework.data.repository.CrudRepository;

import ventas.online.com.modelo.Productos;


public interface ProductosRepositorio extends CrudRepository<Productos, Integer> {

}
