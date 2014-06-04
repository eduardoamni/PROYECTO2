/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoTPV;

/**
 *
 * @author edu
 */
public class CierreTurno {
    
    private int operaciones ;
    private double total ;
    private double cambio ;
    private String turno ;
    
    
    public CierreTurno(double cambio, boolean turno) {
        this.cambio = cambio;
        if(turno==false){
            this.turno="MAÑANA";
        }else{
            this.turno="TARDE";
        }
    }

    public void setOperaciones() {
        
        this.operaciones ++;
    }
    
    public void setTotal(double total) {
        this.total += total;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
    
    public double totalCaja (){
        return total+cambio;
    }

    public int getOperaciones() {
        return operaciones;
    }

    public double getTotal() {
        return total;
    }

    public double getCambio() {
        return cambio;
    }

    public String getTurno() {
        return turno;
    }

    
    
    
    
}
