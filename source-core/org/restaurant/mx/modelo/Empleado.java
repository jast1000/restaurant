/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.modelo;

/**
 *
 * @author JAST
 */
public class Empleado {

    public static final Integer EMP_ADMINISTRADOR = 1;
    public static final Integer EMP_CAJERO = 2;
    public static final Integer EMP_MESERO = 3;
    public static final Boolean EMP_ELIMINADO = Boolean.FALSE;
    public static final Boolean EMP_ACTIVO = Boolean.TRUE;
    
    private Integer idEmpleado;
    private String noombres;
    private String apellidos;
    private Boolean activo;
    private Integer tipoEmpleado;
    private String usuario;
    private String password;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado, String noombres, String apellidos, Boolean activo, Integer tipoEmpleado, String usuario, String password) {
        this.idEmpleado = idEmpleado;
        this.noombres = noombres;
        this.apellidos = apellidos;
        this.activo = activo;
        this.tipoEmpleado = tipoEmpleado;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNoombres() {
        return noombres;
    }

    public void setNoombres(String noombres) {
        this.noombres = noombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(Integer tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", noombres=" + noombres + ", apellidos=" + apellidos + ", activo=" + activo + ", tipoEmpleado=" + tipoEmpleado + ", usuario=" + usuario + ", password=" + password + '}';
    }
}
