/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.restaurant.mx.modelo;

/**
 *
 * @author JAST
 */
public class CategoriaExt extends CategoriaPlatillo {

    public void setCategoriaPlatillo(CategoriaPlatillo cp) {
        setCategoriaPadre(cp.getCategoriaPadre());
        setDescripcion(cp.getDescripcion());
        setEliminado(cp.isEliminado());
        setIdCategoria(cp.getIdCategoria());
    }
    
    @Override
    public String toString() {
        return getDescripcion();
    }   
}
