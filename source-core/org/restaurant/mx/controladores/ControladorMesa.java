/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.controladores;

import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.modelo.Mesa;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author JAST
 */
public class ControladorMesa extends Controlador<Mesa> {

    private final Logger log = Logger.getLogger(ControladorMesa.class);

    private String campos[] = {"NO_MESA", "DISPONIBLE"};
    private ConectorBasico conector;

    public ControladorMesa() {
        conector = new ConectorBasico();
    }

    @Override
    public boolean eliminar(Mesa clazz) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM MESA WHERE ");
        sql.append(campos[0]);
        sql.append(" = ");
        sql.append(clazz.getNumeroMesa());
        log.info(sql.toString());
        return conector.actualizar(sql.toString());
    }

    @Override
    public boolean actualizar(Mesa clazz) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE MESA SET ");
        sql.append(campos[1]);
        sql.append(" = ");
        sql.append(clazz.getDisponible());
        sql.append(" WHERE ");
        sql.append(campos[0]);
        sql.append(" = ");
        sql.append(clazz.getNumeroMesa());
        log.info(sql.toString());
        return conector.actualizar(sql.toString());
    }

    @Override
    public boolean agregar(Mesa clazz) {

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO MESA(");
        sql.append(campos[0]);
        sql.append(", ");
        sql.append(campos[1]);
        sql.append(") VALUES(");
        sql.append(clazz.getNumeroMesa());
        sql.append(", ");
        sql.append(clazz.getDisponible());
        sql.append(")");
        log.info(sql.toString());

        return conector.actualizar(sql.toString());
//        if (ok) {
//            return true;
//        } else {
//            new ControladorSecuencia().disminuirSecuencia("MESA");
//            return false;
//        }
    }

    @Override
    public Mesa buscar(Object id) {
        Mesa m = new Mesa();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(listaCampos());
        sql.append(" WHERE ");
        sql.append(campos[0]);
        sql.append(" = ");
        sql.append(id);
        Object mesa[][] = conector.consultar(sql.toString());
        if (mesa != null) {
            m.setNumeroMesa((Integer) mesa[0][0]);
            m.setDisponible((Boolean) mesa[0][1]);
        } else {
            return null;
        }
        return m;
    }

    @Override
    public List<Mesa> listar() {
        List<Mesa> mesas = new ArrayList<Mesa>(1);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT *");
        sql.append(" FROM MESA");
        Object mesa[][] = conector.consultar(sql.toString());
        if (mesa != null) {
            for (Object filaMesa[] : mesa) {
                mesas.add(new Mesa((Integer) filaMesa[0], (Boolean) filaMesa[1]));
            }
        } else {
            return null;
        }
        return mesas;
    }

    public List<Mesa> listarPorEstado(boolean estado) {
        List<Mesa> mesas = new ArrayList<Mesa>(1);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(listaCampos());
        sql.append(" WHERE ");
        sql.append(campos[1]);
        sql.append(" = ");
        sql.append(estado);
        Object mesa[][] = conector.consultar(sql.toString());
        if (mesa != null) {
            for (Object filaMesa[] : mesa) {
                mesas.add(new Mesa((Integer) filaMesa[0], (Boolean) filaMesa[1]));
            }
        } else {
            return null;
        }
        return mesas;
    }

    @Override
    public String listaCampos() {
        StringBuilder sql = new StringBuilder();
        for (String campo : campos) {
            sql.append(campo);
            sql.append(",");
        }
        return sql.substring(0, sql.length() - 1) + " FROM MESA";
    }
}
