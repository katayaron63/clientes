/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;
import model.Conexion;

/*
PUNTO 5: Crear una tabla en la base de datos, que contenga 5 campos con una llave primaria
CREATE TABLE cliente(
    id_cliente int primary key auto_increment,
    nombre varchar(50) not null,
    apellido varchar(50) not null ,
    correo varchar (100),
    telefono date (15)
);
*/

/**
 *
 * @author catalinazurita
 */
public class ClienteDAO {
    
    private final List<Cliente> lista = new ArrayList<>();
    
    public ClienteDAO(){
        //lista.add(new Cliente(1, "Catalina", "Zurita", "katayaron63@gmail.com", "+56912341234"));
    }
    
    public Cliente getCliente(int _id){
        //recorre la lista de clientes
        for (Cliente objeto : this.lista){
            //si el id del cliente de la lista es igual al id que llega por parametro
            if (objeto.getID_cliente() == _id){
                //entonces retorna el objeto completo
                return objeto;
            }
        }
        return null;
    }
    
    public List<Cliente> getAll(){
        return this.lista;
    }
    
    public boolean agregar(Cliente _cliente){
        try {
            this.lista.add(_cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
    public boolean quitar(int _id){
        //recorre la lista de clientes
        for (Cliente objeto : this.lista){
            //si el id del cliente de la lista es igual al id que llega por parametro
            if (objeto.getID_cliente() == _id){
                //entonces asigna el objeto completo
                this.lista.remove(objeto);
                return true;
            }
        }
        return false;
    }
    
    public boolean actualizar(Cliente _cliente){
        //recorre la lista de clientes
        for (Cliente objeto : this.lista){
            
            //si el id del cliente de la lista es igual al id que llega por parametro
            if (objeto.getID_cliente() == _cliente.getID_cliente()){
                //entonces actualiza los campos del objeto
                System.out.println("Nombre: "+objeto.getNombre()+" - Nuevo Nombre: " + _cliente.getNombre());
                objeto.setNombre(_cliente.getNombre());
                objeto.setApellido(_cliente.getApellido());
                objeto.setCorreo(_cliente.getCorreo());
                objeto.setTelefono(_cliente.getTelefono());
                return true;
            }
        }
        return false;
    }
       
}

