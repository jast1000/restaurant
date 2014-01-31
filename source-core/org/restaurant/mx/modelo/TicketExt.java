/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.restaurant.mx.modelo;

import java.text.DecimalFormat;

/**
 *
 * @author JAST
 */
public class TicketExt {
    private EmpleadoInfo mesero;
    private Mesa mesa;
    private TicketInfo ticket;

    public TicketExt() {
    }

    public TicketExt(EmpleadoInfo mesero, Mesa mesa, TicketInfo ticket) {
        this.mesero = mesero;
        this.mesa = mesa;
        this.ticket = ticket;
    }

    public EmpleadoInfo getMesero() {
        return mesero;
    }

    public void setMesero(EmpleadoInfo mesero) {
        this.mesero = mesero;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public TicketInfo getTicket() {
        return ticket;
    }

    public void setTicket(TicketInfo ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("'$'####.##");
        return "<html><h3>Ticket: " + ticket.getIdTicket() + " - Mesa: " + mesa.getNumeroMesa() + " (" + mesero.getNoombres() + ") " + df.format(ticket.getTotal()) + "</h3></html>";
    }
}
