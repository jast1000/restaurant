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
public class TicketInfo {
    private Integer idTicket;
    private Integer empleado;
    private Double total;
    private Date fechaReg;
    private Boolean cobrado;
    private Date fechaPagado;
    private Double recibio;
    private Double cambio;
    private Boolean cortado;
    private Date fechaCorte;
    private Integer mesa;
    
    public TicketInfo() {
    }

    public TicketInfo(Integer idTicket, Integer empleado, Double total, Date fechaReg, Boolean cobrado, Date fechaPagado, Double recibio, Double cambio, Boolean cortado, Date fechaCorte, Integer mesa) {
        this.idTicket = idTicket;
        this.empleado = empleado;
        this.total = total;
        this.fechaReg = fechaReg;
        this.cobrado = cobrado;
        this.fechaPagado = fechaPagado;
        this.recibio = recibio;
        this.cambio = cambio;
        this.cortado = cortado;
        this.fechaCorte = fechaCorte;
        this.mesa = mesa;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Integer empleado) {
        this.empleado = empleado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    public Boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(Boolean cobrado) {
        this.cobrado = cobrado;
    }

    public Date getFechaPagado() {
        return fechaPagado;
    }

    public void setFechaPagado(Date fechaPagado) {
        this.fechaPagado = fechaPagado;
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

    public Boolean isCortado() {
        return cortado;
    }

    public void setCortado(Boolean cortado) {
        this.cortado = cortado;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }
    

    @Override
    public String toString() {
        return "TicketInfo{" + "idTicket=" + idTicket + ", empleado=" + empleado + ", total=" + total + ", fechaReg=" + fechaReg + ", cobrado=" + cobrado + ", fechaPagado=" + fechaPagado + ", recibio=" + recibio + ", cambio=" + cambio + ", cortado=" + cortado + ", fechaCorte=" + fechaCorte + '}';
    }
}
