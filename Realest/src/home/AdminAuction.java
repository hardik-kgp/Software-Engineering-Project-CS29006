/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import Controller.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class AdminAuction extends javax.swing.JFrame {

    /**
     * Creates new form AdminAuction
     */
    private int Auctionid;
    public AdminAuction() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 0, 590, 440));

        jLabel1.setBackground(new java.awt.Color(236, 168, 99));
        jLabel1.setFont(new java.awt.Font("Noto Sans CJK HK", 1, 20)); // NOI18N
        jLabel1.setText(" Approve Pending Auction Requests");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 80));

        jButton1.setText("Approve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 100, 51));

        jTextField1.setText("Enter Auction id");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 177, 42));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(244, 232, 232));
        jLabel2.setText("Enter Auction Id ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 130, 42));

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 100, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/images/admindashboard.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -2, 480, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Approves a Auction to be displayed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         if(jTextField1.getText().equals("")||jTextField1.getText().equals("Enter Auction id"))
                JOptionPane.showMessageDialog(null,"Auction id Cannot be empty!","ERROR",JOptionPane.ERROR_MESSAGE);
        else if(!jTextField1.getText().trim().matches("[0-9]+"))
                JOptionPane.showMessageDialog(null,"Auction id can only contain numbers!","ERROR",JOptionPane.ERROR_MESSAGE);
        else{
            //Update
            int status=0;
		try{
                    try (Connection con = DB.getConnection()) {
                         //JOptionPane.showMessageDialog(null, Auctionid, "Success!", JOptionPane.INFORMATION_MESSAGE);  
                        PreparedStatement ps=con.prepareStatement("UPDATE auction SET status = 1 WHERE Auction_id = ?");
                        ps.setInt(1,Auctionid);
                        status=ps.executeUpdate();
                        fetch();
                    }
		}catch(SQLException e){System.out.println(e);}
            if(status>0){
                            JOptionPane.showMessageDialog(null, "Update Successful", "Success!", JOptionPane.INFORMATION_MESSAGE);               
            }
            else{
                JOptionPane.showMessageDialog(null, "Unable to approve this auction!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }

        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AdminDashboard.main(new String[]{});
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        Auctionid = Integer.parseInt(jTextField1.getText());
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
        if(jTextField1.getText().equals("Enter Auction id"))
            jTextField1.setText("");
    }//GEN-LAST:event_jTextField1FocusGained
    // displays data to the table
    public final void fetch() throws SQLException{
        Connection con = DB.getConnection();
        PreparedStatement pst1;
        java.sql.Timestamp now = new java.sql.Timestamp(new java.util.Date().getTime());       
        pst1 = con.prepareStatement("Select Auction_id,Property_id,Ends_at,Owner_id,Baseprice from auction WHERE status = 0 and Ends_at > ?");
        pst1.setTimestamp(1, now);
        ResultSet rs1 = pst1.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs1));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(() -> {
            new AdminAuction().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
