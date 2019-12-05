/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author brunn
 */
@Entity
@Table(name="caixas")
public class Caixa {
    
    public static final String ABERTO = "Aberto";
    public static final String FECHADO = "Fechado";
    
    @Id
    @GeneratedValue
    private int id;
    
    private double vendido;
    private Date datainicio;
    private Date datafinal;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getVendido() {
        return vendido;
    }

    public void setVendido(double vendido) {
        this.vendido = vendido;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public Date getDatafinal() {
        return datafinal;
    }

    public void setDatafinal(Date datafinal) {
        this.datafinal = datafinal;
    }
    
    
    
}
