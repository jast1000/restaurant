/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.controladores;

import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.modelo.RestaurantInfo;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author Ray
 */
public class ControladorRestaurantInfo extends Controlador<RestaurantInfo> {

    private String campos[] = {"NOMBRE", "CIUDAD", "DIRECCION", "TELEFONO"};
    private ConectorBasico Conector;

    private final Logger log = Logger.getLogger(ControladorRestaurantInfo.class);

    public ControladorRestaurantInfo() {
        Conector = new ConectorBasico();
    }

    @Override
    public boolean agregar(RestaurantInfo clazz) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO restaurant values('");
        sql.append(clazz.getNombreRestaurant());
        sql.append("','");
        sql.append(clazz.getCiudad());
        sql.append("','");
        sql.append(clazz.getDireccion());
        sql.append("','");
        sql.append(clazz.getTelefono());
        sql.append("')");
        log.info(sql.toString());
        return Conector.actualizar(sql.toString());

    }

    @Override
    public boolean eliminar(RestaurantInfo clazz) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean actualizar(RestaurantInfo clazz) {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE RESTAURANT SET ");
        sb.append("NOMBRE = '");
        sb.append(clazz.getNombreRestaurant());
        sb.append("', CIUDAD = '");
        sb.append(clazz.getCiudad());
        sb.append("', DIRECCION = '");
        sb.append(clazz.getDireccion());
        sb.append("', TELEFONO = '");
        sb.append(clazz.getTelefono());
        sb.append("'");

        log.info(sb.toString());
        return Conector.actualizar(sb.toString());
    }

    @Override
    public RestaurantInfo buscar(Object id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<RestaurantInfo> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String listaCampos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public RestaurantInfo obtenerEmpresa() {
        RestaurantInfo ri = new RestaurantInfo();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RESTAURANT ");
        Object restaurant[][] = Conector.consultar(sql.toString());
        if (restaurant.length != 0) {
            ri.setNombreRestaurant((String) restaurant[0][0]);
            ri.setDireccion((String) restaurant[0][1]);
            ri.setCiudad((String) restaurant[0][2]);
            ri.setTelefono((String) restaurant[0][3]);
        } else return null;
        return ri;
    }
}
