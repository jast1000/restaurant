/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.modelo;

/**
 *
 * @author JAST
 */
public class Platillo {

    private Integer idPlatillo;
    private String descripcion;
    private Double precio;
    private Integer idCatPlatillo;
    private Boolean eliminado;

    public Platillo() {
    }

    public Platillo(Integer idPlatillo, String descripcion, Double precio, Integer idCatPlatillo, Boolean eliminado) {
        this.idPlatillo = idPlatillo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idCatPlatillo = idCatPlatillo;
        this.eliminado = eliminado;
    }

    public Integer getIdCatPlatillo() {
        return idCatPlatillo;
    }

    public void setIdCatPlatillo(Integer idCatPlatillo) {
        this.idCatPlatillo = idCatPlatillo;
    }

    public Integer getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Integer idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    
    @Override
    public String toString() {
        return "<html><h3>" + idPlatillo + " - " + descripcion + "</h3></html>";
    }
}
