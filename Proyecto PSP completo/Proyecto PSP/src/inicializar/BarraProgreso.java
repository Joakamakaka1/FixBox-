/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inicializar;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author CHAPARRO
 */
public class BarraProgreso extends JFrame implements Runnable {

    private boolean bandera;

    /**
     * Creates new form NewJFrame
     */
    public BarraProgreso() {
        initComponents();
        setTitle("FixBox");
        setLocationRelativeTo(null);
        setResizable(false);
        bandera = false;
//        b1.addActionListener(new ActionListener() {
    //            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(rootPane,"holaaaa");
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                
//            }
//        });
   setIconImage(getIconImage());
    }
    @Override
    public Image getIconImage(){
        Image icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("./iconimages/images.jpg"));
        return icono;
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
        jbar = new javax.swing.JProgressBar();
        b1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(219, 219, 209));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbar.setBackground(new java.awt.Color(255, 51, 102));
        jbar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jbar.setForeground(new java.awt.Color(255, 0, 51));
        jbar.setStringPainted(true);
        jPanel1.add(jbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 1200, 60));

        b1.setBackground(new java.awt.Color(255, 51, 102));
        b1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        b1.setForeground(new java.awt.Color(255, 255, 255));
        b1.setText("INICIAR SISTEMA");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel1.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 250, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed

        Thread hilo = new Thread(this);

        hilo.start();


    }//GEN-LAST:event_b1ActionPerformed

    @Override
    public void run() {
        b1.setEnabled(false);
        b1.setVisible(false);
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(30);
                this.getBar().setValue(i);

                if (this.getBar().getValue() == 100) {
                    this.bandera = true;

                }
            } catch (InterruptedException ex) {
                Thread.currentThread().isInterrupted();
            }

        }
        if (bandera) {
            JOptionPane.showMessageDialog(new BarraProgreso(), "Bienvenido a FixBox");
            this.dispose();
            InicioSesion in = new InicioSesion();
            in.setVisible(true);
        }
    }

    public void setBar(JProgressBar bar) {
        this.jbar = bar;
    }

    public JProgressBar getBar() {
        return jbar;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jbar;
    // End of variables declaration//GEN-END:variables
}
