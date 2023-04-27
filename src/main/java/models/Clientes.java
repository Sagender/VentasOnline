package models;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//Anotaciones para el uso de Lombook
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor



@Entity
@Table(name = "clientes")
@NamedQueries({
	@NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
	@NamedQuery(name = "Clientes.findByIdClientes", query = "SELECT c FROM Clientes c WHERE c.idCliente = :idCliente"),
	@NamedQuery(name = "Clientes.findByNameClientes", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre"),
	@NamedQuery(name = "Clientes.findByDireccion", query = "SELECT c FROM Clientes c WHERE c.direccion = :direccion"),
	@NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email")
	
})

public class Clientes implements Serializable{

	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idCliente")
	private Integer idCliente;
	
	@Basic(optional =false)
	@Column(name = "nombre")
	private String nombre;
	
	@Basic(optional =false)
	@Column(name = "direccion")
	private String direccion;
	
	@Basic(optional =false)
	@Column(name = "email")
	private String email;
	

}