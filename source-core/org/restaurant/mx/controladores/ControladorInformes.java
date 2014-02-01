/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.controladores;

import com.jast.restaurante.interfaces.DatabaseAccess;
import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.modelo.InformeCorte;
import org.restaurant.mx.modelo.InformeMesero;
import org.restaurant.mx.modelo.TicketImpreso;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author JAST
 */
public class ControladorInformes implements DatabaseAccess {

	private final Logger log = Logger.getLogger(ControladorInformes.class);

	private ConectorBasico conector;
	private SimpleDateFormat sdf;

	public ControladorInformes() {
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	@Override
	public void init(ConectorBasico conector) {
		this.conector = conector;
	}

	/**
	 * Para imprimir o reimprimir un ticket
	 *
	 * @param ticket no de ticket.
	 * @return Las lineas del ticket.
	 */
	public List<TicketImpreso> buscarLineasTicket(Integer ticket) {
		List<TicketImpreso> ti = new ArrayList<TicketImpreso>();

		String sql = "SELECT * FROM TICKET_IMPRESO WHERE TICKET = " + ticket;
		log.info(sql);

		Object datos[][] = conector.consultar(sql);
		if (datos != null) {
			for (Object filaDatos[] : datos) {
				ti.add(new TicketImpreso((Integer) filaDatos[0],
						(Integer) filaDatos[1],
						(String) filaDatos[2],
						(Double) filaDatos[3],
						(Double) filaDatos[4],
						(Integer) filaDatos[5],
						(Date) filaDatos[6]));
			}
		} else {
			return null;
		}
		return ti;
	}

	/**
	 * Obtiene una lista de ventas por mesero.
	 *
	 * @param idMesero id del mesero.
	 * @param inicio fecha inicio busqueda
	 * @param fin fecha fin busqueda.
	 * @return Lista de InformeMesero
	 */
	public List<InformeMesero> listarVentasMesero(Integer idMesero, Date inicio, Date fin) {
		String sql = "";
		if (inicio != null && fin != null) {
			String fechaI = "'" + sdf.format(inicio) + "'";
			String fechaF = "'" + sdf.format(fin) + "'";

			sql = "SELECT * FROM INFORME_MESERO WHERE ID_EMPLEADO = " + idMesero
					+ " AND FECHA_CORTE BETWEEN " + fechaI + " AND " + fechaI;
		} else {
			sql = "SELECT * FROM INFORME_MESERO WHERE ID_EMPLEADO = " + idMesero;
		}
		log.info(sql);

		Object datos[][] = conector.consultar(sql);
		List<InformeMesero> lim;
		if (datos != null) {
			lim = new ArrayList<>(datos.length);
			for (Object filaDatos[] : datos) {
				lim.add(new InformeMesero((Integer) filaDatos[0],
						(String) filaDatos[1],
						(Integer) filaDatos[2],
						(Double) filaDatos[3],
						(Date) filaDatos[4],
						(Date) filaDatos[5]));
			}
		} else {
			lim = new ArrayList<>(0);
		}
		return lim;
	}

	public List<InformeCorte> listarInformeCaja(Date inicio, Date fin) {
		String fechaI = "'" + sdf.format(inicio) + "'";
		String fechaF = "'" + sdf.format(fin) + "'";

		String sql = "SELECT * FROM INFORME_CORTE_CAJA WHERE FECHA_PAGO BETWEEN " + fechaI + " AND " + fechaF;
		log.info(sql);

		Object datos[][] = conector.consultar(sql);
		List<InformeCorte> lic;
		if (datos != null) {
			lic = new ArrayList<>(datos.length);
			for (Object filaDatos[] : datos) {
				lic.add(new InformeCorte((Integer) filaDatos[0],
						(Double) filaDatos[1],
						(Double) filaDatos[2],
						(Double) filaDatos[3],
						(String) filaDatos[4],
						(Date) filaDatos[5]));
			}
		} else {
			lic = new ArrayList<>(0);
		}
		return lic;
	}

}
