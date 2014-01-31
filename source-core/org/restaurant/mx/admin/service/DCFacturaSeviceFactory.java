/*
 * Proyecto:DCAdminDesktop
 * Fecha de creacion de archivo:8/01/2014 04:52:13 PM 
 */

package org.restaurant.mx.admin.service;

import org.developercircle.app.AppConfig;
import org.developercircle.base.service.AppServiceFactory;
import org.developercircle.base.service.CreationServiceExcetion;
import org.developercircle.base.service.IService;

/**
 *
 * @author Leonardo Guzman Reyes
 */
public class DCFacturaSeviceFactory extends AppServiceFactory{

	//Lista de servicios
	private static String VENTAS="ventas";
	
	@Override
	public void configure(AppConfig appConfig) {
	  config=appConfig;
	}

	@Override
	protected IService createService(String name, Object... params) throws CreationServiceExcetion {
		IService service=null;
		
		if(VENTAS.equals(name)){
		  return new VentasService();
		}
		
		return service;
	}

}
