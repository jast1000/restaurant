package org.restaurant.mx.conector;

import org.restaurant.mx.util.ConexionInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author JAST
 */
public class ConectorBasico {

	private final Logger log = Logger.getLogger(ConectorBasico.class);
	private Connection conexion;

	public ConectorBasico() {
		//BasicConfigurator.configure();
	}
	
	private String[] getURL()
	{
		ConectorUtil con = new ConectorUtil();
		ConexionInfo prop = con.loadFile();
		String url[]=new String[3];
		url[0] = "jdbc:mysql://"+prop.getServidor()+"/"+prop.getBd();
		url[1] = prop.getUsuario();
		url[2] = prop.getClave();
		return url;
	}
	
	private boolean conectar() {
		boolean conectado = false;
		String url[] = getURL();
		try {
			log.info("Conectando...");
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url[0],url[1],url[2]);
			conectado = !conectado;
		} catch (ClassNotFoundException e) {
			log.error("Error", e);
		} catch (SQLException e) {
			log.error("Error", e);
		}
		return conectado;
	}

	private void desconectar() {
		try {
			if (!conexion.isClosed()) {
				conexion.close();
			}
		} catch (SQLException e) {
			log.error("Error", e);
		}
	}

	public boolean actualizar(String sql) {
		boolean actualizado = false;
		try {
			if (conectar()) {
				Statement statement = conexion.createStatement();
				actualizado = statement.execute(sql);
				desconectar();
				actualizado = true;
			}
		} catch (SQLException e) {
			log.error("Error", e);
		}
		return actualizado;
	}

	public Object[][] consultar(String sql) {
		Object registros[][] = null;
		try {
			if (conectar()) {
				Statement statement = conexion.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				if (rs != null) {
					log.info("Hay datos para leer");
					int cantidadFilas = 0;
					int cantidadColumnas = 0;
					if (rs.last()) {
						cantidadFilas = rs.getRow();
						cantidadColumnas = rs.getMetaData().getColumnCount();
						rs.beforeFirst();
					}
					registros = new Object[cantidadFilas][cantidadColumnas];
					while (rs.next()) {
						for (int i = 1; i <= cantidadColumnas; i++) {
							registros[rs.getRow() - 1][i - 1] = rs.getObject(i);
						}
					}
					rs.close();
					desconectar();
				} else {
					log.info("No hay datos para leer");
				}

			}
		} catch (SQLException e) {
			log.error("Error", e);
		}
		return registros;
	}
}
