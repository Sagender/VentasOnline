package ventas.online.com.controladores;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ventas.online.com.modelo.Productos;
import ventas.online.com.servicios.ProductosServicio;

@Controller
@RequestMapping("/productos")
public class ProductosController {
	@Autowired //Inyeccion 
	private ProductosServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarProductos (Model model) {
		
		List<Productos> listaProductos = servicio.buscarTodo();
		System.out.println("LISTA DE PRODUCTOS : "+ listaProductos);
		model.addAttribute("listaProductos", listaProductos);
		return "/moduloProductos/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoProducto(Model model) {
		Productos productos = new Productos();
		model.addAttribute("productos",productos);
		return "/moduloProductos/nuevoProductos";
	}
	
	@RequestMapping(value = "/guardar", method=RequestMethod.POST)
	public String crearProductos(@ModelAttribute("productos") Productos productos) {
		servicio.crear(productos);
		return "redirect:/productos/listarTodo";
	}
	
	 @RequestMapping(value ="/actualizar/{id}")
	 public ModelAndView editarProductos(@PathVariable(name="id") int id) {
		 ModelAndView mav = new ModelAndView("/moduloProductos/editarProductos");
		 Productos productos = servicio.buscarPorId(id);
		 mav.addObject("productos", productos);
		 return mav;
	
}
	 @RequestMapping(value = "/eliminar/{id}")
	 public String eliminarProductos(@PathVariable(name ="id")int id) {
		 servicio.buscarPorId(id);
		 return "redirect:/productos/listarTodo";
	 }
	 
}