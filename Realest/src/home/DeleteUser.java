/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import Dao.Customer;
import javax.swing.JOptionPane;

/**
 *
 * @author hardik
 */
public class DeleteUser extends javax.swing.JFrame {

    /**
     * Creates new form DeleteUser
     */
    Customer user = new Customer();
    private int id;
    public DeleteUser() {
        initComponents();
    }
    public void setId(int id){
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idfield = new javax.swing.JTextField();
        deletebutton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        idfield.setText("Enter User id");
        idfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idfieldFocusGained(evt);
            }
        });
        idfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idfieldActionPerformed(evt);
            }
        });
        getContentPane().add(idfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 139, 177, 48));

        deletebutton.setText("Delete user");
        deletebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebuttonActionPerformed(evt);
            }
        });
        getContentPane().add(deletebutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 220, 111, 49));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 70, -1));

        jLabel1.setBackground(new java.awt.Color(92, 207, 249));
        jLabel1.setFont(new java.awt.Font("URW Chancery L", 1, 24)); // NOI18N
        jLabel1.setText("                               Delete User");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 76));

        jLabel3.setText("Enter User id");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 120, 40));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/images/dashboard.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idfieldActionPerformed
        // TODO add your handling code here:
        int id1;
        id1 = Integer.parseInt(idfield.getText());
        user.setUserid(id1);
    }//GEN-LAST:event_idfieldActionPerformed

    private void deletebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebuttonActionPerformed
        // TODO add your handling code here:
        
        if(idfield.getText().equals("")||idfield.getText().equals("Enter User id"))
                JOptionPane.showMessageDialog(DeleteUser.this,"Userid Cannot be empty!","ERROR",JOptionPane.ERROR_MESSAGE);
        else if(!idfield.getText().trim().matches("[0-9]+"))
                JOptionPane.showMessageDialog(DeleteUser.this,"Userid can only contain numbers!","ERROR",JOptionPane.ERROR_MESSAGE);
        else{
            int status = user.delete(user.getUserid());
            if(status>0){
                JOptionPane.showMessageDialog(DeleteUser.this,"User deleted successfully","Success!",JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(DeleteUser.this,"Sorry, unable to delete!","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
    }//GEN-LAST:event_deletebuttonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AdminDashboard.main(new String[]{});

        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void idfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idfieldFocusGained
        // TODO add your handling code here:
        if(idfield.getText().equals("Enter User id"))
            idfield.setText("");
    }//GEN-LAST:event_idfieldFocusGained

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
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DeleteUser().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deletebutton;
    private javax.swing.JTextField idfield;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
