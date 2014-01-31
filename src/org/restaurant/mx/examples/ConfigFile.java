/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.examples;

import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.conector.ConectorUtil;
import org.restaurant.mx.controladores.ControladorInformes;
import org.restaurant.mx.controladores.ControladorMesa;
import org.restaurant.mx.controladores.ControladorSecuencia;
import org.restaurant.mx.modelo.Mesa;
import org.restaurant.mx.util.ConexionInfo;

/**
 *
 * @author JAST
 */
public class ConfigFile {
    public static void main(String[] args) {
        ConectorUtil cu = new ConectorUtil();
        ConexionInfo ci = new ConexionInfo();
        
        //Para generar archivo requiero:
        ci.setBd("test01");
        ci.setClave("chucho25");
        ci.setServidor("localhost");
        ci.setUsuario("root");
        cu.setConInfo(ci);
        
        //Directorio para generar archivo.
        cu.setPath("D:\\");
        cu.createFile();
        ConexionInfo loadFile = cu.loadFile();
        System.out.println(loadFile.toString());
    }
}
