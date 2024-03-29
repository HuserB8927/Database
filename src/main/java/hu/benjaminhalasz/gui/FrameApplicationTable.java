/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.benjaminhalasz.gui;

import hu.benjaminhalasz.dao.DAOPerson;
import hu.benjaminhalasz.model.Application;
import hu.benjaminhalasz.model.Person;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

/**
 *
 * @author benjaminhalasz
 */
public class FrameApplicationTable extends javax.swing.JFrame implements ListSelectionListener {
    

    /**
     * Creates new form FrameApplicationTable
     */
    public FrameApplicationTable() {
        initComponents();
        ListSelectionModel selectionModel = jTable1.getSelectionModel();
        selectionModel.addListSelectionListener(this);
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
if (e.getSource() == jTable1.getSelectionModel()
            && e.getValueIsAdjusting()) { //only respond to mouseDown
            
            //get the value of the primary key column for row being clicked 
        TableModel model = (TableModel) jTable1.getModel();
        Integer i = (Integer) model.getValueAt(jTable1.getSelectedRow(), 0);
        
        //Create new instance of DatabaseManager and find the Person bean with this primary key
        
        DAOPerson dao = new DAOPerson();
        Person p = dao.findById(i);
        Application a = new Application();
        p.getId();
//        p.getApplication();
        dao.close();
        
        setVisible(false);
        dispose();   //     --> closing the MainFrameAdmin table (false and dispose)
        
        new FrameRegistrationForm(p, a).go();
}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("visa?autoReconnect=true&serverTimezone=UTC&useSSL=False&allowPublicKeyRetrieval=truePU").createEntityManager();
        applicationQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Application a");
        applicationList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : applicationQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, applicationList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${personId}"));
        columnBinding.setColumnName("Person Id");
        columnBinding.setColumnClass(hu.benjaminhalasz.model.Person.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${hasEmailSent}"));
        columnBinding.setColumnName("Has Email Sent");
        columnBinding.setColumnClass(Short.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameApplicationTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameApplicationTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameApplicationTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameApplicationTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameApplicationTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<hu.benjaminhalasz.model.Application> applicationList;
    private javax.persistence.Query applicationQuery;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    
        
        }

