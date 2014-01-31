/*
 * Proyecto:DCAdminDesktop
 * Fecha de creacion de archivo:24/01/2014 08:33:53 PM 
 */

package org.restaurant.mx.admin.service;

import org.developercircle.base.service.IService;

/**
 *
 * @author Leonardo Guzman Reyes
 */
public class VentasService implements IService{

	@Override
	public String getName() {
		return "ventas";
	}
	
	public void guardarVenta(String venta){
	  System.out.println("VEnta guardada");
	}

}
