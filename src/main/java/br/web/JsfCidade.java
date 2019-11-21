/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

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
    
    public void validateModelNo(FacesContext context, UIComponent comp,
			Object value) {

		System.out.println("inside validate method");

		int mno = (int) value;

		if (mno == 0) {
			((UIInput) comp).setValid(false);

			FacesMessage message = new FacesMessage(
					"O valor não pode ser 0");
			context.addMessage(comp.getClientId(context), message);

		}

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
