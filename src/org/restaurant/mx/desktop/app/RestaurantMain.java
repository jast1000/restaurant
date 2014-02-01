

package org.restaurant.mx.desktop.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.developercircle.app.AppConfig;
import org.restaurant.mx.desktop.conf.DCAdminConfig;

/**
 *
 * @author developercircle
 */
public class RestaurantMain {

    public static void main(String arg[]){

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    File cfgFile = new File(String.format("%s%s%s",
				System.getProperty("user.home"),
				System.getProperty("file.separator"),
				"restaurant.properties"));
                    if(!cfgFile.exists()) {
                        JOptionPane.showMessageDialog(null, "El archivo de propiedades para conexión no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    AppConfig config = new DCAdminConfig("dcadmin", "dcadmin.conf");
                    config.load();
                    new AppPrincipal(config).setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RestaurantMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RestaurantMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
