/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.CIH;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Jania
 */
public class TabJogo extends javax.swing.JFrame {

    /**
     * Creates new form TabJogo
     */
    public TabJogo() {
        initComponents();
        iniciaTab();
        lbl_vez_esq.setForeground(Color.red);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_vez_esq = new javax.swing.JLabel();
        lbl_vez_esq1 = new javax.swing.JLabel();
        lbl_11 = new javax.swing.JLabel();
        lbl_12 = new javax.swing.JLabel();
        lbl_l1 = new javax.swing.JLabel();
        lbl_c1 = new javax.swing.JLabel();
        lbl_c2 = new javax.swing.JLabel();
        lbl_c3 = new javax.swing.JLabel();
        lbl_13 = new javax.swing.JLabel();
        lbl_14 = new javax.swing.JLabel();
        lbl_c4 = new javax.swing.JLabel();
        lbl_15 = new javax.swing.JLabel();
        lbl_16 = new javax.swing.JLabel();
        lbl_c5 = new javax.swing.JLabel();
        lbl_c6 = new javax.swing.JLabel();
        lbl_c7 = new javax.swing.JLabel();
        lbl_17 = new javax.swing.JLabel();
        lbl_18 = new javax.swing.JLabel();
        lbl_c8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 29, -1, -1));

        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 29, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("X");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(377, 21, 17, 24));

        lbl_vez_esq.setText("*");
        jPanel1.add(lbl_vez_esq, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 21, 12, 24));

        lbl_vez_esq1.setText("*");
        jPanel1.add(lbl_vez_esq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 24, 12, 24));

        lbl_11.setBackground(new java.awt.Color(0, 0, 0));
        lbl_11.setForeground(new java.awt.Color(255, 255, 255));
        lbl_11.setText("13");
        lbl_11.setOpaque(true);
        jPanel1.add(lbl_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 510, 45, 45));

        lbl_12.setBackground(new java.awt.Color(255, 255, 255));
        lbl_12.setText("14");
        lbl_12.setOpaque(true);
        jPanel1.add(lbl_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 45, 45));

        lbl_l1.setText("1");
        jPanel1.add(lbl_l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 527, -1, -1));

        lbl_c1.setText("1");
        jPanel1.add(lbl_c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, -1, -1));

        lbl_c2.setText("2");
        jPanel1.add(lbl_c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, -1, -1));

        lbl_c3.setText("4");
        jPanel1.add(lbl_c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 560, -1, -1));

        lbl_13.setBackground(new java.awt.Color(0, 0, 0));
        lbl_13.setForeground(new java.awt.Color(255, 255, 255));
        lbl_13.setText("11");
        lbl_13.setOpaque(true);
        jPanel1.add(lbl_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 45, 45));

        lbl_14.setBackground(new java.awt.Color(255, 255, 255));
        lbl_14.setText("12");
        lbl_14.setOpaque(true);
        jPanel1.add(lbl_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 45, 45));

        lbl_c4.setText("3");
        jPanel1.add(lbl_c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, -1, -1));

        lbl_15.setBackground(new java.awt.Color(0, 0, 0));
        lbl_15.setForeground(new java.awt.Color(255, 255, 255));
        lbl_15.setText("17");
        lbl_15.setOpaque(true);
        jPanel1.add(lbl_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 510, 45, 45));

        lbl_16.setBackground(new java.awt.Color(255, 255, 255));
        lbl_16.setText("18");
        lbl_16.setOpaque(true);
        jPanel1.add(lbl_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 45, 45));

        lbl_c5.setText("5");
        jPanel1.add(lbl_c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, -1, -1));

        lbl_c6.setText("6");
        jPanel1.add(lbl_c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 560, -1, -1));

        lbl_c7.setText("8");
        jPanel1.add(lbl_c7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, -1, -1));

        lbl_17.setBackground(new java.awt.Color(0, 0, 0));
        lbl_17.setForeground(new java.awt.Color(255, 255, 255));
        lbl_17.setText("15");
        lbl_17.setOpaque(true);
        jPanel1.add(lbl_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 45, 45));

        lbl_18.setBackground(new java.awt.Color(255, 255, 255));
        lbl_18.setText("16");
        lbl_18.setOpaque(true);
        jPanel1.add(lbl_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 45, 45));

        lbl_c8.setText("7");
        jPanel1.add(lbl_c8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 560, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
            java.util.logging.Logger.getLogger(TabJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabJogo().setVisible(true);
                
            }
            
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_11;
    private javax.swing.JLabel lbl_12;
    private javax.swing.JLabel lbl_13;
    private javax.swing.JLabel lbl_14;
    private javax.swing.JLabel lbl_15;
    private javax.swing.JLabel lbl_16;
    private javax.swing.JLabel lbl_17;
    private javax.swing.JLabel lbl_18;
    private javax.swing.JLabel lbl_c1;
    private javax.swing.JLabel lbl_c2;
    private javax.swing.JLabel lbl_c3;
    private javax.swing.JLabel lbl_c4;
    private javax.swing.JLabel lbl_c5;
    private javax.swing.JLabel lbl_c6;
    private javax.swing.JLabel lbl_c7;
    private javax.swing.JLabel lbl_c8;
    private javax.swing.JLabel lbl_l1;
    private javax.swing.JLabel lbl_vez_esq;
    private javax.swing.JLabel lbl_vez_esq1;
    // End of variables declaration//GEN-END:variables
 
    private void iniciaTab(){
        jLabel1.setText(JOptionPane.showInputDialog("Digite nome do Jogador 1:").toUpperCase());
        jLabel2.setText(JOptionPane.showInputDialog("Digite nome do Jogador 2:").toUpperCase());
    }
}
