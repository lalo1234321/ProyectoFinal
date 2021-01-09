/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.swing.JFrame;
import levels.targetShottingLevel.CanvasCatShottingLevel;
import levels.targetShottingLevel.CanvasMonsterShottingLevel;
import levels.thinkAndChoose.CatTACHlevel;
import levels.thinkAndChoose.ChickenTACHlevel;
import levels.thinkAndChoose.PinkyTACHLevel;
import levels.thinkAndChoose.Kitten;
import levels.thinkAndChoose.Pinky;
import levels.thinkAndChoose.Pio;
/**
 *
 * @author theowl
 */
public class MenuLevel extends javax.swing.JFrame {
    public static Animator animator;
    private int character;
 
    /**
     * Creates new form MenuLevel
     */
    public MenuLevel(int op) {
        this.character = op;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose a level");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 276, 43));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/targetShotting.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 260, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/thinkAndChoose.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 260, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/onePlusTwo.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 270, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/backMenu.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/selectionMenuBackground1.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        Menu1 menu = new Menu1();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

        JFrame frame = new JFrame("Robot 3D");
        GLCanvas canvas = new GLCanvas();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(character == 1)
            canvas.addGLEventListener(new CanvasCatShottingLevel(frame));
        if(character ==2)
            canvas.addGLEventListener(new CanvasMonsterShottingLevel(frame));
        frame.add(canvas);
        frame.setSize(1000, 800);
        animator = new Animator(canvas);
        // Center frame
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        animator.start();
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        
        if(character==1){
            Kitten k=new Kitten();
            k.setVisible(true);
            
        }else{
            if(character==2){
            Pinky p= new Pinky();
            p.setVisible(true);
            }else{
                if(character==3){
                Pio pio=new Pio();
                pio.setVisible(true);
                }
             }
        }
        
//        frame.add(canvas);
//        frame.setSize(1000, 800);
//        final Animator animator = new Animator(canvas); 
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        animator.start();
    }//GEN-LAST:event_jLabel3MouseClicked
 
    
    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
