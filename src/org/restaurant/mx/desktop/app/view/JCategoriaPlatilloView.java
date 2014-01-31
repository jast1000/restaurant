/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.restaurant.mx.desktop.app.view;

import org.restaurant.mx.desktop.app.AppPrincipal;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import org.developercircle.base.ui.mdi.AbstractPanelView;
import org.developercircle.base.ui.mdi.JAbstractMDI;
import org.developercircle.base.ui.mdi.JAbstractManageableIFrame;

/**
 *
 * @author JAST
 */
public class JCategoriaPlatilloView extends JAbstractManageableIFrame{

    private JAbstractMDI app;
    private AbstractPanelView panel;
    
    public JCategoriaPlatilloView(JAbstractMDI app) {
        super();
        this.app = app;
        panel = new JCategoriaPlatilloPanel(app);
        init();
    }

    public void init() {
        setTitle("Categoria platillos");
        setMaximizable(true);
        setResizable(true);
        setClosable(true);
        Dimension d = new Dimension(500, 350);
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
        return AppPrincipal.CATEGORIAS_ACTION;
    }

    @Override
    public void removeme() {
        //meow!!
    }
    
}
