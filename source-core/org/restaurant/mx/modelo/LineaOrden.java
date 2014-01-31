/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.modelo;

/**
 *
 * @author JAST
 */
public class LineaOrden {
    private Integer noOrden;
    private Integer ticket;
    private Integer noMesa;
    private Integer cantPlatillo;
    private Integer idPlatillo;
    private String observacion;
    private Boolean cobrado;

    public LineaOrden() {
    }

    public LineaOrden(Integer noOrden, Integer ticket, Integer noMesa, Integer cantPlatillo, Integer idPlatillo, String observacion, Boolean cobrado) {
        this.noOrden = noOrden;
        this.ticket = ticket;
        this.noMesa = noMesa;
        this.cantPlatillo = cantPlatillo;
        this.idPlatillo = idPlatillo;
        this.observacion = observacion;
        this.cobrado = cobrado;
    }

    public Integer getNoOrden() {
        return noOrden;
    }

    public void setNoOrden(Integer noOrden) {
        this.noOrden = noOrden;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    public Integer getNoMesa() {
        return noMesa;
    }

    public void setNoMesa(Integer noMesa) {
        this.noMesa = noMesa;
    }

    public Integer getCantPlatillo() {
        return cantPlatillo;
    }

    public void setCantPlatillo(Integer cantPlatillo) {
        this.cantPlatillo = cantPlatillo;
    }

    public Integer getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Integer idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(Boolean cobrado) {
        this.cobrado = cobrado;
    }

    @Override
    public String toString() {
        return "LineaOrden{" + "noOrden=" + noOrden + ", ticket=" + ticket + ", noMesa=" + noMesa + ", cantPlatillo=" + cantPlatillo + ", idPlatillo=" + idPlatillo + ", observacion=" + observacion + ", cobrado=" + cobrado + '}';
    }
}