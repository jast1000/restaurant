/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.util;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author JAST
 */
public class Encriptador {
	private String clave;
	private BasicTextEncryptor encriptador;
	public Encriptador() {
		clave = null;
		encriptador =  new BasicTextEncryptor();
		asignarClave();
	}

	public Encriptador(String clave) {
		this.clave = clave;
		encriptador =  new BasicTextEncryptor();
		asignarClave();
	}

	private void asignarClave()
	{
		encriptador.setPassword("123456");
	}
	
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String encriptar()
	{
		return encriptador.encrypt(clave);
	}
	
	public String desencriptar()
	{
		return encriptador.decrypt(clave);
	}
}
