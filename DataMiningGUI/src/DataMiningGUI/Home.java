/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataMiningGUI;

import static DataMiningGUI.CreateEditPatientProfile.txtBoxPatientID;
import static DataMiningGUI.CreateEditPatientProfile.txtBoxPatientName;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Willian
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Second
     */
    public Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ImportPatient = new javax.swing.JButton();
        CreatePatient = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Results = new javax.swing.JButton();
        drugSearch = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Select Patient:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("  or");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 30, 20));

        ImportPatient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ImportPatient.setText("Search for Patient");
        ImportPatient.setName("Import"); // NOI18N
        ImportPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportPatientActionPerformed(evt);
            }
        });
        getContentPane().add(ImportPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 170, 40));

        CreatePatient.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CreatePatient.setText("Create Patient Profile");
        CreatePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatePatientActionPerformed(evt);
            }
        });
        getContentPane().add(CreatePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 180, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(" Medication "));
        jPanel2.setToolTipText("");
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Choose Medication to Search:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        Results.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Results.setText("View Results");
        Results.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultsActionPerformed(evt);
            }
        });
        jPanel2.add(Results, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, 40));

        drugSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A-Methapred", "Abacavir Sulfate", "Acetaminophen", "Acetic Acid", "Acticin (Permethrin)", "Anhydrous Morphine" }));
        drugSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drugSearchActionPerformed(evt);
            }
        });
        jPanel2.add(drugSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 370, 90));
        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CreatePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatePatientActionPerformed
        
        // TODO add your handling code here:
        JFrame createEdit = new CreateEditPatientProfile();
        createEdit.setVisible(true);
        this.setVisible(false);
        
        //Updating entry in database
        Connection conn = JdbcConnection.GetConnection();
        ResultSet SetFromTable = null;
        
        try {
            String query = "Insert into PATIENT(PTNAME, PTID, PTAGE, PTSEX, PTWEIGHT) values(?,?,?,?,?)";
            String queryEvent = "Insert into EVENT(EVID, EVDRUGSTARTDT, DRUGID, PATIENTID, DRUGDOSAGE, DRUGENDDT, EVDETAILS) values(?,?,?,?,?,?,?)";
            String queryDrugs = "Insert into DRUG( DRUGID, DRUGNAME) values(?, ?)";
            
            
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, CreateEditPatientProfile.txtBoxPatientName.getText());
            pst.setString(2, CreateEditPatientProfile.txtBoxPatientID.getText());
            pst.setString(3, CreateEditPatientProfile.txtBoxAge.getText());
            pst.setString(4, CreateEditPatientProfile.txtBoxGender.getText());
            pst.setString(5, CreateEditPatientProfile.txtBoxWeight.getText());
            pst.execute();
                        
            int row = CreateEditPatientProfile.tablePatientDrugHistory.getSelectedRow();
            String Table_Click = (CreateEditPatientProfile.tablePatientDrugHistory.getModel().getValueAt(row, 0).toString());        
            
            PreparedStatement pst2 = conn.prepareStatement(queryDrugs);
            pst2.setString(4, CreateEditPatientProfile.txtBoxPatientID.getText());
            pst2.execute();
            
            
            ResultSet rs1 = pst2.executeQuery();
            if (rs1.next()){
                String add1 = rs1.getString("Drugs");
                pst2.setString(1, add1);
            }
            PreparedStatement pst1 = conn.prepareStatement(queryEvent);
            ResultSet rs = pst1.executeQuery();
            if (rs.next()){
                
                String add1 = rs.getString("Dosage");
                pst1.setString(5, add1);
                
                String add2 = rs.getString("Start");
                pst1.setString(2, add2);
                
                String add3 = rs.getString("Stop");
                pst1.setString(6, add3);
            }
            
            pst.execute();
                    
            JOptionPane.showMessageDialog(null,"Saved");
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_CreatePatientActionPerformed

    private void ResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultsActionPerformed
        
        // TODO add your handling code here:
        DrugReport drugReport = new DrugReport();
        DrugReport.medArea.setText((String) Home.drugSearch.getSelectedItem());
        DrugReport.nameArea.setText(CreateEditPatientProfile.txtBoxPatientName.getText());
        
        //Set rating
        DrugReport.ratingBar.setValue(71);
        
        drugReport.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ResultsActionPerformed

    private void ImportPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportPatientActionPerformed
        // TODO add your handling code here:
        JFrame importRecord = new ImportRecord();
        importRecord.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ImportPatientActionPerformed

    private void drugSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drugSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drugSearchActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreatePatient;
    private javax.swing.JButton ImportPatient;
    private javax.swing.JButton Results;
    public static javax.swing.JComboBox drugSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
