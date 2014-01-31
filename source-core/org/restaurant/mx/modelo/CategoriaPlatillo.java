/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.modelo;

/**
 *
 * @author JAST
 */
public class CategoriaPlatillo {

    private Integer idCategoria;
    private Integer categoriaPadre;
    private String descripcion;
    private Boolean eliminado;
    
    public CategoriaPlatillo() {
    }

    public CategoriaPlatillo(Integer idCategoria, Integer categoriaPadre, String descripcion, Boolean eliminado) {
        this.idCategoria = idCategoria;
        this.categoriaPadre = categoriaPadre;
        this.descripcion = descripcion;
        this.eliminado = eliminado;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Integer getCategoriaPadre() {
        return categoriaPadre;
    }

    public void setCategoriaPadre(Integer categoriaPadre) {
        this.categoriaPadre = categoriaPadre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public String toString() {
        return "<html><h3>" + idCategoria + " - " + descripcion + "</h3></html>";
    }
    
    public CategoriaPlatillo getCategoriaPlatillo() {
        return this;
    }
}
