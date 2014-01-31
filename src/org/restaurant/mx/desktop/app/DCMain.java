

package org.restaurant.mx.desktop.app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.developercircle.app.AppConfig;
import org.restaurant.mx.desktop.conf.DCAdminConfig;

/**
 *
 * @author developercircle
 */
public class DCMain {

    public static void main(String arg[]){

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    AppConfig config = new DCAdminConfig("dcadmin", "dcadmin.conf");
                    config.load();
                    new AppPrincipal(config).setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(DCMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(DCMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
