package models;

import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
;

@Entity
@Table(name ="productos")
@NamedQueries({
	@NamedQuery(name = "Productos.findAll", query = "SELECT c FROM Cliente c"),
	@NamedQuery(name = "Productos.findByIdCliente", query = "SELECT c FROM Cliente c WHERE idCliente = :idCliente"),
	@NamedQuery(name = "Productos.findByNameCliente", query = "SELECT c FROM Cliente c WHERE c.nameCliente = :nameCliente"),
	@NamedQuery(name = "Productos.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
	@NamedQuery(name = "Productos.findByEmail", query = "SELECT c FROM Email c Cliente WHERE c.email = :email")
	
})

public class Pedidos implements Serializable{
	private static final long serialVersionUID = 1L; 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Basic(optional = false)
    @Column(name = "idPedidos")
    private Integer idPedidos;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "idCliente")
    private int idCliente;

    @Column(name = "idProducto")
    private int idProducto;

    public Pedidos() {}

    public Pedidos(Integer idpedidos, Date fecha, int idcliente, int idproducto) {
    
        this.idPedidos =  idpedidos;
        this.fecha =  fecha;
        this.idCliente =  idcliente;
        this.idProducto =  idproducto;
    }

    public Integer getidPedidos() {
        return idPedidos;
    }

    public void setidPedidos(Integer idPedidos) {
        this.idPedidos = idPedidos;
    }

    public Date getfecha() {
        return fecha;
    }

    public void setfecha(Date fecha) {
        this.fecha = fecha;
    
    }
    public int getidCliente() {
        return idCliente;
    }

    public void setidCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getidProducto() {
        return idProducto;
    }

    public void setidProducto(int idProducto) {
        this.idProducto = idProducto;
    }

}
