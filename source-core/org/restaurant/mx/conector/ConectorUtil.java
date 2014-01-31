package org.restaurant.mx.conector;

import java.io.File;
import org.restaurant.mx.util.ConexionInfo;
import org.restaurant.mx.util.Encriptador;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author JAST
 */
public class ConectorUtil {

	private final Logger log = Logger.getLogger(ConectorUtil.class);
	private ConexionInfo conInfo;
	private Encriptador enc;
	private Properties properties;
	private File cfgFile;
	private final String propestiesKey[] = {"servidor", "db", "usuario", "password"};

	public ConectorUtil() {
		enc = new Encriptador();
//		BasicConfigurator.configure();
		properties = new Properties();

		cfgFile = new File(String.format("%s%s%s",
				System.getProperty("user.home"),
				System.getProperty("file.separator"),
				"restaurant.properties"));
	}

	public void setConInfo(ConexionInfo conInfo) {
		this.conInfo = conInfo;
	}

	public void createFile() {
		try {
			log.info("Asignando propiedades");
			properties.setProperty(propestiesKey[0], conInfo.getServidor());
			properties.setProperty(propestiesKey[1], conInfo.getBd());
			properties.setProperty(propestiesKey[2], conInfo.getUsuario());

			log.info("Encriptamos la clave");
			enc.setClave(conInfo.getClave());
			conInfo.setClave(enc.encriptar());
			properties.setProperty(propestiesKey[3], conInfo.getClave());

			log.info("creamos el archivo");
			properties.store(new FileOutputStream(cfgFile), "Archivo de configuracion de Restaurant");

		} catch (IOException e) {
			log.error("Error", e);
		}
	}

	public ConexionInfo loadFile() {
		conInfo = new ConexionInfo();
		try {
			log.info("Lectura del archivo");
			properties.load(new FileInputStream(cfgFile));

			log.info("Obtenemos las propiedades");
			conInfo.setServidor(properties.getProperty(propestiesKey[0]));
			conInfo.setBd(properties.getProperty(propestiesKey[1]));
			conInfo.setUsuario(properties.getProperty(propestiesKey[2]));
			conInfo.setClave(properties.getProperty(propestiesKey[3]));

			log.info("Desencriptando....");
			enc.setClave(conInfo.getClave());
			conInfo.setClave(enc.desencriptar());
		} catch (IOException e) {
			log.error("Error", e);
		}
		return conInfo;
	}
}
