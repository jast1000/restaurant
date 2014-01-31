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
public class Corte {
    private Integer idCorte;
    private Double total;
    private Integer ticketsCortados;
    private Date fechaCorte;

    public Corte() {
    }

    public Corte(Integer idCorte, Double total, Integer ticketsCortados, Date fechaCorte) {
        this.idCorte = idCorte;
        this.total = total;
        this.ticketsCortados = ticketsCortados;
        this.fechaCorte = fechaCorte;
    }

    public Integer getIdCorte() {
        return idCorte;
    }

    public void setIdCorte(Integer idCorte) {
        this.idCorte = idCorte;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getTicketsCortados() {
        return ticketsCortados;
    }

    public void setTicketsCortados(Integer ticketsCortados) {
        this.ticketsCortados = ticketsCortados;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    @Override
    public String toString() {
        return "Corte{" + "idCorte=" + idCorte + ", total=" + total + ", ticketsCortados=" + ticketsCortados + ", fechaCorte=" + fechaCorte + '}';
    }
    
}
