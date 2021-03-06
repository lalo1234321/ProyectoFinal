/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javax.swing.JFrame;
import com.sun.opengl.util.Animator;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author theowl
 */
public class Menu1 extends javax.swing.JFrame
{

    JFrame frame;
    private Animator animator1;
    private Animator animator2;
    private Animator animator3;

    static AudioStream audio;
    static InputStream sounds;
    static Clip clip;

    /**
     * Creates new form Menu1
     */
    public Menu1()
    {
        initComponents();
        reproducir("");
        gLCanvas1.addGLEventListener(new MenuCanvasKitty());
        animator1 = new Animator(gLCanvas1);
        addWindowListener(new WindowAdapter()
        {

            @Override
            public void windowClosing(WindowEvent e)
            {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable()
                {

                    public void run()
                    {
                        animator1.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        animator1.start();

        gLCanvas2.addGLEventListener(new CanvasPinky());
        animator2 = new Animator(gLCanvas2);
        addWindowListener(new WindowAdapter()
        {

            @Override
            public void windowClosing(WindowEvent e)
            {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable()
                {

                    public void run()
                    {
                        animator2.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        animator2.start();

        gLCanvas3.addGLEventListener(new CanvasChicken());
        animator3 = new Animator(gLCanvas3);
        addWindowListener(new WindowAdapter()
        {

            @Override
            public void windowClosing(WindowEvent e)
            {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable()
                {

                    public void run()
                    {
                        animator3.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        animator3.start();

        try
        {
            reproducir("src/menu/sonido1");
        } catch (Exception e)
        {
        }

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
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/space.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(gLCanvas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 320, 230));
        getContentPane().add(gLCanvas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 430, 300, 230));

        gLJPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        gLJPanel1.add(gLCanvas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 230));

        getContentPane().add(gLJPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 310, 230));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("TEA GAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 240, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/about.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/instructions.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 210, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/useCat.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/usePinky.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/useChicken.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/space.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/aboutChange.png")));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/about.png")));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/instructionsChange.png")));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/instructions.png")));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/useCatChange.png")));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/useCat.png")));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/usePinkyChange.png")));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/useChickenChange.png")));
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/useChicken.png")));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/usePinky.png")));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        JOptionPane.showMessageDialog(null, "Cat intructions: click the character and press P \n"
                + "In Target Level press W to shoot laser, press A or D to move the character \n"
                + "Pinky instructions: click the character and press  I\n"
                + "Chicken instrucions: click the character and press H");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        JOptionPane.showMessageDialog(null, "Has been made by:\nDomínguez Cordero Eduardo 18280748\n"
                + "Morales Vallejo Abraham Emanuel 18280753\nMunoz Torres Tania Paola 17280516");
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        new MenuLevel(1).setVisible(true);
        clip.close();
        this.dispose();

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        new MenuLevel(2).setVisible(true);
        clip.close();
        this.dispose();

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        new MenuLevel(3).setVisible(true);
        clip.close();
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    public static void sonido(File sonido)
    {
        try
        {
            sounds = new FileInputStream(sonido);
            audio = new AudioStream(sounds);
            AudioPlayer.player.start(audio);
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }

    public static void reproducir(String efecto)
    {
        try
        {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(efecto)));
            clip.start();
            clip.loop(1000);
        } catch (Exception e)
        {
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public final void initCanvas()
    {
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JButton b1;
}
