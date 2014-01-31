/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.modelo;

import java.util.Date;

/**
 *
 * @author JAST
 */
public class TicketImpreso {

    private Integer ticket;
    private Integer cantidad;
    private String platillo;
    private Double precio;
    private Double subtotal;
    private Integer mesa;
    private Date fecha;

    public TicketImpreso() {
    }

    public TicketImpreso(Integer ticket, Integer cantidad, String platillo, Double precio, Double subtotal, Integer mesa, Date fecha) {
        this.ticket = ticket;
        this.cantidad = cantidad;
        this.platillo = platillo;
        this.precio = precio;
        this.subtotal = subtotal;
        this.mesa = mesa;
        this.fecha = fecha;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getPlatillo() {
        return platillo;
    }

    public void setPlatillo(String platillo) {
        this.platillo = platillo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "TicketImpreso{" + "ticket=" + ticket + ", cantidad=" + cantidad + ", platillo=" + platillo + ", precio=" + precio + ", subtotal=" + subtotal + ", mesa=" + mesa + ", fecha=" + fecha + '}';
    }

}
