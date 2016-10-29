package practica1_java;

import java.io.Serializable;
import java.util.ArrayList;

public class ListaCliente implements Serializable{
    
    private ArrayList<Cliente> listaClientes;
    
    public ListaCliente(){
        listaClientes = new ArrayList<>();
    }
    
    public void altaCliente(Cliente c){
        listaClientes.add(c);
    }    
    
    public ArrayList<Cliente> getListaClientes(){
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
 
    
    public boolean existeTelefono(String telefono){
        for(Cliente c : listaClientes){
            if(c.getTelefono().equalsIgnoreCase(telefono)){
              return true;
            }
        }
        return false;
    }
    
    public Cliente obtenerTelefonoCliente(String telefono){
        for(Cliente c : listaClientes){
            if(telefono.equalsIgnoreCase(telefono)){
                return c;
            }
        }
        return null;
    }
}
