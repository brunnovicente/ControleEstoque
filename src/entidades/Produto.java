/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author brunn
 */
@Entity
@Table(name="produtos")
public class Produto {
    
    public static final int ATIVO = 1;
    public static final int DESATIVADO = 0;
    
    @Id
    @GeneratedValue
    private int id;
    
    private String codigobarras;
    private String descricao;
    private double preco;
    private int estoque;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCodigoBarras() {
        return codigobarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigobarras = codigoBarras;
    }
    
}
