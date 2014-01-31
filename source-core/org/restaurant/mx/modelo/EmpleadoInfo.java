/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.modelo;

/**
 *
 * @author JAST
 */
public class EmpleadoInfo extends Empleado {

    private String ciudad;
    private String direccion;
    private String correo;
    private String telefono;

    public EmpleadoInfo() {
    }

    public EmpleadoInfo(String ciudad, String direccion, String correo, String telefono) {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public EmpleadoInfo(String ciudad, String direccion, String correo, String telefono, Integer idEmpleado, String noombres, String apellidos, Boolean activo, Integer tipoEmpleado, String usuario, String password) {
        super(idEmpleado, noombres, apellidos, activo, tipoEmpleado, usuario, password);
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "<html><h3>" + super.getIdEmpleado() + " - " + getNoombres() + "</h3></html>";
    }
    
    
}
