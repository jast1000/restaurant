/*
 * Proyecto:DCAdminDesktop
 * Fecha de creacion de archivo:24/01/2014 08:13:48 PM 
 */
package org.restaurant.mx.desktop.app.view;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import org.developercircle.base.ui.IAccessibleMDI;
import org.developercircle.base.ui.mdi.AbstractPanelView;
import org.developercircle.base.ui.mdi.JAbstractMDI;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.restaurant.mx.controladores.ControladorCategoriaPlatillo;
import org.restaurant.mx.controladores.ControladorEmpleado;
import org.restaurant.mx.controladores.ControladorLineaOrden;
import org.restaurant.mx.controladores.ControladorMesa;
import org.restaurant.mx.controladores.ControladorPlatillo;
import org.restaurant.mx.controladores.ControladorTicket;
import org.restaurant.mx.modelo.CategoriaExt;
import org.restaurant.mx.modelo.CategoriaPlatillo;
import org.restaurant.mx.modelo.Empleado;
import org.restaurant.mx.modelo.EmpleadoInfo;
import org.restaurant.mx.modelo.LineaExt;
import org.restaurant.mx.modelo.LineaOrden;
import org.restaurant.mx.modelo.Mesa;
import org.restaurant.mx.modelo.Platillo;
import org.restaurant.mx.modelo.TicketExt;
import org.restaurant.mx.modelo.TicketInfo;

/**
 *
 * @author Leonardo Guzman Reyes
 */
public class JTicketsPanel extends AbstractPanelView {

    private DefaultListModel modelMesas;
    private DefaultListModel modelMesero;
    private DefaultListModel modelTickets;
    private DefaultListModel modelOrdenes;
    private DefaultListModel modeloPlatillos;
    private DefaultComboBoxModel modeloCategorias;
    private ControladorCategoriaPlatillo conCat;
    private ControladorPlatillo conPla;
    private ControladorMesa conMe;
    private ControladorEmpleado conEmp;
    private ControladorTicket conTic;
    private ControladorLineaOrden conLin;
    private IAccessibleMDI app;
    private TicketExt ticketSeleccionado;
    private DecimalFormat df;

    /**
     * Creates new form JVentasPanel
     */
    public JTicketsPanel(JAbstractMDI app) {
        initComponents();
        this.app = app;
        df = new DecimalFormat("'$'#####.##");
    }

    private void cargarMesas() {
        modelMesas = new DefaultListModel();
        List<Mesa> mesas = conMe.listar();
        for (Mesa m : mesas) {
            modelMesas.addElement(m);
        }
        lstMesas.setModel(modelMesas);
    }

    private void cargarMeseros() {
        modelMesero = new DefaultListModel();
        List<EmpleadoInfo> meseros = conEmp.listarPorTipo(Empleado.EMP_MESERO);
        for (EmpleadoInfo ei : meseros) {
            modelMesero.addElement(ei);
        }
        lstMesero.setModel(modelMesero);
    }

    private void cargarTickets() {
        modelTickets = new DefaultListModel();
        List<TicketInfo> tickets = conTic.listarPorEstadoCobrado(false);

        for (TicketInfo ti : tickets) {
            TicketExt te = new TicketExt();
            te.setMesa(conMe.buscar((Integer) ti.getMesa()));
            te.setMesero(conEmp.buscar((Integer) ti.getEmpleado()));
            te.setTicket(conTic.buscar(ti.getIdTicket()));
            modelTickets.addElement(te);
        }

        lstTickets.setModel(modelTickets);
    }

    public void cargarCategorias() {
        modeloCategorias = new DefaultComboBoxModel();
        List<CategoriaPlatillo> cats = conCat.listar();
        modeloCategorias.addElement(null);
        for (CategoriaPlatillo cp : cats) {
            CategoriaExt ce = new CategoriaExt();
            ce.setCategoriaPlatillo(cp);
            modeloCategorias.addElement(ce);
        }
        cboCategoria.setModel(modeloCategorias);
    }

    public void listarTodos() {
        modeloPlatillos = new DefaultListModel();
        modeloPlatillos = new DefaultListModel();
        List<Platillo> lista = conPla.listar();
        for (Platillo p : lista) {
            modeloPlatillos.addElement(p);
        }
        lstPlatillos.setModel(modeloPlatillos);
    }

    private void ocultarPanelOrden() {
        PanelOrden.setVisible(false);
    }

    private void ocultarPanelTicket() {
        PanelTicket.setVisible(false);
    }

    private void mostrarPanelOrden() {
        PanelOrden.setVisible(true);
    }

    private void mostrarPanelTicket() {
        PanelTicket.setVisible(true);
    }

    private void init() {
        conMe = new ControladorMesa();
        conEmp = new ControladorEmpleado();
        conTic = new ControladorTicket();
        conCat = new ControladorCategoriaPlatillo();
        conPla = new ControladorPlatillo();
        conLin = new ControladorLineaOrden();
        cargarCategorias();
        listarTodos();
        cargarMesas();
        cargarMeseros();
        cargarTickets();
        mostrarPanelTicket();
        ocultarPanelOrden();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        PanelTicket = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMesas = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstMesero = new javax.swing.JList();
        btnCrear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTickets = new javax.swing.JList();
        btnEliminar = new javax.swing.JButton();
        PanelOrden = new javax.swing.JPanel();
        PanelPlatillos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstPlatillos = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        jtfNombre = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        PanelListaOrden = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lsnOrdenes = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Tickets");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Creación de tickets", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Mesa:");

        jScrollPane1.setViewportView(lstMesas);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Mesero:");

        jScrollPane2.setViewportView(lstMesero);

        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/tag_green.png"))); // NOI18N
        btnCrear.setText("Crear ticket");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(btnCrear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCrear)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tickets creados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tickets:");

        lstTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstTicketsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstTickets);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(btnEliminar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelTicketLayout = new javax.swing.GroupLayout(PanelTicket);
        PanelTicket.setLayout(PanelTicketLayout);
        PanelTicketLayout.setHorizontalGroup(
            PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(PanelTicketLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTicketLayout.setVerticalGroup(
            PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        add(PanelTicket);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Cantidad:");

        cboCategoria.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriaActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(lstPlatillos);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Nombre:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Categoria:");

        spnCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        jtfNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jtfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNombreKeyReleased(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/back.png"))); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/add.png"))); // NOI18N
        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPlatillosLayout = new javax.swing.GroupLayout(PanelPlatillos);
        PanelPlatillos.setLayout(PanelPlatillosLayout);
        PanelPlatillosLayout.setHorizontalGroup(
            PanelPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPlatillosLayout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(PanelPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelPlatillosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PanelPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPlatillosLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(PanelPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(PanelPlatillosLayout.createSequentialGroup()
                                    .addGroup(PanelPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(PanelPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelPlatillosLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(btnRegresar))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        PanelPlatillosLayout.setVerticalGroup(
            PanelPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPlatillosLayout.createSequentialGroup()
                .addContainerGap(425, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(PanelPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelPlatillosLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(PanelPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(PanelPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(PanelPlatillosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addComponent(btnRegresar)
                    .addContainerGap()))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Orden");

        jScrollPane5.setViewportView(lsnOrdenes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/delete.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/accept.png"))); // NOI18N
        jButton4.setText("Cobrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelListaOrdenLayout = new javax.swing.GroupLayout(PanelListaOrden);
        PanelListaOrden.setLayout(PanelListaOrdenLayout);
        PanelListaOrdenLayout.setHorizontalGroup(
            PanelListaOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListaOrdenLayout.createSequentialGroup()
                .addGroup(PanelListaOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelListaOrdenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)
                        .addGap(78, 78, 78)
                        .addComponent(jButton4))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 59, Short.MAX_VALUE))
        );
        PanelListaOrdenLayout.setVerticalGroup(
            PanelListaOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelListaOrdenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelListaOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PanelOrdenLayout = new javax.swing.GroupLayout(PanelOrden);
        PanelOrden.setLayout(PanelOrdenLayout);
        PanelOrdenLayout.setHorizontalGroup(
            PanelOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOrdenLayout.createSequentialGroup()
                .addGroup(PanelOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelPlatillos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelOrdenLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelListaOrden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelOrdenLayout.setVerticalGroup(
            PanelOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelOrdenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelOrdenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOrdenLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelPlatillos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelListaOrden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        add(PanelOrden);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        //Validamos que exista una mesa selecciona y libre
        EmpleadoInfo mesero = null;
        Mesa mesa = null;
        TicketInfo ti = new TicketInfo();
        if (lstMesas.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "No existe una mesa seleccionada.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!((Mesa) lstMesas.getSelectedValue()).getDisponible()) {
            JOptionPane.showMessageDialog(this, "La mesa seleccionada no se encuentra disponible.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            mesa = (Mesa) lstMesas.getSelectedValue();
        }
        if (lstMesero.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "No existe mesero seleccionado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } else {
            mesero = (EmpleadoInfo) lstMesero.getSelectedValue();
        }

        ti.setCambio(0d);
        ti.setCobrado(false);
        ti.setCortado(false);
        ti.setEmpleado(mesero.getIdEmpleado());
        ti.setFechaCorte(Calendar.getInstance().getTime());
        ti.setFechaPagado(Calendar.getInstance().getTime());
        ti.setFechaReg(Calendar.getInstance().getTime());
        ti.setRecibio(0d);
        ti.setTotal(0d);
        ti.setMesa(mesa.getNumeroMesa());
        ti = conTic.agregarTicket(ti);
        mesa.setDisponible(false);

        if (ti == null) {
            JOptionPane.showMessageDialog(this, "Se generó un error interno al generar el ticket", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (conMe.actualizar(mesa)) {
            cargarMesas();
        }

        TicketExt te = new TicketExt(mesero, mesa, ti);
        modelTickets.addElement(te);
//        modelTickets.addElement(te);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void lstTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstTicketsMouseClicked
        if (lstTickets.getSelectedIndex() != -1) {
            ticketSeleccionado = (TicketExt) lstTickets.getSelectedValue();
            mostrarPanelOrden();
            ocultarPanelTicket();
            modelOrdenes = new DefaultListModel();
            List<LineaOrden> lis = conLin.listarPorTicket(ticketSeleccionado.getTicket().getIdTicket(), false, false);
            for (LineaOrden l : lis) {
                Platillo p = conPla.buscar((Integer) l.getIdPlatillo());
                LineaExt le = new LineaExt(l, p);
                modelOrdenes.addElement(le);
            }
            lsnOrdenes.setModel(modelOrdenes);
        }
    }//GEN-LAST:event_lstTicketsMouseClicked

    private void jtfNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNombreKeyReleased
        if ((cboCategoria.getSelectedIndex() == -1 || cboCategoria.getSelectedIndex() == 0) && jtfNombre.getText().equals("")) {
            listarTodos();
        } else if ((cboCategoria.getSelectedIndex() == -1 || cboCategoria.getSelectedIndex() == 0) && !jtfNombre.getText().equals("")) {
            List<Platillo> plats = conPla.listarPorFiltro(null, jtfNombre.getText());
            if (plats != null) {
                modeloPlatillos = new DefaultListModel();
                for (Platillo p : plats) {
                    modeloPlatillos.addElement(p);
                }
                lstPlatillos.setModel(modeloPlatillos);
            } else {
                lstPlatillos.setModel(new DefaultListModel());
            }
        } else {
            CategoriaPlatillo catp = (CategoriaPlatillo) cboCategoria.getSelectedItem();
            List<Platillo> plats = conPla.listarPorFiltro(catp.getIdCategoria(), jtfNombre.getText());
            if (plats != null) {
                modeloPlatillos = new DefaultListModel();
                for (Platillo p : plats) {
                    modeloPlatillos.addElement(p);
                }
                lstPlatillos.setModel(modeloPlatillos);
            } else {
                lstPlatillos.setModel(new DefaultListModel());
            }
        }
    }//GEN-LAST:event_jtfNombreKeyReleased

    private void cboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriaActionPerformed
        if ((cboCategoria.getSelectedIndex() == -1 || cboCategoria.getSelectedIndex() == 0) && jtfNombre.getText().equals("")) {
            listarTodos();
        } else if ((cboCategoria.getSelectedIndex() == -1 || cboCategoria.getSelectedIndex() == 0) && !jtfNombre.getText().equals("")) {
            List<Platillo> plats = conPla.listarPorFiltro(null, jtfNombre.getText());
            if (plats != null) {
                modeloPlatillos = new DefaultListModel();
                for (Platillo p : plats) {
                    modeloPlatillos.addElement(p);
                }
                lstPlatillos.setModel(modeloPlatillos);
            } else {
                lstPlatillos.setModel(new DefaultListModel());
            }
        } else {
            CategoriaPlatillo catp = (CategoriaPlatillo) cboCategoria.getSelectedItem();
            List<Platillo> plats = conPla.listarPorFiltro(catp.getIdCategoria(), jtfNombre.getText());
            if (plats != null) {
                modeloPlatillos = new DefaultListModel();
                for (Platillo p : plats) {
                    modeloPlatillos.addElement(p);
                }
                lstPlatillos.setModel(modeloPlatillos);
            } else {
                lstPlatillos.setModel(new DefaultListModel());
            }
        }
    }//GEN-LAST:event_cboCategoriaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        mostrarPanelTicket();
        ocultarPanelOrden();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (lstPlatillos.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "No hay un platillo seleccionado.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Platillo p = (Platillo) lstPlatillos.getSelectedValue();
        LineaOrden lo = new LineaOrden();
        lo.setCantPlatillo((Integer) spnCantidad.getValue());
        lo.setCobrado(false);
        lo.setIdPlatillo(p.getIdPlatillo());
        lo.setNoMesa(ticketSeleccionado.getMesa().getNumeroMesa());
        lo.setObservacion("");
        lo.setTicket(ticketSeleccionado.getTicket().getIdTicket());
        lo.setSubtotal(lo.getCantPlatillo() * p.getPrecio());
        lo.setPrecioPlatillo(p.getPrecio());
        Double subtotal = lo.getSubtotal();
        if (!conLin.agregar(lo)) {
            JOptionPane.showMessageDialog(this, "Se ha generado un problema interno.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        LineaExt le = new LineaExt(lo, p);
        //Actualizamos de forma rara el total del ticket...
        ((TicketExt) lstTickets.getSelectedValue()).getTicket().setTotal(
                ((TicketExt) lstTickets.getSelectedValue()).getTicket().getTotal() + subtotal);

        if (!conTic.actualizar(((TicketExt) lstTickets.getSelectedValue()).getTicket())) {
            JOptionPane.showMessageDialog(this, "Se ha generado un problema interno.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        modelOrdenes.addElement(le);
        lsnOrdenes.setModel(modelOrdenes);
        spnCantidad.setValue(new Integer(1));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int index = lsnOrdenes.getSelectedIndex();
        if (index != -1) {
            LineaExt le = (LineaExt) lsnOrdenes.getSelectedValue();
            Double subtotal = le.getLinea().getSubtotal();
            //Intentamos eliminar la linea en BD
            if (conLin.eliminar(le.getLinea())) {
                //restamos al total del ticket...
                ((TicketExt) lstTickets.getSelectedValue()).getTicket().setTotal(
                        ((TicketExt) lstTickets.getSelectedValue()).getTicket().getTotal() - subtotal);
                modelOrdenes.remove(index);
                if (!conTic.actualizar(((TicketExt) lstTickets.getSelectedValue()).getTicket())) {
                    JOptionPane.showMessageDialog(this, "Se ha generado un problema interno.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Se ha generado un problema interno.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (lsnOrdenes.getModel().getSize() != 0) {
            Double totalPagar = ticketSeleccionado.getTicket().getTotal();
            Double cambio = cobrar(totalPagar);
            if (cambio == -totalPagar) {
                return;
            }
            TicketInfo ti = ticketSeleccionado.getTicket();
            JOptionPane.showMessageDialog(this, "Su cambio es " + df.format(cambio), "Cambio", JOptionPane.INFORMATION_MESSAGE);
            ti.setRecibio(cambio + totalPagar);
            ti.setCambio(cambio);
            ti.setCobrado(true);
            if (conTic.actualizar(ti)) {
                cargarMesas();
                cargarTickets();
                ocultarPanelOrden();
                mostrarPanelTicket();
            } else {
                JOptionPane.showMessageDialog(this, "Se generó un error interno en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay platillos por cobrar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(lstTickets.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "No hay un ticket seleccionado para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            TicketExt t = (TicketExt) lstTickets.getSelectedValue();
            if(!conLin.eliminarLineasTicket(t.getTicket().getIdTicket())){
                JOptionPane.showMessageDialog(this, "Se generó un error interno en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } 
            if(!conTic.eliminar(t.getTicket())) {
                JOptionPane.showMessageDialog(this, "Se generó un error interno en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            cargarMesas();
            cargarTickets();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private Double cobrar(Double total) {
        String res = JOptionPane.showInputDialog("El total a pagar es de " + df.format(total) + ", ingrese la cantidad que el cliente le ha proporcionado:");
        Double ingreso = 0d;
        if (res != null) {
            try {
                ingreso = Double.parseDouble(res);
                if (ingreso <= total) {
                    return cobrar(total);
                }
            } catch (Exception e) {
                return cobrar(total);
            }
        }
        return ingreso - total;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelListaOrden;
    private javax.swing.JPanel PanelOrden;
    private javax.swing.JPanel PanelPlatillos;
    private javax.swing.JPanel PanelTicket;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegresar;
    public javax.swing.JComboBox cboCategoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JTextField jtfNombre;
    private javax.swing.JList lsnOrdenes;
    private javax.swing.JList lstMesas;
    private javax.swing.JList lstMesero;
    public javax.swing.JList lstPlatillos;
    private javax.swing.JList lstTickets;
    public javax.swing.JSpinner spnCantidad;
    // End of variables declaration//GEN-END:variables

    @Override
    public void activate() {
        init();
    }
}
