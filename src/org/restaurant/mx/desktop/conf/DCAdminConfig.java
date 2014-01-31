package org.restaurant.mx.desktop.conf;

import java.util.Properties;
import org.developercircle.app.AppConfig;
import org.restaurant.mx.admin.base.DCAplication;

/**
 *
 * @author developercircle
 */
public class DCAdminConfig extends AppConfig {

    public DCAdminConfig(String name_app,String name_config_file) {
        super(name_app, name_config_file);
    }

    @Override
    public Properties getDefault() {
        Properties prop=new Properties();
        prop.setProperty("app.name",DCAplication.APP_NAME);
        prop.setProperty("app.version",DCAplication.APP_VERSION);
        prop.setProperty("app.dbvesion", DCAplication.DB_VERSION);
        return prop;
    }

}
