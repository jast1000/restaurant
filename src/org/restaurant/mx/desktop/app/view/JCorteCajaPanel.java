package org.restaurant.mx.desktop.app.view;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.log4j.Logger;
import org.developercircle.base.ui.mdi.AbstractPanelView;
import org.restaurant.mx.controladores.ControladorInformes;
import org.restaurant.mx.controladores.ControladorTicket;
import org.restaurant.mx.desktop.app.AppPrincipal;
import org.restaurant.mx.modelo.TicketInfo;

/**
 *
 * @author José Bernardo Gómez-Andrade
 */
public class JCorteCajaPanel extends AbstractPanelView {

	private static final Logger log = Logger.getLogger(JCorteCajaPanel.class);

	private AppPrincipal app;
	private ControladorInformes informes;
	private ControladorTicket adTickets;
	//
	private JasperReport jr;

	public JCorteCajaPanel(AppPrincipal app) {
		initComponents();
		this.app = app;
		
		informes = (ControladorInformes) app.getBean(ControladorInformes.class.getCanonicalName());
		adTickets = (ControladorTicket) app.getBean(ControladorTicket.class.getCanonicalName());
		
		cargarReporte();
	}
	
	private void cargarReporte() {
		// com.jast.restaurante.reportes.JRViewerExt
		InputStream is = getClass().getResourceAsStream("/com/jast/restaurante/reportes/corte_caja.ser");
		try {
			if (is == null) {
				JasperDesign jd = JRXmlLoader.load(
						getClass().getResourceAsStream("/com/jast/restaurante/reportes/corte_caja.jrxml"));
				jr = JasperCompileManager.compileReport(jd);

				OutputStream os = new FileOutputStream("corte_caja.ser");
				OutputStream bos = new BufferedOutputStream(os, 32);
				try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
					oos.writeObject(jr);
				}
			} else {
				try (ObjectInputStream ois = new ObjectInputStream(is)) {
					jr = (JasperReport) ois.readObject();
				}
			}
		} catch (ClassNotFoundException | IOException | JRException cnfex) {
			log.error(cnfex.getMessage(), cnfex);
		}
	}
	
	private void listarNoCortados() {
		if (jr != null) {
		List<TicketInfo> sinCortar = adTickets.listarPorEstadoCortado(false); // Los tickets no cortados.
			try {
			Map<String, Object> params = new HashMap<>(4);
			Locale lcl = Locale.getDefault();
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, lcl);
			ResourceBundle bundle = ResourceBundle.getBundle("com/jast/restaurante/reportes/corte_caja", lcl);
			// 
			params.put("STR_FECHA", df.format(Calendar.getInstance().getTime()) );
			params.put("REPORT_RESOURCE_BUNDLE", bundle);

			// 
			JasperPrint jp = JasperFillManager.fillReport(jr, params, new JRBeanCollectionDataSource(sinCortar));
			jrReporte.update(jp);
		} catch (JRException jrex) {
			log.error(jrex.getMessage(), jrex);
			JOptionPane.showMessageDialog(this, "No se puede mostrar.");
		} catch (MissingResourceException mrex) {
			log.error(mrex.getMessage(), mrex);
			JOptionPane.showMessageDialog(this, "No se pudo cargar el idioma.");
		}
		} else {
			JOptionPane.showMessageDialog(this, "No se pudo cargar el reporte.");
		}
	}

	@Override
	public void activate() {
		listarNoCortados();
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jrReporte = new com.jast.restaurante.reportes.JRViewerExt();
        jPanel2 = new javax.swing.JPanel();
        btnCortarCaja = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());
        add(jrReporte, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(474, 40));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 2));

        btnCortarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/next.png"))); // NOI18N
        btnCortarCaja.setText("Cortar caja");
        btnCortarCaja.setPreferredSize(new java.awt.Dimension(140, 36));
        jPanel2.add(btnCortarCaja);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel1.setPreferredSize(new java.awt.Dimension(474, 40));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 2));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/refresh.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setPreferredSize(new java.awt.Dimension(140, 36));
        jPanel1.add(btnActualizar);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCortarCaja;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.jast.restaurante.reportes.JRViewerExt jrReporte;
    // End of variables declaration//GEN-END:variables
}
