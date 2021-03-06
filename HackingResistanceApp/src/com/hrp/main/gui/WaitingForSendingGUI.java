/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WaitingForSendingGUI.java
 *
 * Created on Jul 2, 2010, 3:29:54 PM
 */
package com.hrp.main.gui;

/**
 *
 * @author Staff
 */
public class WaitingForSendingGUI extends javax.swing.JDialog implements Runnable {

    public static String statusStr = "";
    public static boolean sendingComplete = false;

    /** Creates new form WaitingForSendingGUI */
    public WaitingForSendingGUI(javax.swing.JDialog parent, boolean modal, String status) {
        super(parent, modal);
        initComponents();
        new Thread(this).start();
        WaitingForSendingGUI.statusStr = status;
        statusLabel.setText(WaitingForSendingGUI.statusStr);
        setLocationRelativeTo(parent);
        setVisible(true);
    }

    public void run() {
        while (!sendingComplete) {
            try {
                statusLabel.setText(WaitingForSendingGUI.statusStr);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
        this.dispose();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        statusLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sending E-mail");

        jProgressBar1.setIndeterminate(true);

        statusLabel.setText("Sending E-mail. . .");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel)
                .addContainerGap(424, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusLabel)
                .addGap(6, 6, 6)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                WaitingForSendingGUI dialog = new WaitingForSendingGUI(new javax.swing.JDialog(), true, "");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
