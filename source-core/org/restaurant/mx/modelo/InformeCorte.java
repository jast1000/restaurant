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
public class InformeCorte {
    private Integer idTicket;
    private Double total;
    private Double recibio;
    private Double cambio;
    private String empleado;
    private Date fecha;

    public InformeCorte() {
    }

    public InformeCorte(Integer idTicket, Double total, Double recibio, Double cambio, String empleado, Date fecha) {
        this.idTicket = idTicket;
        this.total = total;
        this.recibio = recibio;
        this.cambio = cambio;
        this.empleado = empleado;
        this.fecha = fecha;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getRecibio() {
        return recibio;
    }

    public void setRecibio(Double recibio) {
        this.recibio = recibio;
    }

    public Double getCambio() {
        return cambio;
    }

    public void setCambio(Double cambio) {
        this.cambio = cambio;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "InformeCorte{" + "idTicket=" + idTicket + ", total=" + total + ", recibio=" + recibio + ", cambio=" + cambio + ", empleado=" + empleado + ", fecha=" + fecha + '}';
    }
}
