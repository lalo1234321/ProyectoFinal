/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels.onePlusTwo;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
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
import java.io.File;
import java.io.IOException;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import personajes.Robot;

/**
 *
 * @author abrah
 */
public class KittyLevel extends OnePlusTwo implements GLEventListener, MouseListener, MouseMotionListener, KeyListener
{

    static GL gl;
    static GLU glu;
    private float view_rotx = 0.01f;
    private float view_roty = 0.01f;
    private int oldMouseX;
    private int oldMouseY;
    boolean[] keys = new boolean[256]; //to know which key is pressed
    private GLUquadric q = null;

    //position of stan in the window
    private static final float X_POSITION = 1f;
    private static final float Y_POSITION = 0f;
    private static final float Z_POSITION = -2f;
    Texture t;
    Texture tAtras;
    Texture tFrente;
    Texture tDerecha;
    Texture tIzquierda;
    Texture tCielo;
    Texture tPiso;

    //Agregar texturas
    Texture tex1[];

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

    public KittyLevel(int personaje)
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

    //Fondo2
    Texture tLados2, tCielo2, tLados3, tCielo3, tLados4, tCielo4, tLados5, tPiso5, tCielo5;
    private static final String instructions = "Instructivo:"
            + "\nT = Take the bowl from the cat"
            + "\nJ = Mutate the cat"
            + "\nL = Mutate eyes and lie down"
            + "\nE = Mutate and rotate"
            + "\nH = Shot lasers from the eyes ";

    @Override
    public void init(GLAutoDrawable drawable)
    {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        gl.setSwapInterval(1);
        //set up lighting
        float light_ambient[] =
        {
            0.9f, 0.9f, 0.9f, .10f
        };
        float light_diffuse[] =
        {
            0.3f, 0.3f, 0.3f, .10f
        };
        float light_specular[] =
        {
            1.0f, 1.0f, 1.0f, .10f
        };
        float light_position[] =
        {
            .60f, 1.0f, .40f, 0.0f
        };
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, light_ambient, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, light_diffuse, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, light_specular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, light_position, 0);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);

        tex1 = new Texture[6];
        try
        {
            textura1();
        } catch (Exception e)
        {
            System.err.println("Error en textura");
        }

        // Setup the drawing area and shading mode
        gl.glClearColor(0.9f, 0.9f, 0.9f, 0.9f);
        gl.glShadeModel(GL.GL_PHONG_WIN);
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
        drawable.addKeyListener(this);

        moverI = false;
        moverD = false;
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
        gl.glMatrixMode(GL.GL_MODELVIEW);

        // Reset the current matrix to the "identity"
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

        gl.glPushMatrix();
        gl.glTranslatef(move, 0, 0);
        gl.glRotatef(180, 0, 1, 0);
        Robot robot = new Robot();
        robot.drawRobot(gl, keys['J'], keys['T'], keys['E'], keys['L'], keys['H'], false, false, false, false);
        gl.glPopMatrix();

        //dibujar obstaculos
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, contador);
        obs.drawObstacles();
        gl.glPopMatrix();

        drawTex(robot, tex1, gl);

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
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height)
    {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
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
        oldMouseX = me.getX();
        oldMouseY = me.getY();
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
        float thetaX = 360.0f * ((float) (x - oldMouseX) / (float) size.width);
        float thetaY = 360.0f * ((float) (oldMouseY - y) / (float) size.height);
        oldMouseX = x;
        oldMouseY = y;
        view_rotx += thetaX;
        view_roty += thetaY;
        //System.out.println(view_rotx+" "+view_roty);
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
    public void keyPressed(KeyEvent ke)
    {
        if (ke.getKeyCode() < 250 && keys[ke.getKeyCode()] == false)
        {
            keys['E'] = false;
            keys['J'] = false;
            keys['T'] = false;
            keys['A'] = false;
            keys['L'] = false;
            keys['H'] = false;
            keys['Z'] = false;
            keys['X'] = false;
            keys['C'] = false;
            keys['V'] = false;
            keys['P'] = false;
            keys[ke.getKeyCode()] = true;
            System.out.println("Key pressed " + ke.getKeyChar());
            switch (ke.getKeyCode())
            {
                case 'P':
                {
                    JOptionPane.showMessageDialog(null, instructions);

                }
                break;

            }
        } else
        {
            keys[ke.getKeyCode()] = false;
        }
        switch (ke.getKeyCode())
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
        }
    }

    @Override
    public void keyReleased(KeyEvent ke)
    {
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

    public boolean colisionCaja(Cube r1, Cube r2)
    {
        return r1.getX() <= r2.getX() + r2.getAncho()
                && r1.getX() + r1.getAncho() >= r2.getX()
                && r1.getY() <= r2.getY() + r2.getAlto()
                && r1.getY() + r1.getAlto() >= r2.getY()
                && r1.getZ() <= r2.getZ() + r2.getDeep()
                && r1.getZ() + r1.getDeep() >= r2.getZ();
    }

    public Texture asigTex(String s) throws IOException
    {
        Texture textura;
        File t1 = new File(s);
        textura = TextureIO.newTexture(t1, true);
        return textura;
    }

    public void drawTex(personajes.Robot r, Texture[] te, GL gl)
    {
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -5f);
        gl.glScalef(1f, 1f, 0.5f);
        r.fondo(gl, glu, te[0]);
        gl.glPopMatrix();

//        gl.glPushMatrix();
//        gl.glScalef(1f, 1f, 0.5f);
//        gl.glRotatef(180, 0f, 1f, 0f);
//        gl.glTranslatef(0f, 0f, -2f);
//        pollo.fondo(te[1]);
//        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -2f);
        gl.glScalef(1f, 1f, 1f);
        gl.glRotatef(90, 0, 1, 0);
        r.fondo(gl, glu, te[2]);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -2f);
        gl.glRotatef(-90, 0, 1, 0);
        r.fondo(gl, glu, te[3]);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -2f);
        gl.glRotatef(90, 1, 0, 0);
        r.fondo(gl, glu, te[4]);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0f, -2f);
        gl.glRotatef(-90, 1, 0, 0);
        r.fondo(gl, glu, te[5]);
        gl.glPopMatrix();

        gl.glFlush();
    }

    public void textura1() throws IOException
    {
        tex1[0] = asigTex("src/backGround/onePlusTwo/atras.jpg");
        tex1[1] = asigTex("src/backGround/onePlusTwo/frente.jpg");
        tex1[2] = asigTex("src/backGround/onePlusTwo/izquierda.jpg");
        tex1[3] = asigTex("src/backGround/onePlusTwo/derecha.jpg");
        tex1[4] = asigTex("src/backGround/onePlusTwo/cielo.jpg");
        tex1[5] = asigTex("src/backGround/onePlusTwo/suelo.png");
    }

    public void fondo(Texture t)
    {
        int text = t.getTextureObject();
        gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glBindTexture(GL.GL_TEXTURE_2D, text);
        gl.glBegin(GL.GL_QUADS);

        gl.glTexCoord2f(0, 1);
        gl.glVertex3f(-6f, -6f, -6f);

        gl.glTexCoord2f(1, 1);
        gl.glVertex3f(6f, -6f, -6f);

        gl.glTexCoord2f(1, 0);
        gl.glVertex3f(6f, 6f, -6f);

        gl.glTexCoord2f(0, 0);
        gl.glVertex3f(-6f, 6f, -6f);

        gl.glEnd();
        gl.glDisable(GL.GL_TEXTURE_2D);
        gl.glFlush();

    }

    public static void main(String[] args)
    {
        new KittyLevel(1).setVisible(true);
    }
}
