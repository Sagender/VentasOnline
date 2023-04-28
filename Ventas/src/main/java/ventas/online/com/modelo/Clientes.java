package ventas.online.com.modelo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.NamedQueries;

@Entity
@Table(name = "clientes")

@NamedQueries({
	@NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
	@NamedQuery(name = "Clientes.findByIdClientes", query = "SELECT c FROM Clientes c WHERE codigo = :codigo"),
	@NamedQuery(name = "Clientes.findByNombres", query = "SELECT c FROM Clientes c WHERE c.nombres = :nombres"),
	@NamedQuery(name = "Clientes.findByDireccion", query = "SELECT c FROM Direccion c WHERE c.direccion = :direccion"),
	@NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Email c WHERE c.email = :email")
	
})

public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idClientes")
	private Integer idClientes;
	@Basic(optional = false)
	@Column(name = "nombres")
	private String nombres;
	@Basic(optional = false)
	@Column(name = "direccion")
	private String direccion;
	@Basic(optional = false)
	@Column(name = "email")
	private String email;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "clientes")
	@JsonBackReference(value="clientes_productos")
	private List<Productos> productosList;
	
	public Clientes() {
		
	}
	public Clientes(Integer idClientes, String nombres, String direccion, String email) {
	
		this.idClientes = idClientes; 
		this.nombres = nombres;
		this.direccion = direccion;
		this.email = email;
	}
	
	public Integer getIdClientes() {
		return idClientes;
	}
	public void setIdClientes(Integer idClientes) {
		this.idClientes = idClientes;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
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
	
	public List<Productos> getProductosList(){
		return productosList;
	}
	public void setProductosList(List<Productos> productosList) {
		this.productosList = productosList;
	}
}
