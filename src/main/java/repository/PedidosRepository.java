package repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import models.Pedidos;


@Repository
public interface PedidosRepository {

	void save(Pedidos pedido);

	List<Pedidos> findAll();

	void deleteById(Long idPedido);
}
