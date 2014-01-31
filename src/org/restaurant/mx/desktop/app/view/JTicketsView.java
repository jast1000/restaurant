/*
 * Proyecto:DCAdminDesktop
 * Fecha de creacion de archivo:24/01/2014 07:49:46 PM 
 */

package org.restaurant.mx.desktop.app.view;

import java.awt.Dimension;
import javax.swing.JDesktopPane;
import org.restaurant.mx.admin.service.VentasService;
import org.developercircle.app.AppLocal;
import org.developercircle.base.service.CreationServiceExcetion;
import org.developercircle.base.ui.mdi.AbstractPanelView;
import org.developercircle.base.ui.mdi.JAbstractMDI;
import org.developercircle.base.ui.mdi.JAbstractManageableIFrame;
import org.restaurant.mx.desktop.app.AppPrincipal;

/**
 *
 * @author Leonardo Guzman Reyes
 */
public class JTicketsView extends JAbstractManageableIFrame{

	private JAbstractMDI app;
	private AbstractPanelView panel;
	private VentasService service;

			
	public JTicketsView(JAbstractMDI app) throws CreationServiceExcetion {
		super();
		this.app=app;
		panel=new JTicketsPanel(this.app);
		init();
		service=(VentasService) this.app.getServicesFactory().getService("ventas");
		service.guardarVenta("");
		
	}
	
	
	public void init(){
        setTitle(AppLocal.getString("label.view.company"));
        setMaximizable(true);
        setResizable(true);
        setClosable(true);
        Dimension d = new Dimension(800, 550);
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
		return AppPrincipal.TICKETS_ACTION;
	}

	@Override
	public void removeme() {
		
	}

	

}
