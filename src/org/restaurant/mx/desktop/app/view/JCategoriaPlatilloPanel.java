package org.restaurant.mx.desktop.app.view;

import org.restaurant.mx.controladores.ControladorCategoriaPlatillo;
import org.restaurant.mx.modelo.CategoriaExt;
import org.restaurant.mx.modelo.CategoriaPlatillo;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import org.developercircle.base.ui.IAccessibleMDI;
import org.developercircle.base.ui.mdi.AbstractPanelView;
import org.developercircle.base.ui.mdi.JAbstractMDI;

/**
 *
 * @author JAST
 */
public class JCategoriaPlatilloPanel extends AbstractPanelView {

    private IAccessibleMDI app;
    private ControladorCategoriaPlatillo conCat;
    private DefaultListModel dlm;
    private DefaultComboBoxModel dcbm;
    
    public JCategoriaPlatilloPanel(JAbstractMDI app) {
        initComponents();
        this.app = app;
    }

    private void init() {
        conCat = new ControladorCategoriaPlatillo();
        cargarCategorias();
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        cboPadres = new javax.swing.JComboBox();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList();
        tfDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/accept.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cboPadres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/add.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Categoria padre:");

        lstCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstCategorias);

        tfDescripcion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Descripción:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/accept_page.png"))); // NOI18N
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cboPadres, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnEliminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cboPadres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevo)
                            .addComponent(btnGuardar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!tfDescripcion.getText().equals("")) {
            CategoriaPlatillo cp = new CategoriaPlatillo();
            cp.setEliminado(false);
            cp.setDescripcion(tfDescripcion.getText());
            CategoriaPlatillo catPla = (CategoriaPlatillo) cboPadres.getSelectedItem();
            cp.setCategoriaPadre(catPla != null ? catPla.getIdCategoria() : null);
            if (conCat.agregar(cp)) {
                JOptionPane.showMessageDialog(this, "La categoria se logró guardar con éxito",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarCategorias();
            } else {
                JOptionPane.showMessageDialog(this, "Se ha generado un error interno al guardar la categoria.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese una descripción para la categoria.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        CategoriaPlatillo cp = (CategoriaPlatillo) lstCategorias.getSelectedValue();
        List<CategoriaPlatillo> hijos = conCat.listar(cp.getIdCategoria());
        if (hijos != null) {
            JOptionPane.showMessageDialog(this, "No es posible eliminar la categoria, existen categorias dependientes.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (lstCategorias.getSelectedIndex() != -1) {
            cp.setEliminado(true);
            if (conCat.actualizar(cp)) {
                JOptionPane.showMessageDialog(this, "La categoria se logró eliminar con éxito",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
//                limpiarCampos();
                cargarCategorias();
            } else {
                JOptionPane.showMessageDialog(this, "Se ha generado un error interno al eliminar la categoria.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay una categoria seleccionada.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void lstCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCategoriasMouseClicked
        CategoriaPlatillo cp = (CategoriaPlatillo) lstCategorias.getSelectedValue();

        if (cp != null) {
            tfDescripcion.setText(cp.getDescripcion());
            CategoriaPlatillo cpTemp;
            if (cp.getCategoriaPadre() == null) {
                cboPadres.setSelectedIndex(0);
                return;
            }
            int index = 0;
            int tamPadres = cboPadres.getModel().getSize();
            
            for (int i = 1; i < tamPadres; i++) {
                cpTemp = (CategoriaPlatillo) cboPadres.getModel().getElementAt(i);
                if (cpTemp.getIdCategoria().equals(cp.getCategoriaPadre())) {
                    index = i;
                }
            }
            cboPadres.setSelectedIndex(index);
        } 
    }//GEN-LAST:event_lstCategoriasMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (((CategoriaPlatillo) lstCategorias.getSelectedValue()).getIdCategoria().equals(((CategoriaPlatillo) cboPadres.getSelectedItem()).getIdCategoria())) {
            JOptionPane.showMessageDialog(this, "Categoria padre incorrecta.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!tfDescripcion.getText().equals("")) {
            CategoriaPlatillo cp = (CategoriaPlatillo) lstCategorias.getSelectedValue();
            cp.setDescripcion(tfDescripcion.getText());
            cp.setCategoriaPadre(((CategoriaExt) cboPadres.getSelectedItem()).getIdCategoria());
            if (conCat.actualizar(cp)) {
                JOptionPane.showMessageDialog(this, "La categoria se logró actualizar con éxito",
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
                cargarCategorias();
            } else {
                JOptionPane.showMessageDialog(this, "Se ha generado un error interno al actualizar la categoria.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese una descripción para la categoria.",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public void cargarCategorias() {
        List<CategoriaPlatillo> cps = conCat.listar();

        dlm = new DefaultListModel();
        dcbm = new DefaultComboBoxModel();
        dcbm.addElement(null);

        if (cps != null && !cps.isEmpty()) {
            for (CategoriaPlatillo cp : cps) {
                CategoriaExt ce = new CategoriaExt();
                ce.setCategoriaPlatillo(cp);
                dlm.addElement(cp);
                dcbm.addElement(ce);
            }
        }
        lstCategorias.setModel(dlm);
        cboPadres.setModel(dcbm);
    }

    public void limpiarCampos() {
        tfDescripcion.setText(null);
        cboPadres.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cboPadres;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstCategorias;
    private javax.swing.JTextField tfDescripcion;
    // End of variables declaration//GEN-END:variables

    @Override
    public void activate() {
        init();        
    }
}
