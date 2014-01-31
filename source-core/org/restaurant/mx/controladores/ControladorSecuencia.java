/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.restaurant.mx.controladores;

import org.restaurant.mx.conector.ConectorBasico;
import java.text.SimpleDateFormat;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author JAST
 */
public class ControladorSecuencia {
    
    private final Logger log = Logger.getLogger(ControladorSecuencia.class);

    private ConectorBasico conector;
    
    public ControladorSecuencia() {
        conector = new ConectorBasico();
    }
 
    public Integer aumentarSecuencia(String nombreTabla) {
        Integer no = null;
        String sql = "CALL AUMENTAR_SECUENCIA('" + nombreTabla + "')";
        log.info(sql);
        Object datos[][] = conector.consultar(sql);
        no = (Integer) datos[0][0];
        return no;
    }
    
    public void disminuirSecuencia(String nombreTabla) {
        String sql = "CALL DISMINUIR_SECUENCIA('" + nombreTabla + "')";
        log.info(sql);
        conector.actualizar(sql);
    }
}
