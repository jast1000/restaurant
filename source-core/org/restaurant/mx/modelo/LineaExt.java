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
public class LineaExt {
    private LineaOrden linea;
    private Platillo platillo;

    public LineaExt() {
    }

    public LineaExt(LineaOrden linea, Platillo platillo) {
        this.linea = linea;
        this.platillo = platillo;
    }

    public LineaOrden getLinea() {
        return linea;
    }

    public void setLinea(LineaOrden linea) {
        this.linea = linea;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("'$'####.##");
        return "<html><h3>" + platillo.getDescripcion() + " x " + linea.getCantPlatillo() + " = " + df.format(linea.getSubtotal()) + "</h3></html>";
    }
    
}
