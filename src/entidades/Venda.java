/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author brunn
 */
@Entity
@Table(name="vendas")
public class Venda {
    
    public static final String ABERTO = "Aberto";
    public static final String FECHADO = "Fechado";
    
    @Id
    @GeneratedValue
    private int id;
    private Date data;
    private double total;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "caixa")
    private Caixa caixa;
    
    @OneToMany(cascade = (CascadeType.ALL), fetch = FetchType.EAGER)
    @JoinColumn(name = "venda")
    private List<Item> itens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    
    
    
}
