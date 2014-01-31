/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.modelo;

/**
 *
 * @author JAST
 */
public class Mesa {
	private Integer numeroMesa;
	private Boolean disponible;

	public Mesa() {
	}

	public Mesa(Integer numeroMesa, Boolean disponible) {
		this.numeroMesa = numeroMesa;
		this.disponible = disponible;
	}

	public Integer getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
            if(disponible) return "<html><h3>Mesa: " + numeroMesa + "</h3></html>";
            else return "<html><h3><font color=\"red\">Mesa: " + numeroMesa + "</font></h3></html>";
        }
	
}
