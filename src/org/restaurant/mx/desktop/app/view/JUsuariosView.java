/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.restaurant.mx.desktop.app.view;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import org.developercircle.base.ui.mdi.AbstractPanelView;
import org.developercircle.base.ui.mdi.JAbstractMDI;
import org.developercircle.base.ui.mdi.JAbstractManageableIFrame;
import org.restaurant.mx.desktop.app.AppPrincipal;

/**
 *
 * @author JAST
 */
public class JUsuariosView extends JAbstractManageableIFrame {

    private JAbstractMDI app;
    private AbstractPanelView panel;

    public JUsuariosView(JAbstractMDI app) {
        super();
        this.app = app;
        panel = new JUsuariosPanel(this.app);
        init();
    }

    public void init() {
        setTitle("Usuarios");
        setMaximizable(true);
        setResizable(true);
        setClosable(true);
        Dimension d = new Dimension(600, 600);
        setSize(d);
        setPreferredSize(d);
    }

    @Override
    public AbstractPanelView getPanelView() {
        return panel;
    }

    @Override
    public JDesktopPane getMDIContainer() {
        return app.getContainerMDI();
    }

    @Override
    public String getNameView() {
        return AppPrincipal.USUARIOS_ACTION;
    }

    @Override
    public void removeme() {
        //Sim implementación
    }

}
