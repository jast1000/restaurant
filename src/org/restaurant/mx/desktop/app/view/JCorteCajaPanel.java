package org.restaurant.mx.desktop.app.view;

import org.apache.log4j.Logger;
import org.developercircle.base.ui.mdi.AbstractPanelView;
import org.restaurant.mx.desktop.app.AppPrincipal;

/**
 *
 * @author José Bernardo Gómez-Andrade
 */
public class JCorteCajaPanel extends AbstractPanelView {

	private static final Logger log = Logger.getLogger(JCorteCajaPanel.class);

	private AppPrincipal app;

	public JCorteCajaPanel(AppPrincipal app) {
		initComponents();
		this.app = app;
	}

	@Override
	public void activate() {
		log.info("Doing something");
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
