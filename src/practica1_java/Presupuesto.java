package practica1_java;

import java.io.Serializable;

public class Presupuesto implements Serializable{
    
    private Integer numero_presupuesto;
    private String concepto;
    private double precio_total;
    private String estado;
    
    public Presupuesto(){
        
    }

    public Presupuesto(Integer numero_presupuesto, String concepto, double precio_total, String estado) {
        this.numero_presupuesto = numero_presupuesto;
        this.concepto = concepto;
        this.precio_total = precio_total;
        this.estado = estado;
    }

    public Integer getNumero_presupuesto() {
        return numero_presupuesto;
    }

    public void setNumero_presupuesto(Integer numero_presupuesto) {
        this.numero_presupuesto = numero_presupuesto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Presupuesto{" + "numero_presupuesto=" + numero_presupuesto + ", concepto=" + concepto + ", precio_total=" + precio_total + ", estado=" + estado + '}';
    }

}
