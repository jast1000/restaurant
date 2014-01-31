/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.util;

/**
 *
 * @author JAST
 */
public class ConexionInfo {

	private String servidor;
	private String bd;
	private String usuario;
	private String clave;

	public ConexionInfo() {
	}

	public ConexionInfo(String servidor, String bd, String usuario, String clave) {
		this.servidor = servidor;
		this.bd = bd;
		this.usuario = usuario;
		this.clave = clave;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "ConexionInfo{" + "servidor=" + servidor + ", bd=" + bd + ", usuario=" + usuario + ", clave=" + clave + '}';
	}
}
