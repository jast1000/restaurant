/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.controladores;

import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.modelo.LineaOrden;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author JAST
 */
public class ControladorLineaOrden extends Controlador<LineaOrden> {

    private final Logger log = Logger.getLogger(ControladorLineaOrden.class);

    private ConectorBasico conector;

    public ControladorLineaOrden() {
        conector = new ConectorBasico();
    }

    @Override
    public boolean eliminar(LineaOrden clazz) {
        String sql = "DELETE FROM LINEA_ORDEN WHERE NO_ORDEN = " + clazz.getNoOrden();
        log.info(sql);

        return conector.actualizar(sql);
    }

    @Override
    public boolean actualizar(LineaOrden clazz) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE LINEA_ORDEN SET TICKET = ");
        sql.append(clazz.getTicket());
        sql.append(", NO_MESA = ");
        sql.append(clazz.getNoMesa());
        sql.append(", CANT_PLATILLO = ");
        sql.append(clazz.getCantPlatillo());
        sql.append(", ID_PLATILLO = ");
        sql.append(clazz.getIdPlatillo());
        sql.append(", OBSERVACION = '");
        sql.append(clazz.getObservacion());
        sql.append("', COBRADO = ");
        sql.append(clazz.isCobrado());
        sql.append(" WHERE NO_ORDEN = ");
        sql.append(clazz.getNoOrden());

        log.info(sql.toString());

        return conector.actualizar(sql.toString());
    }

    @Override
    public boolean agregar(LineaOrden clazz) {
        Integer id = new ControladorSecuencia().aumentarSecuencia("LINEA_ORDEN");

        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO LINEA_ORDEN VALUES(");
        sb.append(id);
        sb.append(",");
        sb.append(clazz.getTicket());
        sb.append(",");
        sb.append(clazz.getNoMesa());
        sb.append(",");
        sb.append(clazz.getCantPlatillo());
        sb.append(",");
        sb.append(clazz.getIdPlatillo());
        sb.append(", '");
        sb.append(clazz.getObservacion());
        sb.append("',");
        sb.append(clazz.isCobrado());
        sb.append(")");

        log.info(sb.toString());

        boolean ok = conector.actualizar(sb.toString());
        if (ok) {
            return true;
        } else {
            new ControladorSecuencia().disminuirSecuencia("LINEA_ORDEN");
            return false;
        }
    }

    @Override
    public LineaOrden buscar(Object id) {
        LineaOrden lo = new LineaOrden();
        String sql = "SELECT * FROM LINEA_ORDEN WHERE NO_ORDEN = " + id;
        log.info(sql);

        Object datos[][] = conector.consultar(sql);
        if (datos != null) {
            lo.setNoOrden((Integer) datos[0][0]);
            lo.setTicket((Integer) datos[0][1]);
            lo.setNoMesa((Integer) datos[0][2]);
            lo.setCantPlatillo((Integer) datos[0][3]);
            lo.setIdPlatillo((Integer) datos[0][4]);
            lo.setObservacion((String) datos[0][5]);
            lo.setCobrado((Boolean) datos[0][6]);
        } else {
            return null;
        }
        return lo;
    }

    @Deprecated
    @Override
    public List<LineaOrden> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Deprecated
    @Override
    public String listaCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param idTicket id ticket
     * @param cobrado Opcional.
     * @param cortado Opcional.
     * @return
     */
    public List<LineaOrden> listarPorTicket(Integer idTicket, Boolean cobrado, Boolean cortado) {
        List<LineaOrden> lo = new ArrayList<LineaOrden>();
        String sql = "SELECT * FROM LINEA_ORDEN WHERE TICKET = " + idTicket
                + (cobrado ? " AND COBRADO = " + cobrado : "")
                + (cortado ? " AND CORTADO = " + cortado : "");
        log.info(sql);

        Object datos[][] = conector.consultar(sql);
        if (datos != null) {
            for (Object filaDato[] : datos) {
                lo.add(new LineaOrden((Integer) filaDato[0],
                        (Integer) filaDato[1],
                        (Integer) filaDato[2],
                        (Integer) filaDato[3],
                        (Integer) filaDato[4],
                        (String) filaDato[5],
                        (Boolean) filaDato[6]));
            }
        } else {
            return null;
        }
        return lo;
    }
}
