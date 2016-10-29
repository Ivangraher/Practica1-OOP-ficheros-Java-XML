package practica1_java;

import java.io.Serializable;

public class Cliente implements Serializable{
    
    private String nombre;
    private String apellido;
    private String telefono;
    private boolean vip;
    private ListaPresupuesto lista;
    
    public Cliente(){
        
    }

    public Cliente(String nombre, String apellido, String telefono, boolean vip) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.vip = vip;
        this.lista = new ListaPresupuesto();
        
    }

    public ListaPresupuesto getLista() {
        return lista;
    }

    public void setLista(ListaPresupuesto lista) {
        this.lista = lista;
    }       

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "{" + "nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", vip=" + vip + '}';
    }
    
    
    
}
