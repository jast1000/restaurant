/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.controladores;

import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.modelo.TicketInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author JAST
 */
public class ControladorTicket extends Controlador<TicketInfo> {

    private final Logger log = Logger.getLogger(ControladorTicket.class);
    private ConectorBasico conector;

    public ControladorTicket() {
        conector = new ConectorBasico();
    }

    @Override
    public boolean eliminar(TicketInfo clazz) {
        String sql1 = "DELETE FROM LINEA_CORTE WHERE TICKET = " + clazz.getIdTicket();
        String sql2 = "DELETE FROM TICKET WHERE TICKET = " + clazz.getIdTicket();

        log.info(sql1);
        log.info(sql2);

        return conector.actualizar(sql1) && conector.actualizar(sql2);
    }

    @Override
    public boolean actualizar(TicketInfo clazz) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String sql = "UPDATE TICKET SET ID_EMPLEADO = " + clazz.getIdTicket() + ", TOTAL = "
                + clazz.getTotal() + ", FECHA_REG = '" + sdf.format(clazz.getFechaReg()) + "', COBRADO = "
                + clazz.isCobrado() + ", FECHA_PAGADO = '" + sdf.format(clazz.getFechaPagado()) + "', RECIBIO = "
                + clazz.getRecibio() + ", CAMBIO = " + clazz.getCambio() + ", CORTADO = " + clazz.isCortado()
                + ", FECHACORTE = '" + sdf.format(clazz.getFechaCorte()) + "' WHERE TICKET = " + clazz.getIdTicket();
        log.info(sql);

        return conector.actualizar(sql);
    }

    @Override
    public boolean agregar(TicketInfo clazz) {
        Integer id = new ControladorSecuencia().aumentarSecuencia("TICKET");

        String sql = "INSERT INTO TICKET VALUES("
                + clazz.getIdTicket() + ", " + clazz.getEmpleado() + ", " + clazz.getTotal()
                + ", '" + clazz.getFechaReg() + "', " + clazz.isCobrado() + ", '"
                + clazz.getFechaPagado() + "', " + clazz.getRecibio() + ", " + clazz.getCambio()
                + ", " + clazz.isCortado() + ", '" + clazz.getFechaCorte() + "')";
        log.info(sql);

        boolean ok = conector.actualizar(sql);
        if (ok) {
            return true;
        } else {
            new ControladorSecuencia().disminuirSecuencia("TICKET");
            return false;
        }
    }

    @Override
    public TicketInfo buscar(Object id) {
        TicketInfo t;
        String sql = "SELECT * FROM TICKET WHERE TICKET = " + id;
        log.info(sql);

        Object datos[][] = conector.consultar(sql);
        if (datos != null) {
            t = new TicketInfo((Integer) datos[0][0],
                    (Integer) datos[0][1],
                    (Double) datos[0][2],
                    (Date) datos[0][3],
                    (Boolean) datos[0][4],
                    (Date) datos[0][5],
                    (Double) datos[0][6],
                    (Double) datos[0][7],
                    (Boolean) datos[0][8],
                    (Date) datos[0][9]);
        } else {
            return null;
        }
        return t;
    }

    @Deprecated
    @Override
    public List<TicketInfo> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Deprecated
    @Override
    public String listaCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<TicketInfo> listarPorEstadoCortado(boolean cobrado) {
        List<TicketInfo> ti = new ArrayList<TicketInfo>();

        String sql = "SELECT * FROM TICKET WHERE COBRADO = " + cobrado;
        log.info(sql);

        Object datos[][] = conector.consultar(sql);
        if (datos != null) {
            for (Object filaDato[] : datos) {
                ti.add(new TicketInfo((Integer) datos[0][0],
                        (Integer) datos[0][1],
                        (Double) datos[0][2],
                        (Date) datos[0][3],
                        (Boolean) datos[0][4],
                        (Date) datos[0][5],
                        (Double) datos[0][6],
                        (Double) datos[0][7],
                        (Boolean) datos[0][8],
                        (Date) datos[0][9]));
            }
        } else {
            return null;
        }
        return ti;
    }

    public List<TicketInfo> listarPagadosPorFechas(Date inicio, Date fin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<TicketInfo> ti = new ArrayList<TicketInfo>();

        String sql = "SELECT * FROM TICKET WHERE FECHA_PAGADO BETWEEN '"
                + sdf.format(inicio) + "' AND '" + sdf.format(fin) + "'";
        log.info(sql);

        Object datos[][] = conector.consultar(sql);
        if (datos != null) {
            for (Object filaDato[] : datos) {
                ti.add(new TicketInfo((Integer) datos[0][0],
                        (Integer) datos[0][1],
                        (Double) datos[0][2],
                        (Date) datos[0][3],
                        (Boolean) datos[0][4],
                        (Date) datos[0][5],
                        (Double) datos[0][6],
                        (Double) datos[0][7],
                        (Boolean) datos[0][8],
                        (Date) datos[0][9]));
            }
        } else {
            return null;
        }
        return ti;
    }
}
