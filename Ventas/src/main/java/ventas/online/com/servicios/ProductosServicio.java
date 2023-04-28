import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ventas.online.com.modelo.Productos;
import ventas.online.com.repositorios.ProductosRepositorio;

@Service
@Transactional
public class ProductosServicio {
	@Autowired 
	private ProductosRepositorio repositorio; 
	
	public ProductosServicio() {
		
	}
	public List<Productos>buscarTodo(){
		return (List<Productos>) repositorio.findAll();
	}
	
	public Productos actualizar(Productos productosActualizar) {
		
		Productos productosActual = repositorio.findById(productosActualizar.getIdProductos()).get();
		
		
		productosActual.setNombre(productosActualizar.getNombre());
		productosActual.setDescripcion(productosActualizar.getDescripcion());
		productosActual.setPrecio(productosActualizar.getPrecio());
		
		Productos productosActualizado = repositorio.save(productosActual);
		return productosActualizado;
	}
	
	public void eliminarProductos(Integer id) {
		repositorio.deleteById(id);
	}
	
	public void actualizar(int id, Productos productos) {
		Productos productosActual = repositorio.findById(id).get();
		
		productosActual.setIdProductos(productos.getIdProductos());
		productosActual.setDescripcion(productos.getDescripcion());
		productosActual.setNombre(productos.getNombre());
		productosActual.setPrecio(productos.getPrecio());
		repositorio.save(productosActual);
		
	}
	public Productos buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void crear(Productos producto) {
		// TODO Auto-generated method stub
		
	}
}