package models;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")

@NamedQueries({
	@NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
	@NamedQuery(name = "Clientes.findByidcliente", query = "SELECT c FROM Clientes c WHERE idcliente = :idCliente"),
	@NamedQuery(name = "Clientes.findBynombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nameCliente"),
	@NamedQuery(name = "Clientes.findBydireccion", query = "SELECT c FROM Clientes c WHERE c.direccion = :direccion"),
	@NamedQuery(name = "Clientes.findByemail", query = "SELECT c FROM Clientes c WHERE c.email = :email")
	
})

public class Cliente implements Serializable{

	private static final long serialVersionUID = 1l;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idCliente")
	private Integer idCliente;
	
	@Basic(optional =false)
	@Column(name = "nameCliente")
	private String nameCliente;
	
	@Basic(optional =false)
	@Column(name = "direccion")
	private String direccion;
	
	@Basic(optional =false)
	@Column(name = "email")
	private String email;
	
	public Cliente(){
		
	}
public Cliente(Integer idCliente, String nameCliente) {
	this.idCliente = idCliente;
	this.nameCliente =nameCliente;
}
public Cliente(String nameCliente,String direccion, String email) {
	super();
	this.nameCliente =nameCliente;
	this.direccion =direccion;
	this.email = email;
	
}
public Integer getIdCliente() {
	return idCliente;
}
public void setIdCliente(Integer idCliente) {
	this.idCliente = idCliente;
}
public String getNameCliente() {
	return nameCliente;
}
public void setNameCliente(String nameCliente) {
	this.nameCliente = nameCliente;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public int hashCode() {
	return Objects.hash(idCliente);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cliente other = (Cliente) obj;
	return Objects.equals(idCliente, other.idCliente);
}

@Override
public String toString() {
	return "Cliente [idCliente=" + idCliente + "]";
}


public Cliente buscarPorID(int i) {
	return null;
}

}
