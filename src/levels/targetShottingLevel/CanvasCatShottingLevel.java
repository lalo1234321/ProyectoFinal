/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels.targetShottingLevel;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import personajes.Robot;
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import javax.media.opengl.GL;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import javax.swing.JOptionPane;
/**
 *
 * @author theowl
 */
public class CanvasCatShottingLevel implements GLEventListener, MouseListener, MouseMotionListener, KeyListener{
    static GL gl;
    static GLU glu;
    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    public boolean[] keys=new boolean[256]; //to know which key is pressed
    private GLUquadric q=null;
    
    //position of stan in the window
    private static final float X_POSITION=0f;
    private static final float Y_POSITION=-0.08f;
    private static final float Z_POSITION=0f;
    Texture t;
    Texture tAtras;  
    Texture tFrente;  
    Texture tDerecha;  
    Texture tIzquierda;  
    Texture tCielo;
    Texture tPiso;
    //Fondo2
    Texture tLados2,tCielo2,tLados3,tCielo3,tLados4,tCielo4,tLados5,tPiso5,tCielo5;
    private static final String instructions ="Instructivo:"
            + "\nT = Take the bowl from the cat"
            + "\nJ = Mutate the cat"
            + "\nL = Mutate eyes and lie down"
            + "\nE = Mutate and rotate"
            + "\nH = Shot lasers from the eyes ";
    private Robot robot;
    @Override
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        gl.setSwapInterval(1);
         //set up lighting
        float light_ambient[]={0.9f, 0.9f, 0.9f, .10f};
        float light_diffuse[]={0.3f, 0.3f, 0.3f, .10f};
        float light_specular[]={1.0f, 1.0f, 1.0f, .10f};
        float light_position[] = {.60f,1.0f,.40f,0.0f };
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, light_ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, light_diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, light_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);
        gl. glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);
        // Setup the drawing area and shading mode
        gl.glClearColor(0.9f, 0.9f, 0.9f, 0.9f);
        robot = new Robot();
        robot.movingForward = true;
        gl.glShadeModel(GL.GL_PHONG_WIN);
        try {
            File iCielo = new File("src/backGround/shottingLevel/sky.jpg");
            tCielo = TextureIO.newTexture(iCielo,true);            
            File iAtras = new File("src/backGround/shottingLevel/sidesV1.jpg");
            tAtras = TextureIO.newTexture(iAtras,true);
            File iPiso = new File("src/backGround/shottingLevel/floor.jpg");
            tPiso = TextureIO.newTexture(iPiso,true);
        } catch (Exception e) {            
        }
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);
    }      

    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        glu.gluLookAt(0.1f,0.0f,3.9f,// eye
                      0.0f,0.0f,0.0f,  // looking at
                      0.0f,0.0f,3.0f   // is up
                    );
        
        // Move the whole scene
        gl.glTranslatef(X_POSITION, Y_POSITION, Z_POSITION);
        gl.glRotatef(view_rotx,1.0f,0.0f,0.0f);
        gl.glRotatef(view_roty,0.0f,1.0f,0.0f);
        gl.glRotatef(90,0.0f,0.0f,1.0f);
        gl.glRotatef(180,0.0f,1.0f,0.0f);
        gl.glRotatef(-40,1.0f,0.0f,0.0f);
        gl.glPushMatrix();
        
        
        
        gl.glPushMatrix();
        gl.glScaled(1f,.9f ,.5f );
        gl.glTranslated(0,0 ,0 );
        robot.fondo(gl, glu, tAtras);
        gl.glPopMatrix();
        gl.glFlush();
        
        gl.glPushMatrix();
        gl.glScaled(1f,.9f ,1f );
        gl.glTranslated(0,0 ,-1f );
        gl.glRotatef(-90, 1f, 0f, 0f);
        robot.fondo(gl, glu, tPiso);
        gl.glPopMatrix();
        gl.glFlush();
        
        gl.glPushMatrix();
        gl.glScaled(1f,.9f ,1f );
        gl.glTranslated(0,0 ,-1f );
        gl.glRotatef(90,1f , 0f, 0f);
        robot.fondo(gl, glu, tCielo);
        gl.glPopMatrix();
        gl.glFlush();
        
        //ParteIzquierda
        gl.glPushMatrix();
        gl.glScaled(1f,.9f ,1f );
        gl.glRotatef(90,0f , 1f, 0f);
        robot.fondo(gl, glu, tAtras);
        gl.glPopMatrix();
        gl.glFlush();
        
        //ParteDerecha
        gl.glPushMatrix();
        gl.glScaled(1f,.9f ,1f );
        gl.glRotatef(-90,0f , 1f, 0f);
        robot.fondo(gl, glu, tAtras);
        gl.glPopMatrix();
        gl.glFlush();

        //frente
        gl.glPushMatrix();
        gl.glScaled(1f,.9f ,1f );
        gl.glTranslated(-1f,-1f ,10.0f );
        gl.glRotatef(0, 0f, 0f, 1f);
        robot.fondo(gl, glu, tAtras);
        gl.glPopMatrix();
        gl.glFlush();
        gl.glPushMatrix();
        gl.glTranslated(0, 0, 1.2);
        robot.drawRobot(gl, keys['J'],keys['T'], keys['E'], keys['L'], keys['H'],keys['A'], keys['D'], true);
        gl.glPopMatrix();
        gl.glPopMatrix();
        gl.glFlush();
    }      

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        q=glu.gluNewQuadric();
        if (height <= 0) { // avoid a divide by zero error!
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
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        oldMouseX = me.getX();
        oldMouseY = me.getY(); 
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        int x = me.getX();
        int y = me.getY();
        Dimension size = me.getComponent().getSize();
        float thetaX = 360.0f * ( (float)(x-oldMouseX)/(float)size.width);
        float thetaY = 360.0f * ( (float)(oldMouseY-y)/(float)size.height);
        oldMouseX = x;
        oldMouseY = y;
        view_rotx += thetaX;
        view_roty += thetaY;
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode()<250 && keys[ke.getKeyCode()]==false){   
            keys['A']=false;
            keys['D']=false;
            keys['E']=false;
            keys['J']=false;
            keys['T']=false;
            keys['G']=false;
            keys['L']=false;
            keys['H']=false;
            keys['Z']=false;
            keys['X']=false;
            keys['C']=false;
            keys['V']=false;
            keys['P']=false;
            keys[ke.getKeyCode()]=true;   
            System.out.println("Key pressed "+ke.getKeyChar());
            switch(ke.getKeyCode()) {
                 case 'P':
                {
                    JOptionPane.showMessageDialog(null, instructions);
                    
                }
                    break;    
            
            }
        }
        else
            keys[ke.getKeyCode()]=false;    
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
        
}
