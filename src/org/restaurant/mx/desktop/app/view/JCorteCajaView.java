package org.restaurant.mx.desktop.app.view;

import javax.swing.JDesktopPane;
import org.developercircle.base.ui.mdi.AbstractPanelView;
import org.developercircle.base.ui.mdi.JAbstractManageableIFrame;
import org.restaurant.mx.desktop.app.AppPrincipal;

/**
 *
 * @author José Bernardo Gómez-Andrade
 */
public class JCorteCajaView extends JAbstractManageableIFrame {

	private AppPrincipal app;
	private JCorteCajaPanel panel;

	public JCorteCajaView(AppPrincipal app) {
		super();
		this.app = app;
		
		//
		setTitle("Corte de caja");
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		
		panel = new JCorteCajaPanel(app);
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
		return getClass().getCanonicalName();
	}

	@Override
	public void removeme() {
		// Nada por hacer
	}

}
