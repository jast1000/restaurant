package org.restaurant.mx.examples;

import org.apache.log4j.Logger;
import org.restaurant.mx.conector.ConectorUtil;
import org.restaurant.mx.util.ConexionInfo;

/**
 *
 * @author JAST
 */
public class ConfigFile {

	public static final Logger log = Logger.getLogger(ConfigFile.class);

	public static void main(String[] args) {
		ConectorUtil cu = new ConectorUtil();
		ConexionInfo ci = new ConexionInfo();

		//Para generar archivo requiero:
		ci.setUsuario("root");
		ci.setClave("chucho25");
		ci.setServidor("localhost");
		ci.setBd("test01");
		cu.setConInfo(ci);

		//Directorio para generar archivo.
		cu.createFile();
		ConexionInfo loadFile = cu.loadFile();
		log.info("Archivo generado: " + loadFile.toString());
                
                log.info("Meow!");
	}
}
