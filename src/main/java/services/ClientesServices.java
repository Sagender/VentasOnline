package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import models.Clientes;
import repository.ClientesRepository;


@Service
@Transactional
public class ClientesServices {
	
	@Autowired
	private ClientesRepository repositorio;
	
	public Clientes crear(Clientes clientes) {
		return repositorio.save(clientes);
	}
	
	public List<Clientes> buscarTodo(){
		return (ArrayList<Clientes>) repositorio.findAll();
	}
	
	public Clientes buscarPorId(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public Clientes actualizar(Clientes clientesActualizar) {
		
		Clientes clienteActual = repositorio.findById(clientesActualizar.getIdCliente()).get();
		
		
		clienteActual.setNombre(clientesActualizar.getNombre());
		clienteActual.setDireccion(clientesActualizar.getDireccion());
		clienteActual.setEmail(clientesActualizar.getEmail());
		
		Clientes clienteActualizado = repositorio.save(clienteActual); 
		return clienteActualizado;
		
	}
	
	
	public void eliminarClientes(Integer id) {
		repositorio.deleteById(id);
	}

	
	public void actualizar(int id,Clientes cliente) {
		Clientes clienteActual = repositorio.findById(id).get();
		
		clienteActual.setIdCliente(cliente.getIdCliente());
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setDireccion(cliente.getDireccion());
		clienteActual.setEmail(cliente.getEmail());
		
		repositorio.save(clienteActual);
	}
	
}
