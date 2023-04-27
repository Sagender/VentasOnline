package controladores.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Clientes;
import services.ClientesServices;

@RestController
@RequestMapping("/rest/clientes")
public class ClientesRestController {
	
	@Autowired
	private ClientesServices servicio;
	
	public ResponseEntity<Object> buscarTodo(){
		List<Clientes> listClientes = servicio.buscarTodo();
		System.out.println("LISTA DE CLIENTES : " + listClientes);
		return new ResponseEntity<>(listClientes,HttpStatus.OK);
	}

}
