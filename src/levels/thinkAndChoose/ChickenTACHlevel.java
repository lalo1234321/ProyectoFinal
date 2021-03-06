/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels.thinkAndChoose;

import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import personajes.DrawMonst;
import personajes.DrawPollo;

/**
 *
 * @author TANIA
 */
public class ChickenTACHlevel implements GLEventListener, MouseListener, MouseMotionListener, KeyListener {
    Frame frame;
    int[] ban;
    int con;
    boolean accion=false;
    int k, x;
    int opc=0;
    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    DrawMonst monstr;

    //position of stan in the window
    private static final float X_POSITION = 0f;
    private static final float Y_POSITION = 0f;
    private static final float Z_POSITION = 0f;


    @Override
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        ban = new int[14];
        monstr = new DrawMonst();
        resetBan();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);

        // Enable VSync
        gl.setSwapInterval(1);


        k = 0;
        x = 0;
        float[] amb =
        {
            0.9f, 0.8f, 0.8f, 0.7f
        };
        float[] dif =
        {
            0.2f, 0.2f, 0.2f, 0.5f
        };
        float[] spec =
        {
            0.1f, 0.1f, 0.1f, 0.5f
        };
        float[] pos =
        {
            0f, 6f, 0f, 1f
        };
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, amb, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, dif, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, spec, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, pos, 0);

        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.9f, 0.9f, 0.9f, 0.8f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        DrawPollo pollo = new DrawPollo(gl, glu, ban, con);

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        glu.gluLookAt(
                0.01f, 0.0f, 4.0f,// eye
                0.0f, 0.0f, 0.0f, // looking at
                0f, 0.0f, 1.0f // is up
        );

        // Move the whole scene
        gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);
        gl.glRotatef(view_rotx, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(view_roty, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(90, 0.0f, 0.0f, 1.0f);

//        iniciarCon();
//        gl.glTranslatef(0, -0.5f, 0);
//        gl.glPushMatrix();
//        pollo.DrawBird();
//        gl.glPopMatrix();
        if (opc!=15&&opc!=16) {
            iniciarCon();
            gl.glTranslatef(0, -0.5f, 0);
            gl.glPushMatrix();
            pollo.DrawBird();
            gl.glPopMatrix();
        }
           
        if(opc==15){
            gl.glTranslatef(0f, -0.5f, 0.5f);
            gl.glPushMatrix();
            pollo.DrawBird();
            gl.glPopMatrix();
            accion=true;
            if(monstr.rebota(gl, accion)==true){
                gl.glTranslatef(0f, -0.5f, 0.5f);
                monstr.pelota(gl, glu);
                JOptionPane.showMessageDialog(null, "Felicidades! Has atrapado la pelota");
            }
        }
        if(opc==16){
            gl.glTranslatef(0f, -.5f, -0.5f);
            gl.glPushMatrix();
            pollo.DrawBird();
            gl.glPopMatrix();
            accion=false;
        }
                
        if (opc!=15){
          monstr.rebota(gl,accion);  
        }
        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0)
        { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        oldMouseX = e.getX();
        oldMouseY = e.getY();
        ban[13] = 1;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Dimension size = e.getComponent().getSize();
        float thetaX = 360.0f * ((float) (x - oldMouseX) / (float) size.width);
        float thetaY = 360.0f * ((float) (oldMouseY - y) / (float) size.height);
        oldMouseX = x;
        oldMouseY = y;
        view_rotx += thetaX;
        view_roty += thetaY;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case 81://Q
                ban[0] = 1;
                break;
            case 87://W
                ban[1] = 1;
                break;
            case 69://E
                ban[2] = 1;
                break;
            case 90: //Z mover cabeza
                ban[6] = 1;
                break;
            case 88: //X mover mo�o
                ban[7] = 1;
                break;
            case 72://H
                ayuda();
                break;
            case 27://Esc
                String s1 = "Alumno: Abraham Emanuel Morales Vallejo\n";
                s1 = s1 + "Instituto Tecnol�gico de Toluca\n";
                s1 = s1 + "Dibujo en 3D graficaci�n";
                JOptionPane.showMessageDialog(null, s1, "Acerca de:", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 68://D ojo salton
                ban[5] = 0;
                ban[3] = 0;
                ban[9] = 0;
                ban[10] = 0;
                ban[4] = 1;
                break;
            case 70://F ojo muerto
                ban[4] = 0;
                ban[3] = 0;
                ban[9] = 0;
                ban[10] = 0;
                ban[5] = 1;
                break;
            case 82://R original
                ban[5] = 0;
                ban[4] = 0;
                ban[9] = 0;
                ban[10] = 0;
                ban[3] = 1;
                break;
            case 65://A ojo V
                ban[5] = 0;
                ban[4] = 0;
                ban[10] = 0;
                ban[3] = 0;
                ban[9] = 1;
                break;
            case 83://S ojo sale de cara
                ban[4] = 0;
                ban[3] = 0;
                ban[5] = 0;
                ban[9] = 0;
                ban[10] = 1;
                break;
            case 49://1 normal
                ban[8] = 1;
                break;
            case 50://2 nuggets
                ban[8] = 2;
                break;
            case 51://3 mass factory
                ban[8] = 3;
                break;
            case 52://4 jaula
                ban[8] = 4;
                break;
            case 53://5 teatro
                ban[8] = 5;
                break;
            case '7':opc=15;
                    break;
            case '8':opc=16;
                    break; 
            default:
                try
                {
                    resetBan();
                } catch (Exception ke)
                {
                    JOptionPane.showMessageDialog(null, "Error inesperado", "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        System.out.println(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    public void resetBan()
    {
        ban[0] = 0;
        ban[1] = 0;
        ban[2] = 0;
        ban[3] = 1;
        ban[4] = 0;
        ban[5] = 0;
        ban[6] = 0;
        ban[7] = 0;
        ban[8] = 1;
        ban[9] = 0;
        ban[10] = 0;
        ban[11] = 0;
        ban[12] = 0;
        ban[13] = 0;
        con = 0;
    }
    public void iniciarCon()
    {
        con++;
        if (con >= 40)
        {
            con = 0;
        }
    }
    
    public void ayuda()
    {
        String s = "Options:\nEsc  About:\n";
        s = s + "Q  Move wings\n";
        s = s + "W  Move legs\n";
        s = s + "E  Move beak\n";
        s = s + "Z  Move head\n";
        s = s + "X  Move bow\n";
        s = s + "D  Bulging eyes\n";
        s = s + "F  Death face\n";
        s = s + "R  Original face\n";
        s = s + "A  Wink\n";
        s = s + "S  Jumping eyes\n";
        s = s + "H  Help (this dialog box)\n\n";
        s = s + "Press any other key to return to the original state";
        JOptionPane.showMessageDialog(null, s, "Help", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void ayuda1()
    {
        String s = "Opciones:\nEsc  Acerca de:\n";
        s = s + "Q  Mover alas\n";
        s = s + "W  Mover patas\n";
        s = s + "E  Mover pico\n";
        s = s + "Z  Mover cabeza\n";
        s = s + "X  Mover moo\n";
        s = s + "D  Cara ojos saltones\n";
        s = s + "F  Cara muerta\n";
        s = s + "R  Cara original\n";
        s = s + "A  Guio\n";
        s = s + "S  Ojos que brincan\n";
        s = s + "1  Granja\n";
        s = s + "2  Fabrica de nuggets\n";
        s = s + "3  Granja intensiva de pollos\n";
        s = s + "4  Jaula\n";
        s = s + "5  Teatro\n";
        s = s + "H  Ayuda (este cuadro de dialogo)\n\n";
        s = s + "Cualquier otra tecla para volver al estado original";
        JOptionPane.showMessageDialog(null, s, "Ayuda", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public Texture asigTex(String s) throws IOException
    {
        Texture textura;
        File t1 = new File(s);
        textura = TextureIO.newTexture(t1, true);
        return textura;
    }
    
}
