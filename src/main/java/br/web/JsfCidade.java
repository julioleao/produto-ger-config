/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author alexandrelerario
 */
@Named(value = "jsfCidade")
@SessionScoped
public class JsfCidade implements Serializable {

    /**
     * Creates a new instance of JsfCidade
     */
    public JsfCidade() {
    }
    
    private int codigo;
    private String nome;
    private int latitude;
    private int longitude;




    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    
    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
    
    public void persist(){
        br.data.entity.Cidade cid = new br.data.entity.Cidade();
        cid.setCodigo(codigo);
        cid.setNome(nome);
        cid.setLatitude(latitude);
        cid.setLongitude(longitude);
        new br.data.crud.CrudCidade().persist(cid);
    }
    
    public java.util.Collection<br.data.entity.Cidade> getAll(){
        return new br.data.crud.CrudCidade().getAll();
    }
}
