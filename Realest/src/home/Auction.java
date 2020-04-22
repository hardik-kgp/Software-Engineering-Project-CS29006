/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import Controller.DB;
import Dao.Customer;
import static java.lang.Integer.max;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author hardik
 */
public class Auction extends javax.swing.JFrame {

    /**
     * Creates new form Auction
     */
    int property_id,baseprice,duration,findpropertyid;
    String username;
    int ownerid;
    private int mybid;
    public Auction() {
        this.ownerid = 1;
        initComponents();
    }
    public void setownerid(int id){
        this.ownerid = id;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Add to Auction");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 242, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 69, 680, 450));

        jTextField1.setText("Enter Property id");
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
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 34, 169, 46));

        jTextField2.setText("Enter Base Price");
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 107, 169, 51));

        jTextField3.setText("Enter Duration");
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 176, 169, 48));

        jTextField5.setText("Enter Auction id");
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 305, 169, 48));

        jTextField6.setText("Enter Your bid");
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 371, 169, 40));

        jButton2.setText("Place bid");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 429, 154, -1));

        jLabel1.setText("Property_id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 34, 145, 46));

        jLabel2.setText("Base Price");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 107, 145, 51));

        jLabel3.setText("Duration (in minutes)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 176, -1, 48));

        jLabel5.setText("Auction_id");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 305, 107, 48));

        jLabel6.setText("Your bid");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 107, 40));

        jLabel7.setBackground(new java.awt.Color(170, 162, 221));
        jLabel7.setFont(new java.awt.Font("Chilanka", 1, 24)); // NOI18N
        jLabel7.setText("                         Ongoing Auctions");
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 0, 680, 68));

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 477, 76, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/home/images/auction(2).jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
        this.mybid = Integer.parseInt(jTextField6.getText());
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        property_id = Integer.parseInt(jTextField1.getText());
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
        duration = Integer.parseInt(jTextField3.getText());
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(!jTextField1.getText().trim().matches("[0-9]+"))
            JOptionPane.showMessageDialog(null,"Invalid Propperty id" , "ERROR", JOptionPane.ERROR_MESSAGE);
        else if(!jTextField2.getText().trim().matches("[0-9]+"))
            JOptionPane.showMessageDialog(null,"Invalid Base Price" , "ERROR", JOptionPane.ERROR_MESSAGE);
        else if(!jTextField3.getText().trim().matches("[0-9]+"))
            JOptionPane.showMessageDialog(null,"Invalid duration","ERROR", JOptionPane.ERROR_MESSAGE);
        else{
            java.sql.Timestamp now = new java.sql.Timestamp(new java.util.Date().getTime());
            now.setTime(now.getTime()+duration*60*1000);
            Connection con = DB.getConnection();
            PreparedStatement pst1;
            try {
                pst1 = con.prepareStatement("SELECT * FROM auction");
                ResultSet rs1 = pst1.executeQuery();
                int count = 0;
                while(rs1.next()){
                    count = max(rs1.getInt("Auction_id"),count);
                }
                int auctionid = count + 1;
                PreparedStatement ps;
                ps = con.prepareStatement("insert into auction(Auction_id,Property_id,Ends_at,Owner_id,Baseprice,Winning_bid, Current_winner) values(?,?,?,?,?,?,?)");
                ps.setInt(1,auctionid);
                ps.setInt(2,this.property_id);
                ps.setTimestamp(3,now);
                ps.setInt(4,this.ownerid);
                ps.setInt(5,this.baseprice);
                ps.setInt(6,this.baseprice);
                ps.setString(7, "No Bids Yet!");
                int status=ps.executeUpdate();
                fetch();
                JOptionPane.showMessageDialog(this, "Your Request has been sent for approval!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(Auction.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        baseprice = Integer.parseInt(jTextField2.getText());
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!jTextField5.getText().trim().matches("[0-9]+"))
            JOptionPane.showMessageDialog(null,"Invalid Auction id" , "ERROR", JOptionPane.ERROR_MESSAGE);
        else if(!jTextField6.getText().trim().matches("[0-9]+"))
            JOptionPane.showMessageDialog(null,"Invalid Bid" , "ERROR", JOptionPane.ERROR_MESSAGE);
        else{
            try{
                int status=0;
                this.username = Customer.findusername(this.ownerid);
                try{
                    try (Connection con = DB.getConnection()) {
                        PreparedStatement ps=con.prepareStatement("UPDATE auction SET Winning_bid = ? , Current_winner = ? WHERE Auction_id = ? and Winning_bid < ?");  
                        ps.setInt(1,this.mybid);
                        ps.setString(2,this.username);
                        ps.setInt(3,this.findpropertyid);
                        ps.setInt(4, this.mybid);
                        status=ps.executeUpdate();
                    }
                }catch(SQLException e){System.out.println(e);}
                JOptionPane.showMessageDialog(null, "Bid Placed Successfully", "Success!", JOptionPane.INFORMATION_MESSAGE);
                fetch();
            }catch(SQLException ex){Logger.getLogger(Auction.class.getName()).log(Level.SEVERE, null,ex);}
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        UserDashboard u1 = new UserDashboard();
        u1.setid(this.ownerid);
        u1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
        this.findpropertyid = Integer.parseInt(jTextField5.getText());
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
        if(jTextField1.getText().equals("Enter Property id"))
            jTextField1.setText("");
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        // TODO add your handling code here:
        if(jTextField2.getText().equals("Enter Base Price"))
            jTextField2.setText("");
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        // TODO add your handling code here:
        if(jTextField3.getText().equals("Enter Duration"))
            jTextField3.setText("");
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
        // TODO add your handling code here:
        if(jTextField5.getText().equals("Enter Auction id"))
            jTextField5.setText("");
    }//GEN-LAST:event_jTextField5FocusGained

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained
        
        if(jTextField6.getText().equals("Enter Your bid"))
            jTextField6.setText("");
    }//GEN-LAST:event_jTextField6FocusGained
    
    public final void fetch() throws SQLException{
        Connection con = DB.getConnection();
        PreparedStatement pst1;
        java.sql.Timestamp now = new java.sql.Timestamp(new java.util.Date().getTime());       
        pst1 = con.prepareStatement("Select Auction_id, Property_id, Ends_at, Owner_id,Baseprice, Winning_bid, Current_winner from  auction where Ends_at > ? and status = 1");
        pst1.setTimestamp(1, now);
        ResultSet rs1 = pst1.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs1));
    }
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
            java.util.logging.Logger.getLogger(Auction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Auction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Auction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Auction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Auction().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
