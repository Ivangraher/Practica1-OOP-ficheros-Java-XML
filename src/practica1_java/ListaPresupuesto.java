package practica1_java;

import java.io.Serializable;
import java.util.ArrayList;


public class ListaPresupuesto implements Serializable{
    
    private ArrayList<Presupuesto> listaPresupuestos;
    
    public ListaPresupuesto(){
        listaPresupuestos = new ArrayList<>();
    }
    
    public void altaPresupuesto(Presupuesto p){
        listaPresupuestos.add(p);
    }

    public ArrayList<Presupuesto> getListaPresupuestos() {
        return listaPresupuestos;
    }

    public void setListaPresupuestos(ArrayList<Presupuesto> listaPresupuestos) {
        this.listaPresupuestos = listaPresupuestos;
    }
    
    public boolean existeNumPresupuesto(Integer numero_presupuesto){
        for(Presupuesto presu : listaPresupuestos){
            if(numero_presupuesto == presu.getNumero_presupuesto()){
              return true;
            }
        }
        return false;
    }
    
    
}
