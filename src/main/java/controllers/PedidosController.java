package controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Pedidos;
import services.PedidosServices;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	  @Autowired
	    private PedidosServices pedidosServicios;
	    
	    @GetMapping("/")
	    public List<Pedidos> obtenerPedidos() {
	        return pedidosServicios.obtenerPedidos();
	    }
	    
	    @PostMapping("/")
	    public void agregarPedido(@RequestBody Pedidos pedidos) {
	        pedidosServicios.agregarPedidos(pedidos);
	    }
	    
	    @PutMapping("/")
	    public void actualizarPedido(@RequestBody Pedidos pedidos) {
	        pedidosServicios.actualizarPedidos(pedidos);
	    }
	    
	    @DeleteMapping("/{idPedido}")
	    public void eliminarPedido(@PathVariable Long idPedidos) {
	        pedidosServicios.eliminarPedido(idPedidos);
	    }
}
