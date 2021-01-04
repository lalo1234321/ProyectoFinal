
package levels.targetShottingLevel;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import personajes.DrawMonst;
/**
 *
 * @author theowl
 */
public class CanvasMonsterShottingLevel implements GLEventListener, MouseListener, MouseMotionListener, KeyListener {
    
    
    private float rotx = 0.01f;
    private float roty = 0.01f;
    private int mousex;
    private int mousey;
    boolean[] keys = new boolean[256]; //to know which key is pressed
    public int opc;
    private JFrame frame;
    public CanvasMonsterShottingLevel(JFrame frame) {
        this.frame = frame;
    }
    @Override
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        
        gl.setSwapInterval(1);
        float light_ambient[]={0.9f, 0.9f, 0.9f, 1.0f};
        float light_diffuse[]={0.3f, 0.3f, 0.3f, 1.0f};
        float light_specular[]={1.0f, 1.0f, 1.0f, 1.0f};
        float light_position[] = {1.0f,1.5f,1.0f,0.0f };
        
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, light_ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, light_diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, light_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);
        gl. glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glClearColor(0.9f, 0.9f, 0.9f, 0.9f); 
        gl.glShadeModel(GL.GL_SMOOTH);
        drawable.addMouseListener((MouseListener) this);
        drawable.addMouseMotionListener((MouseMotionListener) this);
        drawable.addKeyListener((KeyListener) this);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu=new GLU();
        
        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        //gl.glMatrixMode(GL.GL_MODELVIEW);
        
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        glu.gluLookAt(0.1f, 7.0f, 0.0f,
                      0.2f, 0.0f, 0.0f, 
                      0.0f, 0.0f, 1.0f);
        
        
        //gl.glTranslatef(0f, 0f, 0f);
        gl.glRotatef(rotx,1.0f, 0.0f, 0.0f);
        gl.glRotatef(roty,0.0f, 1.0f, 0.0f);
        gl.glRotatef(110,0.0f, 0.2f, 1.0f);
        //DrawMonst monstr = new DrawMonst();
        DrawPinky pinky =new DrawPinky();
        pinky.algo(gl);
        /*switch(opc){
            case 0:
                
                pinky.draw_monst(gl);
                break;
            case 1:
                
                pinky.saludar(gl);
            break;
            case 2:
                pinky.brincar(gl);
            break;
            case 3:
                pinky.caminar(gl);
            break;
            case 4:
                pinky.boo(gl);
            break;
            case 5:
                pinky.aplaude(gl);
            break;
            case 6:
                pinky.guinar(gl);
            break;
            case 7:
                pinky.triste(gl);
            break;
            case 8:
                JOptionPane.showMessageDialog(null, "Elaborado por: Munoz Torres Tania Paola");
                opc=0;
            break;
            case 9:
                JOptionPane.showMessageDialog(null, "Press S to say hello, B to jump, C to walk,\n E to zoom in,"
                        + "A to applaud, G to wink,\n D to be sad, Z about,\n 1-5 change the background");
                opc=0;
            break;
//            case 10:
//                monstr.draw_monst(gl);
//                try{
//                    File iCielo=new File("src/images/cielom.jpg");
//                    tCielo=TextureIO.newTexture(iCielo, true);
//
//                    File iPiso=new File("src/images/piso.jpg");
//                    tPiso=TextureIO.newTexture(iPiso, true);
//                
//                    File iglobos=new File("src/images/globos.jpg");
//                    
//                    tFrente=TextureIO.newTexture(iglobos, true);
//
//                    tIzquierda=TextureIO.newTexture(iglobos, true);
//
//                    tDerecha=TextureIO.newTexture(iglobos, true);
//
//                    tAtras=TextureIO.newTexture(iglobos, true);
//                }catch(IOException ex){
//
//                }
//                break;
//            case 11:
//                monstr.draw_monst(gl);
//                try{
//                    File iCielo=new File("src/images/cielom.jpg");
//                    tCielo=TextureIO.newTexture(iCielo, true);
//
//                    File iPiso=new File("src/images/piso.jpg");
//                    tPiso=TextureIO.newTexture(iPiso, true);
//                
//                    File iladosm=new File("src/images/ladosm.jpg");
//                    
//                    tFrente=TextureIO.newTexture(iladosm, true);
//
//                    tIzquierda=TextureIO.newTexture(iladosm, true);
//
//                    tDerecha=TextureIO.newTexture(iladosm, true);
//
//                    tAtras=TextureIO.newTexture(iladosm, true);
//                }catch(IOException ex){
//
//                }
//                break;
//            case 12:
//                monstr.draw_monst(gl);
//                try{
//                    File iCielo=new File("src/images/cielom.jpg");
//                    tCielo=TextureIO.newTexture(iCielo, true);
//
//                    File iPiso=new File("src/images/piso.jpg");
//                    tPiso=TextureIO.newTexture(iPiso, true);
//                
//                    File iyeii=new File("src/images/yeii.jpg");
//                    
//                    tFrente=TextureIO.newTexture(iyeii, true);
//
//                    tIzquierda=TextureIO.newTexture(iyeii, true);
//
//                    tDerecha=TextureIO.newTexture(iyeii, true);
//
//                    tAtras=TextureIO.newTexture(iyeii, true);
//                }catch(IOException ex){
//
//                }
//                break;
//            case 13:
//                monstr.draw_monst(gl);
//                try{
//                    File iCielo=new File("src/images/cielom.jpg");
//                    tCielo=TextureIO.newTexture(iCielo, true);
//
//                    File iPiso=new File("src/images/piso.jpg");
//                    tPiso=TextureIO.newTexture(iPiso, true);
//                
//                    File istarw=new File("src/images/starwars.jpg");
//                    
//                    tFrente=TextureIO.newTexture(istarw, true);
//
//                    tIzquierda=TextureIO.newTexture(istarw, true);
//
//                    tDerecha=TextureIO.newTexture(istarw, true);
//
//                    tAtras=TextureIO.newTexture(istarw, true);
//                }catch(IOException ex){
//
//                }
//                break;
//            case 14:
//                monstr.draw_monst(gl);
//                try{
//                    File iCielo=new File("src/images/cielom.jpg");
//                    tCielo=TextureIO.newTexture(iCielo, true);
//
//                    File iPiso=new File("src/images/piso.jpg");
//                    tPiso=TextureIO.newTexture(iPiso, true);
//                
//                    File im=new File("src/images/paint.jpg");
//                    
//                    tFrente=TextureIO.newTexture(im, true);
//
//                    tIzquierda=TextureIO.newTexture(im, true);
//
//                    tDerecha=TextureIO.newTexture(im, true);
//
//                    tAtras=TextureIO.newTexture(im, true);
//                }catch(IOException ex){
//
//                }
//                break;
        }*/
        
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(65.0f, h, 1.0, 20.0);
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
        mousex = me.getX();
        mousey= me.getY();
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
        int x=me.getX();
        int y=me.getY();
        Dimension size =me.getComponent().getSize();
        float thetax = 360.0f * ((float) (x-mousex)/ (float) size.width);
        float thetay = 360.0f * ((float) (mousey-y)/ (float) size.height);
        mousex= x;
        mousey= y;
        rotx += thetax;
        roty += thetay;
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()<250 && keys[e.getKeyCode()]==false){
            keys['S']= false;
            keys['B']= false;
            keys['C']= false;
            keys['E']= false;
            keys['A']= false;
            keys['G']= false;
            keys['D']= false;
            keys['Z']= false;
            keys['I']= false;
            keys['1']= false;
            keys['2']= false;
            keys['3']= false;
            keys['4']= false;
            keys['5']= false;
            keys[e.getKeyCode()]=true;
            try{
            }catch(NullPointerException ex){
                //JOptionPane.showMessageDialog(null,""+ex.getLocalizedMessage());
            }
            switch (e.getKeyCode()){
                case 'S': opc=1;
                        
                        break;
                case 'B': opc=2;
                        
                        break;
                case 'C': opc=3;
                        
                        break;
                case 'E': opc=4;
                        
                        break;
                case 'A': opc=5;
                        
                        break;   
                case 'G': opc=6;
                        break;  
                case 'D': opc=7;
                        break; 
                case 'Z':opc=8;
                        break;
                case 'I':opc=9;
                        break;
                case '1': opc=10;
                        break;   
                case '2': opc=11;
                        break;  
                case '3': opc=12;
                        break; 
                case '4':opc=13;
                        break;
                case '5':opc=14;
                        break; 
                default: opc=0;
                        break;
            
        }
        
        
    }
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
    
    
    
    
}
