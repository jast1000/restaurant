package com.jast.restaurante.caja;

import com.jast.restaurante.error.RestauranteException;
import com.jast.restaurante.interfaces.DatabaseAccess;
import java.util.List;
import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.modelo.TicketInfo;

/**
 *
 * @author José Bernardo Gómez-Andrade
 */
public class CorteCajaData implements DatabaseAccess {

	private ConectorBasico conector;

	@Override
	public void init(ConectorBasico conector) {
		this.conector = conector;
	}

	/**
	 * Lista los tickets por considerar en un cierre de caja.
	 * <p>
	 * Se supone.
	 *
	 * @return La lista de tickets.
	 * @throws RestauranteException Si no se pudo consultar.
	 */
	public List<TicketInfo> listarTickets() throws RestauranteException {
		
		return null;
	}

}
