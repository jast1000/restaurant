/*
 * Proyecto:DCAdminDesktop
 * Fecha de creacion de archivo:8/01/2014 04:42:50 PM 
 */
package org.restaurant.mx.desktop.app;

import com.jast.restaurante.interfaces.DatabaseAccess;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.restaurant.mx.admin.service.DCFacturaSeviceFactory;
import org.restaurant.mx.desktop.app.view.JCategoriaPlatilloView;
import org.restaurant.mx.desktop.app.view.JEmpresaView;
import org.restaurant.mx.desktop.app.view.JMesaView;
import org.restaurant.mx.desktop.app.view.JPlatilloView;
import org.developercircle.app.AppConfig;
import org.developercircle.base.service.AppServiceFactory;
import org.developercircle.base.service.CreationServiceExcetion;
import org.developercircle.base.ui.mdi.JAbstractMDI;
import org.restaurant.mx.conector.ConectorBasico;
import org.restaurant.mx.desktop.app.view.JCorteCajaView;
import org.restaurant.mx.desktop.app.view.JUsuariosView;
import org.restaurant.mx.desktop.app.view.JTicketsView;

/**
 *
 * @author Leonardo Guzman Reyes
 */
public class AppPrincipal extends JAbstractMDI implements ActionListener {

	private JDesktopPane jdPane;
	private AppConfig config;
	private JMenuBar jMenuBarApp;
	private AppServiceFactory serviceFactory;
	private Map<String, DatabaseAccess> beanCache;

    //******************************************
	//Los ACTION para abrir  las ventanitas.
	public static final String USUARIOS_ACTION = "usuariosView";
	public static final String MESAS_ACTION = "mesasView";
	public static final String TICKETS_ACTION = "ticketsView";
	public static final String EMPRESA_ACTION = "empresaView";
	public static final String CATEGORIAS_ACTION = "categoriasView";
	public static final String PLATILLO_ACTION = "platilloView";
	public static final String CORTE_CAJA = "org.restaurant.mx.desktop.app.view.JCorteCajaView";

	public AppPrincipal(AppConfig config) {
		super();
		jdPane = new JDesktopPane();
		this.config = config;

		beanCache = new HashMap<>(10);
		///
		initOtherComponents();
	}

	/**
	 * Inicializa otros componentes
	 */
	private void initOtherComponents() {
		//para que se centre el formulario y asigne un tamaño
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(1024, 700));
		this.setPreferredSize(new Dimension(1024, 700));
		setLocationRelativeTo(null);

		try {

			//1. cargamos el service facttory
			loadServiceFactory();
			//2. Cargamos los menues
			initMenu();
			//3. Iniciamos las vistas
			initViews();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

	}

	/**
	 * Inicializa el menu.
	 */
	private void initMenu() {
		jMenuBarApp = new javax.swing.JMenuBar();
		boolean activa = true;
		JMenu menu;
		JMenuItem subMenu;

		//Menu de ventas
		menu = new JMenu("Ventas");

		//Submenu de ventas
		subMenu = new JMenuItem("Ventas");
		subMenu.setActionCommand(TICKETS_ACTION);
		subMenu.addActionListener(this);
		subMenu.setEnabled(activa);
		menu.add(subMenu);

		// Submenu de corte ¬_¬
		subMenu = new JMenuItem("Corte de caja");
		subMenu.setActionCommand(CORTE_CAJA);
		subMenu.addActionListener(this);
		menu.add(subMenu);

        //Lo agregamos a la barra
		//agregar el menu a la barra
		jMenuBarApp.add(menu);

		//Menú de platillos
		menu = new JMenu("Platillos");

		subMenu = new JMenuItem("Categoria platillo");
		subMenu.setActionCommand(CATEGORIAS_ACTION);
		subMenu.addActionListener(this);
		subMenu.setEnabled(activa);

		//Agregar el sub menu a su padre
		menu.add(subMenu);

		subMenu = new JMenuItem("Platillos");
		subMenu.setActionCommand(PLATILLO_ACTION);
		subMenu.addActionListener(this);
		subMenu.setEnabled(activa);

		//Agregar el sub menu a su padre
		menu.add(subMenu);

		//agregar el menu a la barra
		jMenuBarApp.add(menu);

		//Aquí el menú de configuración
		menu = new JMenu("Configuración");

		//Usuarios
		subMenu = new JMenuItem("Usuarios");
		subMenu.setActionCommand(USUARIOS_ACTION);
		subMenu.addActionListener(this);
		subMenu.setEnabled(activa);

		//Agregar el sub menu a su padre
		menu.add(subMenu);

		subMenu = new JMenuItem("Mesas");
		subMenu.setActionCommand(MESAS_ACTION);
		subMenu.addActionListener(this);
		subMenu.setEnabled(activa);

		//Agregar el sub menu a su padre
		menu.add(subMenu);

		subMenu = new JMenuItem("Información Empresa");
		subMenu.setActionCommand(EMPRESA_ACTION);
		subMenu.addActionListener(this);
		subMenu.setEnabled(activa);

		//Agregar el sub menu a su padre
		menu.add(subMenu);

		//agregar el menu a la barra
		jMenuBarApp.add(menu);

		//Agregar la barra de menu a la ventana del MDI
		setJMenuBar(jMenuBarApp);

		//agregar el JDesktop pane
		add(jdPane);
		pack();
	}

	/**
	 * Iniciamos las vistas que seran Singleton (osea que solo existira una de
	 * cada una en el sistema pra no consumir mucha memoria)
	 */
	private void initViews() throws CreationServiceExcetion {
		JUsuariosView usuariosView = new JUsuariosView(this);
		JMesaView mesasView = new JMesaView(this);
		JEmpresaView empresaView = new JEmpresaView(this);
		JCategoriaPlatilloView categoriasView = new JCategoriaPlatilloView(this);
		JPlatilloView platilloView = new JPlatilloView(this);
		JTicketsView ventaView = new JTicketsView(this);
		//
		JCorteCajaView corteCaja = new JCorteCajaView(this);

		mViews.addView(usuariosView);
		mViews.addView(mesasView);
		mViews.addView(empresaView);
		mViews.addView(categoriasView);
		mViews.addView(platilloView);
		mViews.addView(ventaView);
		//
		mViews.addView(corteCaja);
	}

	@Override
	public JDesktopPane getContainerMDI() {
		return jdPane;
	}

	@Override
	public AppConfig getConfig() {
		return config;
	}

	@Override
	public AppServiceFactory getServicesFactory() {
		return serviceFactory;
	}

	@Override
	public void doSomething(Object... ts) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Object doSomethingWithResult(Object... ts) {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		return null;
	}

	public DatabaseAccess getBean(String clazz) {
		if (!beanCache.containsKey(clazz)) {
			try {
				DatabaseAccess bean = (DatabaseAccess) Class.forName(clazz).newInstance();
				bean.init(new ConectorBasico()); // Podria estar cacheado el conector básico
				beanCache.put(clazz, bean);
				log.info("Bean para: " + clazz + ", inicializado exitosamente");
			} catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
				log.error(ex.getMessage(), ex);
			}
		}
		return beanCache.get(clazz);
	}

	/**
	 * Carga el service factory que sirve para crear servicios de la logica de
	 * negocio.
	 *
	 * @throws Exception
	 */
	private void loadServiceFactory() throws Exception {
		try {
			serviceFactory = new DCFacturaSeviceFactory();//(AppServiceFactory) Class.forName(config.getProperty("app.beans.servicefactorydefault")).newInstance();
			serviceFactory.configure(config);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Para atender, los eventos de los menues
	 *
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mViews.activate(e.getActionCommand());
	}

}
