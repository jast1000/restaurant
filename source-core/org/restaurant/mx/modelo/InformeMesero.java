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
public class InformeMesero {
    private Integer idMesero;
    private String nombre;
    private Integer ticket;
    private Double total;
    private Date fechaPago;
    private Date fechaCorte;

    public InformeMesero() {
    }

    public InformeMesero(Integer idMesero, String nombre, Integer ticket, Double total, Date fechaPago, Date fechaCorte) {
        this.idMesero = idMesero;
        this.nombre = nombre;
        this.ticket = ticket;
        this.total = total;
        this.fechaPago = fechaPago;
        this.fechaCorte = fechaCorte;
    }

    public Integer getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(Integer idMesero) {
        this.idMesero = idMesero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    @Override
    public String toString() {
        return "InformeMesero{" + "idMesero=" + idMesero + ", nombre=" + nombre + ", ticket=" + ticket + ", total=" + total + ", fechaPago=" + fechaPago + ", fechaCorte=" + fechaCorte + '}';
    }
    
}
