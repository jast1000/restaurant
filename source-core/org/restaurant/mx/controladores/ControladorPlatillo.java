/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.controladores;

import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.modelo.Platillo;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author JAST
 */
public class ControladorPlatillo extends Controlador<Platillo> {

    private final Logger log = Logger.getLogger(ControladorPlatillo.class);

    private String campos[] = {"ID_PLATILLO", "DESCRIPCION", "PRECIO", "CATEGORIA", "ELIMINADO"};
    private ConectorBasico conector;

    public ControladorPlatillo() {
        conector = new ConectorBasico();
    }

    @Override
    public boolean eliminar(Platillo clazz) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM PLATILLO WHERE ");
        sql.append(campos[0]);
        sql.append(" = ");
        sql.append(clazz.getIdPlatillo());
        log.info(sql.toString());
        return conector.actualizar(sql.toString());
    }

    @Override
    public boolean actualizar(Platillo clazz) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE PLATILLO SET ");
        sql.append(campos[1]);
        sql.append(" = '");
        sql.append(clazz.getDescripcion());
        sql.append("', ");
        sql.append(campos[2]);
        sql.append(" = ");
        sql.append(clazz.getPrecio());
        sql.append(", ");
        sql.append(campos[3]);
        sql.append(" = ");
        sql.append(clazz.getIdCatPlatillo());
        sql.append(", ELIMINADO = ");
        sql.append(clazz.isEliminado());
        sql.append(" WHERE ");
        sql.append(campos[0]);
        sql.append(" = ");
        sql.append(clazz.getIdPlatillo());
        log.info(sql.toString());
        return conector.actualizar(sql.toString());
    }

    @Override
    public boolean agregar(Platillo clazz) {

        Integer id = new ControladorSecuencia().aumentarSecuencia("PLATILLO");

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO PLATILLO(");
        sql.append(campos[0]);
        sql.append(", ");
        sql.append(campos[1]);
        sql.append(", ");
        sql.append(campos[2]);
        sql.append(", ");
        sql.append(campos[3]);
        sql.append(", ELIMINADO) VALUES(");
        sql.append(clazz.getIdPlatillo());
        sql.append(", '");
        sql.append(clazz.getDescripcion());
        sql.append("', ");
        sql.append(clazz.getPrecio());
        sql.append(", ");
        sql.append(clazz.getIdCatPlatillo());
        sql.append(", ");
        sql.append(clazz.isEliminado());
        sql.append(")");
        log.info(sql.toString());

        boolean ok = conector.actualizar(sql.toString());
        if (ok) {
            return true;
        } else {
            new ControladorSecuencia().disminuirSecuencia("PLATILLO");
            return false;
        }
    }

    @Override
    public Platillo buscar(Object id) {
        Platillo p = new Platillo();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(listaCampos());
        sql.append(" WHERE ");
        sql.append(campos[0]);
        sql.append(" = ");
        sql.append(id);
        sql.append(" AND ELIMINADO = FALSE");
        Object platillo[][] = conector.consultar(sql.toString());
        if (platillo.length != 0) {
            p.setIdPlatillo((Integer) platillo[0][0]);
            p.setDescripcion((String) platillo[0][1]);
            p.setPrecio((Double) platillo[0][2]);
            p.setIdCatPlatillo((Integer) platillo[0][3]);
            p.setEliminado((Boolean) platillo[0][4]);
        } else {
            return null;
        }
        return p;
    }

    @Override
    public List<Platillo> listar() {
        List<Platillo> platillos = new ArrayList<Platillo>(1);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(listaCampos());
        sql.append(" WHERE ELIMINADO = FALSE");
        Object plat[][] = conector.consultar(sql.toString());
        if (plat.length != 0) {
            for (Object filaPlatillo[] : plat) {
                platillos.add(new Platillo((Integer) filaPlatillo[0],
                        (String) filaPlatillo[1],
                        (Double) filaPlatillo[2],
                        (Integer) filaPlatillo[3],
                        (Boolean) filaPlatillo[4]));
            }
        } else {
            return null;
        }
        return platillos;
    }

    public List<Platillo> listarPorCategoria(Integer idCat) {
        List<Platillo> platillos = new ArrayList<Platillo>(1);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(listaCampos());
        sql.append(" WHERE CATEGORIA = ");
        sql.append(idCat);
        sql.append(" AND ELIMINADO = FALSE");
        Object plat[][] = conector.consultar(sql.toString());
        if (plat.length != 0) {
            for (Object filaPlatillo[] : plat) {
                platillos.add(new Platillo((Integer) filaPlatillo[0],
                        (String) filaPlatillo[1],
                        (Double) filaPlatillo[2],
                        (Integer) filaPlatillo[3],
                        (Boolean) filaPlatillo[4]));
            }
        } else {
            return null;
        }
        return platillos;
    }
    
    public List<Platillo> listarPorFiltro(Integer idCat, String nombre) {
        List<Platillo> platillos = new ArrayList<Platillo>(1);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(listaCampos());
        sql.append(" WHERE ");
        sql.append(" DESCRIPCION LIKE '%");
        sql.append(nombre != null ? nombre : "");
        sql.append("%'");
        if(idCat != null) {
            sql.append(" AND CATEGORIA = ");
            sql.append(idCat);
        }
        sql.append(" AND ELIMINADO = FALSE");
        Object plat[][] = conector.consultar(sql.toString());
        if (plat.length != 0) {
            for (Object filaPlatillo[] : plat) {
                platillos.add(new Platillo((Integer) filaPlatillo[0],
                        (String) filaPlatillo[1],
                        (Double) filaPlatillo[2],
                        (Integer) filaPlatillo[3],
                        (Boolean) filaPlatillo[4]));
            }
        } else {
            return null;
        }
        return platillos;
    }
    
    @Override
    public String listaCampos() {
        StringBuilder sql = new StringBuilder();
        for (String campo : campos) {
            sql.append(campo);
            sql.append(",");
        }
        return sql.substring(0, sql.length() - 1) + " FROM PLATILLO";
    }
}
