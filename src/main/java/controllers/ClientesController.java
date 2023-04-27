package controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.Cliente;
import services.ClientesServices;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
	@Autowired 
	private ClientesServices servicio;
	
	
	@RequestMapping("/listarTodo")
	public String listarCliente (Model model) {
		
		List <Cliente> listaCliente= servicio.buscarTodo();
		System.out.println("LISTA DE CLIENTES: " + listaCliente);
		model.addAttribute("listaCliente", listaCliente);
		return "/modules/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoCliente(Model model) {
		Cliente cliente = new Cliente ();
		model.addAttribute("cliente",cliente);
		return "/modules/nuevoCliente";	
	}
	
	@RequestMapping(value ="/guardar", method= RequestMethod.POST)
	public String crearCliente(@ModelAttribute("cliente") Cliente cliente) {
		    servicio.crear(cliente);
		    return "redirect:/clienteS/listarTodo";
		
	}
	
	 @RequestMapping(value ="/actualizar/{id}")
	public ModelAndView editarPelicula(@PathVariable(name="id") int id) {
		ModelAndView mav = new ModelAndView("/module/editarCliente");
		Cliente cliente = servicio.buscarPorId(id);
		mav.addObject("cliente",cliente);
		return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String elimnarCliente(@PathVariable(name="id") int id) {
		servicio.borrarPorId(id);
		return "redirect:/cliente/listarTodo";
	}

}
