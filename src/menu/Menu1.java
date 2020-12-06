/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javax.swing.JFrame;
import com.sun.opengl.util.Animator;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JPanel;
import menu.MenuCanvasCat;
/**
 *
 * @author theowl
 */
public class Menu1 extends javax.swing.JFrame  {
     JFrame frame;
     private Animator animator1;
     private Animator animator2;
     private Animator animator3;
    /**
     * Creates new form Menu1
     */
    public Menu1() {
        
        
        initComponents();
        gLCanvas1.addGLEventListener(new MenuCanvasKitty());
        animator1 = new Animator(gLCanvas1);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator1.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        animator1.start();
        
        gLCanvas2.addGLEventListener(new CanvasPinky());
        animator2 = new Animator(gLCanvas2);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator2.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        animator2.start();
        
        gLCanvas3.addGLEventListener(new MenuCanvasCat());
        animator3 = new Animator(gLCanvas3);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator3.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        
        
        //initCanvas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        gLCanvas2 = new javax.media.opengl.GLCanvas();
        gLCanvas3 = new javax.media.opengl.GLCanvas();
        gLJPanel1 = new javax.media.opengl.GLJPanel();
        gLCanvas1 = new javax.media.opengl.GLCanvas();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/space.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(gLCanvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 320, 230));
        getContentPane().add(gLCanvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 430, 300, 230));

        gLJPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        gLJPanel1.add(gLCanvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 230));

        getContentPane().add(gLJPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 310, 230));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("TEA GAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 240, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/about.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/aboutChange.png")));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/about.png")));
    }//GEN-LAST:event_jLabel4MouseExited
    
    public final void initCanvas() {
        /*MenuCanvasCat cat = new MenuCanvasCat();
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(cat);
        canvas.setBounds(0, 0, 300, 300);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        System.out.println("Boton");*/
       /* b1.setBackground(new java.awt.Color(255, 102, 102));
        b1.setText("Hola");
        b1.setBounds(0, 0, 300, 200);
        getContentPane().add(b1);
        pack();*/
    }
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.media.opengl.GLCanvas gLCanvas1;
    private javax.media.opengl.GLCanvas gLCanvas2;
    private javax.media.opengl.GLCanvas gLCanvas3;
    private javax.media.opengl.GLJPanel gLJPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JButton b1;
}
