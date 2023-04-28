package ventas.online.com.modelo;


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
@Table(name ="productos")
@NamedQueries({
	@NamedQuery(name = "Productos.findAdll", query = "SELECT p FROM Productos p"),
	@NamedQuery(name = "Productos.finddProductos", query = "SELECT p FROM  Productos p WHERE p.idProductos = :idProductos"),
	@NamedQuery(name = "Productos.findNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
	@NamedQuery(name = "Productos.findDescripcion", query = "SELECT p Productos p WHERE p.descripcion = :descripcion"),
	@NamedQuery(name = "Productos.findPrecio", query = "SELECT p Productos p WHERE p. precio = :precio")
})

public class Productos implements Serializable{

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="idProductos")
	private Integer idProductos;
	
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	
	@Basic(optional = false)
	@Column(name = "descripcion")
	private String descripcion; 
	
	@Basic(optional = false)
	@Column(name = "precio")
	private String precio;
	
	//@JoinColumn(name = "clientes", referencedColumnName = "idClientes") // realizar el clientes.java
	//@ManyToOne(optional = false)
	//private Clientes clientes;
	
	//@JoinColumn(name = "despacho", referencedColumnName = "idDespacho") // realizar el despacho.java 
	//@ManyToOne(optional = false)
	//private Despacho despacho; 
	
	public Productos() {
		
	}
	public Productos(Integer idProductos, String nombre) {
		this.idProductos = idProductos;
		this.nombre = nombre; 
	}
	
	public Productos(String nombre, String descripcion, String precio) {
		super();
		this.nombre = nombre; 
		this.descripcion = descripcion; 
		this.precio = precio; 
	}
	
	public Integer getIdProductos() {
		return idProductos;
	}
	
	public void setIdProductos(Integer idProductos) {
		this.idProductos = idProductos;
	}
	public String getNombre() {
		return nombre; 
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion; 
	}
	public String getPrecio() {
		return descripcion;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(idProductos);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true; 
		if(obj == null)
			return false; 
		if(getClass() != obj.getClass())
			return false;
		if(getClass() != obj.getClass())
			return  false; 
		Productos other = (Productos) obj; 
		return Objects.equals(idProductos, other.idProductos);
	}
	@Override
	public String toString() {
		return "Producctos [idProductos=" + idProductos +"]";
	}
	public Productos buscarPorId(int i) {
		return null; 
	}
}