package services;

import java.util.List;
import models.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PedidosRepository;

@Service
public class PedidosServices {

  @Autowired
  private PedidosRepository pedidosRepository;

  public List<Pedidos> obtenerPedidos() {
    return pedidosRepository.findAll();
  }
  }

 /* public void agregarPedidos(Pedidos pedidos) {
    pedidosRepository.save(pedidos);
  }

  public void actualizarPedidos(Pedidos pedidos) {
    pedidosRepository.save(pedidos);
  }

  public void eliminarPedidos(Long idPedidos) {
    pedidosRepository.deleteById(idPedidos);
  }

  public List<Pedidos> obtenerPedidos() {
    // TODO Auto-generated method stub
    return null;
  }

  public void agregarPedidos(Pedidos pedidos) {
    // TODO Auto-generated method stub

  }

  public void eliminarPedido(Long idPedidos) {
    // TODO Auto-generated method stub
  }
}*/