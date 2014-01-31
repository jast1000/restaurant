/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.controladores;

import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.modelo.EmpleadoInfo;
import org.restaurant.mx.modelo.Mesa;
import org.restaurant.mx.util.Encriptador;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *
 * @author JAST
 */
public class ControladorEmpleado extends Controlador<EmpleadoInfo> {

    private final Logger log = Logger.getLogger(ControladorEmpleado.class);

    private String campos1[] = {"ID_EMPLEADO", "NOMBRE", "APELLIDOS", "ACTIVO", "TIPO_EMP", "USUARIO", "PASSWORD"};
    private String campos2[] = {"ID_EMPLEADO", "DISPONIBLE", "DIRECCION", "CORREO", "TELEFONO"};

    private ConectorBasico conector;

    public ControladorEmpleado() {
        conector = new ConectorBasico();
//        BasicConfigurator.configure();
    }

    @Override
    public boolean eliminar(EmpleadoInfo clazz) {
        String sql1 = "DELETE FROM EMPLEADO WHERE ID_EMPLEADO = " + clazz.getIdEmpleado();
        String sql2 = "DELETE FROM INFO_EMPLEADO WHERE ID_EMPLEADO = " + clazz.getIdEmpleado();

        log.info(sql1);
        log.info(sql2);

        return conector.actualizar(sql2) && conector.actualizar(sql1);
    }

    @Override
    public boolean actualizar(EmpleadoInfo clazz) {
        StringBuilder sb = new StringBuilder();

        //UPDATE para la tabla EMPLEADO
        sb.append("UPDATE EMPLEADO SET ");
        sb.append("NOMBRE = '");
        sb.append(clazz.getNoombres());
        sb.append("', APELLIDOS = '");
        sb.append(clazz.getApellidos());
        sb.append("', ACTIVO = ");
        sb.append(clazz.getActivo());
        sb.append(", TIPO_EMP = ");
        sb.append(clazz.getTipoEmpleado());
        sb.append(", USUARIO = '");
        sb.append(clazz.getUsuario());
        sb.append("', PASSWORD = '");
        sb.append(clazz.getPassword());
        sb.append("' WHERE ID_EMPLEADO = ");
        sb.append(clazz.getIdEmpleado());

        String sql1 = sb.toString();
        log.info(sql1);

        //UPDATE para la tabla INFO_EMPLEADO
        sb = new StringBuilder();
        sb.append("UPDATE INFO_EMPLEADO SET ");
        sb.append("CIUDAD = '");
        sb.append(clazz.getCiudad());
        sb.append("', DIRECCION = '");
        sb.append(clazz.getDireccion());
        sb.append("', CORREO = '");
        sb.append(clazz.getCorreo());
        sb.append("', TELEFONO = '");
        sb.append(clazz.getTelefono());
        sb.append("' WHERE ID_EMPLEADO = ");
        sb.append(clazz.getIdEmpleado());

        String sql2 = sb.toString();
        log.info(sql2);

        return conector.actualizar(sql1) && conector.actualizar(sql2);

    }

    @Override
    public boolean agregar(EmpleadoInfo clazz) {
        Integer id = new ControladorSecuencia().aumentarSecuencia("EMPLEADO");

        Encriptador e = new Encriptador();
        e.setClave(clazz.getPassword());

        StringBuilder sb = new StringBuilder();

        //Construcción para insert a tabla EMPLEADO
        sb.append("INSERT INTO EMPLEADO VALUES(");
        sb.append(id);
        sb.append(", '");
        sb.append(clazz.getNoombres());
        sb.append("', '");
        sb.append(clazz.getApellidos());
        sb.append("', ");
        sb.append(clazz.getActivo());
        sb.append(", ");
        sb.append(clazz.getTipoEmpleado());
        sb.append(", '");
        sb.append(clazz.getUsuario());
        sb.append("', '");
        sb.append(e.encriptar());
        sb.append("')");
        log.info(sb.toString());

        String sql1 = sb.toString();

        //Creamos el INSERT para para la tabla INFO_EMPLEADO
        sb = new StringBuilder();
        sb.append("INSERT INTO INFO_EMPLEADO VALUES(");
        sb.append(id);
        sb.append(", '");
        sb.append(clazz.getCiudad());
        sb.append("', '");
        sb.append(clazz.getDireccion());
        sb.append("', '");
        sb.append(clazz.getCorreo());
        sb.append("', '");
        sb.append(clazz.getTelefono());
        sb.append("')");

        String sql2 = sb.toString();
        log.info(sql2);

        boolean ok = conector.actualizar(sql1) && conector.actualizar(sql2);
        if (ok) {
            return true;
        } else {
            new ControladorSecuencia().disminuirSecuencia("EMPLEADO");
            return false;
        }
    }

    @Override
    public EmpleadoInfo buscar(Object id) {
        EmpleadoInfo ei = new EmpleadoInfo();

        String sql = "SELECT emp.id_empleado, emp.nombre, emp.apellidos, emp.activo, emp.tipo_emp, emp.usuario, emp.`password`, inf.ciudad, "
                + "inf.direccion, inf.correo, inf.telefono FROM empleado AS emp INNER JOIN info_empleado AS inf ON inf.id_empleado = emp.id_empleado "
                + "WHERE emp.id_empleado = " + id;
        log.info(sql);

        Object emp[][] = conector.consultar(sql.toString());

        if (emp != null) {
            ei.setIdEmpleado((Integer) emp[0][0]);
            ei.setNoombres((String) emp[0][1]);
            ei.setApellidos((String) emp[0][2]);
            ei.setActivo((Boolean) emp[0][3]);
            ei.setTipoEmpleado((Integer) emp[0][4]);
            ei.setUsuario((String) emp[0][5]);
            ei.setPassword((String) emp[0][6]);
            ei.setCiudad((String) emp[0][7]);
            ei.setDireccion((String) emp[0][8]);
            ei.setCorreo((String) emp[0][9]);
            ei.setTelefono((String) emp[0][10]);
        } else {
            return null;
        }

        return ei;
    }

    @Override
    public List<EmpleadoInfo> listar() {
        List<EmpleadoInfo> le = new ArrayList<EmpleadoInfo>();

        String sql = "SELECT emp.id_empleado, emp.nombre, emp.apellidos, emp.activo, emp.tipo_emp, emp.usuario, emp.`password`, inf.ciudad, "
                + "inf.direccion, inf.correo, inf.telefono FROM empleado AS emp INNER JOIN info_empleado AS inf ON inf.id_empleado = emp.id_empleado";

        log.info(sql);

        Object emps[][] = conector.consultar(sql.toString());
        if (emps != null) {
            for (Object filaEmp[] : emps) {
                le.add(new EmpleadoInfo((String) filaEmp[7],
                        (String) filaEmp[8],
                        (String) filaEmp[9],
                        (String) filaEmp[10],
                        (Integer) filaEmp[0],
                        (String) filaEmp[1],
                        (String) filaEmp[2],
                        (Boolean) filaEmp[3],
                        (Integer) filaEmp[4],
                        (String) filaEmp[5],
                        (String) filaEmp[6]));
            }
        } else {
            return null;
        }

        return le;
    }

    public List<EmpleadoInfo> listarPorNombre(String nombre) {
        List<EmpleadoInfo> le = new ArrayList<EmpleadoInfo>();

        String sql = "SELECT emp.id_empleado, emp.nombre, emp.apellidos, emp.activo, emp.tipo_emp, emp.usuario, emp.`password`, inf.ciudad, "
                + "inf.direccion, inf.correo, inf.telefono FROM empleado AS emp INNER JOIN info_empleado AS inf ON inf.id_empleado = emp.id_empleado "
                + "WHERE emp.nombre like '%" + nombre + "%'";
        log.info(sql);

        Object emps[][] = conector.consultar(sql.toString());
        if (emps != null) {
            for (Object filaEmp[] : emps) {
                le.add(new EmpleadoInfo((String) filaEmp[7],
                        (String) filaEmp[8],
                        (String) filaEmp[9],
                        (String) filaEmp[10],
                        (Integer) filaEmp[0],
                        (String) filaEmp[1],
                        (String) filaEmp[2],
                        (Boolean) filaEmp[3],
                        (Integer) filaEmp[4],
                        (String) filaEmp[5],
                        (String) filaEmp[6]));
            }
        } else {
            return null;
        }

        return le;
    }

    public List<EmpleadoInfo> listarPorActivo(boolean activo) {
        List<EmpleadoInfo> le = new ArrayList<EmpleadoInfo>();

        String sql = "SELECT emp.id_empleado, emp.nombre, emp.apellidos, emp.activo, emp.tipo_emp, emp.usuario, emp.`password`, inf.ciudad, "
                + "inf.direccion, inf.correo, inf.telefono FROM empleado AS emp INNER JOIN info_empleado AS inf ON inf.id_empleado = emp.id_empleado "
                + "WHERE emp.activo = " + activo;
        log.info(sql);

        Object emps[][] = conector.consultar(sql.toString());
        if (emps != null) {
            for (Object filaEmp[] : emps) {
                le.add(new EmpleadoInfo((String) filaEmp[7],
                        (String) filaEmp[8],
                        (String) filaEmp[9],
                        (String) filaEmp[10],
                        (Integer) filaEmp[0],
                        (String) filaEmp[1],
                        (String) filaEmp[2],
                        (Boolean) filaEmp[3],
                        (Integer) filaEmp[4],
                        (String) filaEmp[5],
                        (String) filaEmp[6]));
            }
        } else {
            return null;
        }

        return le;
    }

    @Override
    public String listaCampos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
