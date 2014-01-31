/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.controladores;

import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.modelo.Corte;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author JAST
 */
public class ControladorCorte extends Controlador<Corte> {

    private final Logger log = Logger.getLogger(ControladorCorte.class);

    private ConectorBasico conector;

    public ControladorCorte() {
        conector = new ConectorBasico();
//        BasicConfigurator.configure();
    }

    @Override
    public boolean eliminar(Corte clazz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Corte clazz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean agregar(Corte clazz) {

        Integer id = new ControladorSecuencia().aumentarSecuencia("CORTE");

        String sql = "INSERT INTO CORTE VALUES(" + id + ", " + clazz.getTotal()
                + ", " + clazz.getTotal() + ", '" + clazz.getFechaCorte() + "')";
        log.info(sql);

        boolean ok = conector.actualizar(sql);

        if (ok) {
            return true;
        } else {
            new ControladorSecuencia().disminuirSecuencia("CORTE");
            return false;
        }
    }

    @Override
    public Corte buscar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Corte> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String listaCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
