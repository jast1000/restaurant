/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.modelo;

/**
 *
 * @author JAST
 */
public class RestaurantInfo {

    private String nombreRestaurant;
    private String ciudad;
    private String direccion;
    private String telefono;

    public RestaurantInfo() {
    }

    public RestaurantInfo(String nombreRestaurant, String ciudad, String direccion, String telefono) {
        this.nombreRestaurant = nombreRestaurant;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombreRestaurant() {
        return nombreRestaurant;
    }

    public void setNombreRestaurant(String nombreRestaurant) {
        this.nombreRestaurant = nombreRestaurant;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "RestaurantInfo{" + "nombreRestaurant=" + nombreRestaurant + ", ciudad=" + ciudad + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

}
