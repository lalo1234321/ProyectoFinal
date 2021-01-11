/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels.onePlusTwo;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import personajes.DrawMonst;

/**
 *
 * @author abrah
 */
public class PinkyLevel extends OnePlusTwo implements GLEventListener, MouseListener, MouseMotionListener, KeyListener
{

    private float rotx = 0.01f;
    private float roty = 0.01f;
    private int mousex;
    private int mousey;
    boolean[] keys = new boolean[256]; //to know which key is pressed
    public int opc;

    //variables para trasladar la caja
    float contador;
    Timer timer;
    boolean moverI, moverD;
    int move;
    //variables para colisiones
    Cube cub1, cub2, cub3, cubP;
    float zBox, Qres;
    //arreglo con los numeros a usar
    int[] arr;

    private static final float X_POSITION = 1f;
    private static final float Y_POSITION = 0f;
    private static final float Z_POSITION = -2f;

    public PinkyLevel(int personaje)
    {
        super(personaje);

        boolean bool = true;
        arr = new int[11];
        Qres = 0;
        do
        {
            randomizer();
            if (arr[arr.length - 1] == 1 || arr[arr.length - 1] == 2 || arr[arr.length - 1] == 3)
            {
                bool = false;
            }
        } while (bool);
//        for (int i = 0; i < arr.length - 1; i++)
//        {
//            labN.setText(labN.getText() + arr[i] + " ");
//        }
//        labN.setText(labN.getText() + " = " + arr[arr.length - 1]);

        formatoLabel();
        this.canvas1.addGLEventListener(this);
        animator1 = new Animator(canvas1);
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
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
        this.canvas1.requestFocus();
    }

    @Override
    public void init(GLAutoDrawable drawable)
    {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        gl.setSwapInterval(1);
        float light_ambient[] =
        {
            0.9f, 0.9f, 0.9f, 1.0f
        };
        float light_diffuse[] =
        {
            0.3f, 0.3f, 0.3f, 1.0f
        };
        float light_specular[] =
        {
            1.0f, 1.0f, 1.0f, 1.0f
        };
        float light_position[] =
        {
            1.0f, 1.5f, 1.0f, 0.0f
        };

        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, light_ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, light_diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, light_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glClearColor(0.9f, 0.9f, 0.9f, 0.9f);
        gl.glShadeModel(GL.GL_SMOOTH);
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);

        move = 0;
        contador = 0;
        zBox = -3;

        //posicion de los obstaculos
        cub1 = new Cube(-1, 0, zBox, 0.5f, 1, 1);
        cub2 = new Cube(0, 0, zBox, 0.5f, 1, 1);
        cub3 = new Cube(1, 0, zBox, 0.5f, 1, 1);
        //posicion del personaje
        cubP = new Cube(Qres, 1f, 1f, 0.5f, 1, 1);

        timer = new Timer(100, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                contador = contador + 0.1f;
                //System.out.println("contador: " + contador);
                zBox = zBox + 0.1f;
                cub1.setZ(zBox);
                cub2.setZ(zBox);
                cub3.setZ(zBox);
            }
        });
        timer.start();
    }

    @Override
    public void display(GLAutoDrawable drawable)
    {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        Obstacles obs = new Obstacles(gl, glu);

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        //gl.glMatrixMode(GL.GL_MODELVIEW);

        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        glu.gluLookAt(0.1f, 7.0f, 0.0f,
                0.2f, 0.0f, 0.0f,
                0.0f, 0.0f, 1.0f);

        //gl.glTranslatef(0f, 0f, 0f);
        gl.glRotatef(rotx, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(roty, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(110, 0.0f, 0.2f, 1.0f);

        gl.glPushMatrix();
                gl.glTranslatef(move, 0, 0);
        DrawMonst monstr = new DrawMonst();
        switch (opc)
        {
            case 0:
                
                monstr.draw_monst(gl);
                
                break;
            case 1:
                monstr.saludar(gl);
                break;
            case 2:
                monstr.brincar(gl);
                break;
            case 3:
                monstr.caminar(gl);
                break;
            case 4:
                monstr.boo(gl);
                break;
            case 5:
                monstr.aplaude(gl);
                break;
            case 6:
                monstr.guinar(gl);
                break;
            case 7:
                monstr.triste(gl);
                break;
            case 8:
                JOptionPane.showMessageDialog(null, "Elaborado por: Munoz Torres Tania Paola");
                opc = 0;
                break;
            case 9:
                JOptionPane.showMessageDialog(null, "Press S to say hello, B to jump, C to walk,\n E to zoom in,"
                        + "A to applaud, G to wink,\n D to be sad, Z about,\n 1-5 change the background");
                opc = 0;
                break;
        }
        gl.glPopMatrix();
        //dibujar obstaculos
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, contador);
        obs.drawObstacles();
        gl.glPopMatrix();

        boolean bool = true;
        if (contador >= 3)
        {
            comprobarCajas();
            contador = 0;
            zBox = -3;
            labN.setText("");
            int k = arr.length - 1;
            do
            {
                randomizer();
                if (arr[k] == 1 || arr[k] == 2 || arr[k] == 3)
                {
                    bool = false;
                }
            } while (bool);
            formatoLabel();
        }

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
    {
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
        glu.gluPerspective(65.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged)
    {

    }

    @Override
    public void mouseClicked(MouseEvent me)
    {

    }

    @Override
    public void mousePressed(MouseEvent me)
    {
        mousex = me.getX();
        mousey = me.getY();
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {

    }

    @Override
    public void mouseEntered(MouseEvent me)
    {

    }

    @Override
    public void mouseExited(MouseEvent me)
    {

    }

    @Override
    public void mouseDragged(MouseEvent me)
    {
        int x = me.getX();
        int y = me.getY();
        Dimension size = me.getComponent().getSize();
        float thetax = 360.0f * ((float) (x - mousex) / (float) size.width);
        float thetay = 360.0f * ((float) (mousey - y) / (float) size.height);
        mousex = x;
        mousey = y;
        rotx += thetax;
        roty += thetay;

    }

    @Override
    public void mouseMoved(MouseEvent me)
    {

    }

    @Override
    public void keyTyped(KeyEvent ke)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() < 250 && keys[e.getKeyCode()] == false)
        {
            keys['S'] = false;
            keys['B'] = false;
            keys['C'] = false;
            keys['E'] = false;
            keys['A'] = false;
            keys['G'] = false;
            keys['D'] = false;
            keys['Z'] = false;
            keys['I'] = false;
            keys['1'] = false;
            keys['2'] = false;
            keys['3'] = false;
            keys['4'] = false;
            keys['5'] = false;
            keys[e.getKeyCode()] = true;
            try
            {
            } catch (NullPointerException ex)
            {
                //JOptionPane.showMessageDialog(null,""+ex.getLocalizedMessage());
            }
            switch (e.getKeyCode())
            {
                case 'S':
                    opc = 1;

                    break;
                case 'B':
                    opc = 2;

                    break;
                case 'C':
                    opc = 3;

                    break;
                case 'E':
                    opc = 4;

                    break;
                case 'A':
                    opc = 5;

                    break;
                case 'G':
                    opc = 6;
                    break;
                case 'D':
                    opc = 7;
                    break;
                case 'Z':
                    opc = 8;
                    break;
                case 'I':
                    opc = 9;
                    break;
                case '1':
                    opc = 10;
                    break;
                case '2':
                    opc = 11;
                    break;
                case '3':
                    opc = 12;
                    break;
                case '4':
                    opc = 13;
                    break;
                case '5':
                    opc = 14;
                    break;
                default:
                    opc = 0;
                    break;

            }
        }

        switch (e.getKeyCode())
        {
            case 37:// flecha izquierda
                if (move != -1)
                {
                    cubP.setX(cubP.getX() - 1);
                    move--;
                    Qres--;
                    cubP.setX(Qres);
                    System.out.println("Qres: " + Qres);
                }
                break;
            case 39://flecha derecha
                if (move != 1)
                {
                    cubP.setX(cubP.getX() + 1);
                    move++;
                    Qres++;
                    cubP.setX(Qres);
                    System.out.println("Qres: " + Qres);
                }
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent ke)
    {

    }

    public boolean colisionCaja(Cube r1, Cube r2)
    {
        return r1.getX() <= r2.getX() + r2.getAncho()
                && r1.getX() + r1.getAncho() >= r2.getX()
                && r1.getY() <= r2.getY() + r2.getAlto()
                && r1.getY() + r1.getAlto() >= r2.getY()
                && r1.getZ() <= r2.getZ() + r2.getDeep()
                && r1.getZ() + r1.getDeep() >= r2.getZ();
    }

    public void comprobarCajas()
    {
        switch (arr[arr.length - 1])
        {
            case 1:
                if (colisionCaja(cub2, cubP) || colisionCaja(cub3, cubP))
                {
                    JOptionPane.showMessageDialog(null, "Game Over");
                    new menu.Menu1().setVisible(true);
                    this.dispose();
                }
                break;
            case 2:
                if (colisionCaja(cub1, cubP) || colisionCaja(cub3, cubP))
                {
                    JOptionPane.showMessageDialog(null, "Game Over");
                    new menu.Menu1().setVisible(true);
                    this.dispose();
                }
                break;
            case 3:
                if (colisionCaja(cub2, cubP) || colisionCaja(cub1, cubP))
                {
                    JOptionPane.showMessageDialog(null, "Game Over");
                    new menu.Menu1().setVisible(true);
                    this.dispose();
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error inesperado");
        }

    }

    public int randomSign(int a)
    {
        if (Math.random() > 0.5)
        {
            a = a * -1;
        }
        return a;
    }

    public void randomizer()
    {
        int k = arr.length - 1;
        arr[k] = 0;
        for (int i = 0; i < k; i++)
        {
            arr[i] = randomSign(randomizer1());
            arr[k] = arr[k] + arr[i];
        }
    }

    public int randomizer1()
    {
        int a;
        while (true)
        {
            a = (int) (Math.random() * 10);
            if (a == 1 || a == 2 || a == 3)
            {
                break;
            }
        }
        return a;
    }

    public void formatoLabel()
    {
        String s = "";
        for (int i = 0; i < 10; i++)
        {
            if (arr[i] > 0)
            {
                if (!s.equals(""))
                {
                    s = s + "+" + arr[i];
                } else
                {
                    s = s + arr[i];
                }
            } else
            {
                s = s + arr[i];
            }
        }
        s = s + "=" + arr[10];
        labN.setText(s);
    }

    public static void main(String[] args)
    {
        new PinkyLevel(2).setVisible(true);
    }
}
