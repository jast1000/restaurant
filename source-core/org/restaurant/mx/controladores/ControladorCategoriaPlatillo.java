/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.controladores;

import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.modelo.CategoriaPlatillo;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author JAST
 */
public class ControladorCategoriaPlatillo extends Controlador<CategoriaPlatillo> {

    private final Logger log = Logger.getLogger(ControladorCategoriaPlatillo.class);

    private String campos[] = {"ID_CATEGORIA", "CATEGORIA_PADRE", "DESCRIPCION", "ELIMINADO"};
    private ConectorBasico conector;

    private ControladorSecuencia cs;

    public ControladorCategoriaPlatillo() {
        conector = new ConectorBasico();
//		BasicConfigurator.configure();
        cs = new ControladorSecuencia();
    }

    @Override
    public boolean eliminar(CategoriaPlatillo clazz) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM CATEGORIA_PLATILLO WHERE ");
        sql.append(campos[0]);
        sql.append(" = ");
        sql.append(clazz.getIdCategoria());
        log.info(sql.toString());
        return conector.actualizar(sql.toString());
    }

    @Override
    public boolean actualizar(CategoriaPlatillo clazz) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE CATEGORIA_PLATILLO SET ");
        sql.append(campos[1]);
        sql.append(" = ");
        sql.append(clazz.getCategoriaPadre() != null ? clazz.getCategoriaPadre() : null);
        sql.append(", ");
        sql.append(campos[2]);
        sql.append(" = '");
        sql.append(clazz.getDescripcion());
        sql.append("', ELIMINADO = ");
        sql.append(clazz.isEliminado());
        sql.append(" WHERE ");
        sql.append(campos[0]);
        sql.append(" = ");
        sql.append(clazz.getIdCategoria());
        log.info(sql.toString());
        return conector.actualizar(sql.toString());
    }

    /**
     * Método que permite dar de alto una nueva categoria de platillo
     *
     * @param clazz
     * @return <code>true</code> si se dio de alta correctamente
     */
    @Override
    public boolean agregar(CategoriaPlatillo clazz) {
        Integer id = cs.aumentarSecuencia("CATEGORIA_PLATILLO");

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO CATEGORIA_PLATILLO(");
        sql.append(campos[0]);
        sql.append(", ");
        sql.append(campos[1]);
        sql.append(", ");
        sql.append(campos[2]);
        sql.append(", ELIMINADO) VALUES(");
        sql.append(id);
        sql.append(", ");
        sql.append(clazz.getCategoriaPadre() != null ? clazz.getCategoriaPadre() : null);
        sql.append(", '");
        sql.append(clazz.getDescripcion());
        sql.append("', ");
        sql.append(clazz.isEliminado());
        sql.append(")");
        log.info(sql.toString());

        boolean ok = conector.actualizar(sql.toString());

        if (ok) {
            return true;
        } else {
            cs.disminuirSecuencia("CATEGORIA_PLATILLO");
            return false;
        }
    }

    /**
     * Método que permite buscar una categoria de platillo por su id
     *
     * @param id
     * @return <code>CategoriaPlatillo</code>
     */
    @Override
    public CategoriaPlatillo buscar(Object id) {
        CategoriaPlatillo cp = new CategoriaPlatillo();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(listaCampos());
        sql.append(" WHERE ");
        sql.append(campos[0]);
        sql.append(" = ");
        sql.append(id);

        log.info(sql.toString());
        Object catPla[][] = conector.consultar(sql.toString());
        if (catPla != null) {
            cp.setIdCategoria((Integer) catPla[0][0]);
            cp.setCategoriaPadre(catPla[0][1] != null ? (Integer) catPla[0][1] : null);
            cp.setDescripcion((String) catPla[0][2]);
            cp.setEliminado((Boolean) catPla[0][3]);
        } else {
            return null;
        }
        return cp;
    }

    @Override
    public List<CategoriaPlatillo> listar() {
        List<CategoriaPlatillo> categorias = new ArrayList<CategoriaPlatillo>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(listaCampos());
        sql.append(" WHERE ELIMINADO = FALSE");

        log.info(sql.toString());

        Object catPlat[][] = conector.consultar(sql.toString());
        if (catPlat.length != 0) {
            for (Object filacp[] : catPlat) {
                categorias.add(
                        new CategoriaPlatillo(
                                (Integer) filacp[0],
                                filacp[1] != null ? (Integer) filacp[1] : null,
                                (String) filacp[2],
                                (Boolean) filacp[3]
                        ));
            }
        }
        return categorias;
    }
    
    public List<CategoriaPlatillo> listar(Integer padre) {
        List<CategoriaPlatillo> categorias = new ArrayList<CategoriaPlatillo>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append(listaCampos());
        sql.append(" WHERE CATEGORIA_PADRE = ");
        sql.append(padre);
        sql.append(" AND ELIMINADO = FALSE");

        log.info(sql.toString());

        Object catPlat[][] = conector.consultar(sql.toString());
        if (catPlat.length != 0) {
            for (Object filacp[] : catPlat) {
                categorias.add(
                        new CategoriaPlatillo(
                                (Integer) filacp[0],
                                filacp[1] != null ? (Integer) filacp[1] : null,
                                (String) filacp[2],
                                (Boolean) filacp[3]
                        ));
            }
        }
        return categorias;
    }
    
    @Override
    public String listaCampos() {
        StringBuilder sql = new StringBuilder();
        for (String campo : campos) {
            sql.append(campo);
            sql.append(",");
        }
        return sql.substring(0, sql.length() - 1) + " FROM CATEGORIA_PLATILLO";
    }
}
