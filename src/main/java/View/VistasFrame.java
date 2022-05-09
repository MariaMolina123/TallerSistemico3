/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Listas.Coordenada;
import Listas.Nodo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Optional;


/**
 *
 * @author Maria Fernanda
 */

public class VistasFrame extends javax.swing.JFrame {
    
    public Nodo lineas;
    public Nodo rectangulos;
    public Nodo circulos;
    
    

    public int xStart = 0;
    public int yStart = 0;
    public int xEnd = 0;
    public int yEnd = 0;

    public VistasFrame() {
        initComponents();
        
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;
        setSize(width/2, height/2);		

        setLocationRelativeTo(null);

        pLienzo.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                Point mause = MouseInfo.getPointerInfo().getLocation();
                xStart = mause.x - (pLienzo.getX()+ 25 + (pLienzo.getWidth() / 2));
                yStart = mause.y - (pLienzo.getY()+ 90 + pLienzo.getHeight() / 2);
                xEnd = mause.x - (pLienzo.getX()+ 25 + (pLienzo.getWidth() / 2));
                yEnd = mause.y - (pLienzo.getY()+ 90 + pLienzo.getHeight() / 2);
            }
            public void mouseReleased(MouseEvent evt) {
                if(cbxFigura.getSelectedItem() == "Linea"){
                    lineas = agregar(lineas, new Coordenada(xStart, yStart, xEnd, yEnd));
                }else if(cbxFigura.getSelectedItem() == "Rectángulo"){
                    rectangulos = agregar(rectangulos, new Coordenada(xStart, yStart, xEnd - xStart, yEnd - yStart));
                }else{
                    circulos = agregar(circulos, new Coordenada(xStart, yStart, xEnd - xStart, yEnd - yStart));
                }
                repaint();
            }
        });

        pLienzo.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent evt) {
                Point mause = MouseInfo.getPointerInfo().getLocation();
                xEnd = mause.x - (pLienzo.getX()+ 25 + (pLienzo.getWidth() / 2));
                yEnd = mause.y - (pLienzo.getY()+ 90 + pLienzo.getHeight() / 2);
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        super.paint(g);
        g = pLienzo.getGraphics();
        g.setColor(Color.WHITE);
        
        if(cbxFigura.getSelectedItem() == "Linea"){
            g.drawLine(xStart, yStart, xEnd, yEnd);
        }else if(cbxFigura.getSelectedItem() == "Rectángulo"){
            g.drawRect(xStart, yStart, xEnd - xStart, yEnd - yStart);
        }else{
            g.drawOval(xStart, yStart, xEnd - xStart, yEnd - yStart);
        }
        
        for (Nodo i = lineas; i != null; i = i.getNext()) {
            g.drawLine(i.getValue().getxStart(), i.getValue().getyStart(), i.getValue().getxEnd(), i.getValue().getyEnd());
        }
        for (Nodo i = rectangulos; i != null; i = i.getNext()) {
            g.drawRect(i.getValue().getxStart(), i.getValue().getyStart(), i.getValue().getxEnd(), i.getValue().getyEnd());
        }
        for (Nodo i = circulos; i != null; i = i.getNext()) {
            g.drawOval(i.getValue().getxStart(), i.getValue().getyStart(), i.getValue().getxEnd(), i.getValue().getyEnd());
        }
    }
    
    public Nodo agregar(Nodo cabeza, Coordenada value) {
        if (cabeza == null) {
            cabeza = new Nodo(value);
            return cabeza;
        }
        Optional<Nodo> lastNode = getUltimoNodo(cabeza);
        Nodo node = lastNode.get();
        node.setNext(new Nodo(value));
        return cabeza;
    }
 
    public Optional<Nodo> getUltimoNodo(Nodo cabeza) {
        if (cabeza != null) {
            Nodo current = cabeza;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            return Optional.of(current);
        } else {
            return Optional.empty();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbxFigura = new javax.swing.JComboBox<>();
        btnAbrir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        pLienzo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxFigura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Linea", "Rectángulo", "Circulo" }));

        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open.png"))); // NOI18N

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        btnGuardar.setMaximumSize(new java.awt.Dimension(976, 726));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxFigura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAbrir)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 505, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAbrir)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(cbxFigura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pLienzo.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout pLienzoLayout = new javax.swing.GroupLayout(pLienzo);
        pLienzo.setLayout(pLienzoLayout);
        pLienzoLayout.setHorizontalGroup(
            pLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pLienzoLayout.setVerticalGroup(
            pLienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pLienzo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(VistasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistasFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAbrir;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JComboBox<String> cbxFigura;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel pLienzo;
    // End of variables declaration//GEN-END:variables
}
