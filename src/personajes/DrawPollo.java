package personajes;

import com.sun.opengl.util.texture.Texture;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author abraham
 */
public class DrawPollo
{

    private GLUquadric quad;
    private GL gl;
    private GLU glu;
    private int[] ban;
    private int con;

    public DrawPollo()
    {
    }

    public DrawPollo(GL gl, GLU glu, int[] ban, int con)
    {
        this.gl = gl;
        this.glu = glu;
        this.quad = glu.gluNewQuadric();
        this.ban = ban;
        this.con = con;
    }

    public void DrawBird()
    {
        drawCuerpo();
        drawCola();
        drawWings();
        drawPatas();
        drawfingers();

        gl.glPushMatrix();
        if (ban[6] != 0 && con <= 10)
        {
            gl.glRotatef(-20, 0, 0, 1);
        } else if (ban[6] != 0 && con <= 30 && con > 20)
        {
            gl.glRotatef(20, 0, 0, 1);
        }
        drawPico();
        drawCabeza();

        if (ban[9] != 0)
        {
            ojoV();
        } else
        {
            if (ban[3] != 0)
            {
                drawEyes();
                pupilas();
            } else if (ban[4] != 0)
            {
                drawEyes();
                pupilas2();
            } else if (ban[5] != 0)
            {
                drawEyes();
                pupilas3();
            } else if (ban[10] != 0)
            {
                gl.glPushMatrix();
                if (con <= 10)
                {
                    gl.glRotatef(20, 0, 0, 1);
                } else if (con <= 30 && con > 20)
                {
                    gl.glRotatef(20, 0, 0, 1);
                }
                drawEyes();
                pupilas2();
                gl.glPopMatrix();
            }
        }

        sombrero();
        gl.glPopMatrix();
    }

    public void drawCuerpo()
    {
        yellowMat();
        if (ban[13] != 0)
        {
            //gl.glEnable(GL.GL_NORMALIZE);
            //yellowGo();
        }
        //cuerpo
        gl.glPushMatrix();
        gl.glTranslatef(0f, 0.0f, 0.0f);
        gl.glScalef(0.75f, 0.5f, 0.5f);
        esfera();
        gl.glPopMatrix();
    }

    public void drawCola()
    {
        yellowMat();
        //cola
        gl.glPushMatrix();
        gl.glTranslatef(0.75f, 0.45f, 0);
        gl.glScalef(0.2f, 0.2f, 0.2f);
        esfera();
        gl.glPopMatrix();
    }

    public void drawCabeza()
    {
        yellowMat();
        //cabeza
        gl.glPushMatrix();
        gl.glTranslatef(-0.1f, 0.8f, 0f);
        gl.glScalef(0.5f, 0.35f, 0.35f);
        esfera();
        gl.glPopMatrix();
        gl.glFlush();
    }

    public void drawWings()
    {
        yellowMat();
        //ala frente
        gl.glPushMatrix();
        if (ban[0] != 0 && con < 20)
        {
            gl.glTranslatef(0, 0.1f, 0);
            gl.glRotatef(45, 1, 0, 0);
        }
        gl.glPushMatrix();
        gl.glTranslatef(0, 0, 0.2f);
        gl.glRotatef(-45, 1, 0, 0);
        gl.glTranslatef(-0.2f, 0f, 0f);
        gl.glScalef(0.9f, 0.08f, 0.75f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0f, 0.5f, 0.7f);
        gl.glRotatef(-45, 1, 0, 0);
        gl.glScalef(0.6f, 0.08f, 0.2f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0.2f, 0.6f, 0.8f);
        gl.glRotatef(-45, 1, 0, 0);
        gl.glScalef(0.2f, 0.08f, 0.1f);
        cubo();
        gl.glPopMatrix();
        gl.glPopMatrix();

        //ala atras
        gl.glPushMatrix();
        if (ban[0] != 0 && con < 20)
        {
            gl.glRotatef(-45, 1, 0, 0);
        }
        gl.glPushMatrix();
        gl.glScalef(1, 1, -1);
        gl.glRotatef(-45, 1, 0, 0);
        gl.glTranslatef(-0.2f, 0f, 0f);
        gl.glScalef(0.9f, 0.08f, 0.75f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0, 0, 0.2f);
        gl.glScalef(1, 1, -1);
        gl.glTranslatef(0f, 0.5f, 0.7f);
        gl.glRotatef(-45, 1, 0, 0);
        gl.glScalef(0.6f, 0.08f, 0.2f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0.2f, -0.07f, 0.05f);
        gl.glScalef(1, 1, -1);
        gl.glTranslatef(0f, 0.7f, 0.7f);
        gl.glRotatef(-45, 1, 0, 0);
        gl.glScalef(0.2f, 0.08f, 0.1f);
        cubo();
        gl.glPopMatrix();
        gl.glPopMatrix();

        gl.glFlush();
    }

    public void drawfingers()
    {
        orangeMat();
        //Planta pie frente
        gl.glPushMatrix();
        if (ban[1] != 0 && con <= 10)
        {
            gl.glRotatef(20, 0, 0, 1);
        } else if (ban[1] != 0 && con <= 30 && con >= 20)
        {
            gl.glRotatef(-20, 0, 0, 1);
        }
        gl.glPushMatrix();
        gl.glTranslatef(-0.07f, -0.5f, 0.15f);
        gl.glScalef(0.2f, 0.05f, 0.2f);
        cubo();
        gl.glPopMatrix();

        blackMat(20);

        //Dedos frente
        gl.glPushMatrix();
        gl.glTranslatef(-0.13f, -0.5f, 0.17f);
        gl.glScalef(0.08f, 0.05f, 0.03f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-0.13f, -0.5f, 0.24f);
        gl.glScalef(0.08f, 0.05f, 0.03f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-0.13f, -0.5f, 0.3f);
        gl.glScalef(0.08f, 0.05f, 0.03f);
        cubo();
        gl.glPopMatrix();
        gl.glPopMatrix();

        orangeMat();
        //Planta pie atras
        gl.glPushMatrix();
        if (ban[1] == 1 && con <= 10)
        {
            gl.glRotatef(-20, 0, 0, 1);
        } else if (ban[1] != 0 && con <= 30 && con >= 20)
        {
            gl.glRotatef(20, 0, 0, 1);
        }
        gl.glPushMatrix();
        gl.glTranslatef(-0.07f, -0.5f, -0.15f);
        gl.glScalef(0.2f, 0.05f, 0.2f);
        cubo();
        gl.glPopMatrix();

        blackMat(20);
        //Dedos atras
        gl.glPushMatrix();
        gl.glTranslatef(-0.13f, -0.5f, -0.13f);
        gl.glScalef(0.08f, 0.05f, 0.03f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-0.13f, -0.5f, -0.06f);
        gl.glScalef(0.08f, 0.05f, 0.03f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-0.13f, -0.5f, 0.01f);
        gl.glScalef(0.08f, 0.05f, 0.03f);
        cubo();
        gl.glPopMatrix();
        gl.glPopMatrix();

        gl.glFlush();
    }

    public void drawPatas()
    {
        orangeMat();
        //pata fondo
        gl.glPushMatrix();
        if (ban[1] != 0 && con <= 10)
        {
            gl.glRotatef(-20, 0, 0, 1);
        } else if (ban[1] != 0 && con <= 30 && con > 20)
        {
            gl.glRotatef(20, 0, 0, 1);
        }
        gl.glPushMatrix();
        gl.glTranslatef(0, -0.5f, -0.1f);
        gl.glScalef(0.1f, 0.3f, 0.1f);
        cubo();
        gl.glPopMatrix();
        gl.glPopMatrix();

        //pata frente
        gl.glPushMatrix();
        if (ban[1] != 0 && con <= 10)
        {
            gl.glRotatef(20, 0, 0, 1);
        } else if (ban[1] != 0 && con <= 30 && con > 20)
        {
            gl.glRotatef(-20, 0, 0, 1);
        }
        gl.glPushMatrix();
        gl.glTranslatef(0, -0.5f, 0.2f);
        gl.glScalef(0.1f, 0.3f, 0.1f);
        cubo();
        gl.glPopMatrix();
        gl.glPopMatrix();
    }

    public void drawEyes()
    {
        whiteMat();
        //ojo frente
        gl.glPushMatrix();
        gl.glTranslatef(-0.47f, 1f, 0.15f);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(0.05f, 0.05f, 0.05f);
        esfera();
        gl.glPopMatrix();
        //ojo atras
        gl.glPushMatrix();
        gl.glTranslatef(-0.47f, 1f, -0.05f);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(0.05f, 0.05f, 0.05f);
        esfera();
        gl.glPopMatrix();

        gl.glFlush();
    }

    public void pupilas()
    {
        //pupila frente
        blackMat(0);
        gl.glPushMatrix();
        gl.glTranslatef(-0.51f, 1f, 0.15f);
        gl.glScalef(0.023f, 0.023f, 0.023f);
        cubo();
        gl.glPopMatrix();

        //pupila atras
        gl.glPushMatrix();
        gl.glTranslatef(-0.51f, 1f, -0.05f);
        gl.glScalef(0.023f, 0.023f, 0.023f);
        cubo();
        gl.glPopMatrix();
        gl.glFlush();
    }

    public void pupilas2()
    {
        //pupila frente
        //ojos saltones
        blackMat(0);
        gl.glPushMatrix();
        gl.glTranslatef(-0.51f, 1f, 0.13f);
        gl.glScalef(0.05f, 0.08f, 0.05f);
        cubo();
        gl.glPopMatrix();

        //pupila atras
        gl.glPushMatrix();
        gl.glTranslatef(-0.51f, 1f, -0.07f);
        gl.glScalef(0.05f, 0.08f, 0.05f);
        cubo();
        gl.glPopMatrix();
        gl.glFlush();
    }

    public void pupilas3()
    {
        //pupila frente
        blackMat(0);
        gl.glPushMatrix();
        gl.glTranslatef(-0.51f, 1.03f, 0.12f);
        gl.glRotatef(45, 1, 0, 0);
        gl.glScalef(0.023f, 0.02f, 0.07f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-0.51f, 0.98f, 0.13f);
        gl.glRotatef(-45, 1, 0, 0);
        gl.glScalef(0.023f, 0.02f, 0.07f);
        cubo();
        gl.glPopMatrix();

        //pupila atras  
        gl.glPushMatrix();
        gl.glTranslatef(-0.51f, 1.03f, -0.072f);
        gl.glRotatef(45, 1, 0, 0);
        gl.glScalef(0.023f, 0.02f, 0.07f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-0.51f, 0.98f, -0.072f);
        gl.glRotatef(-45, 1, 0, 0);
        gl.glScalef(0.023f, 0.02f, 0.07f);
        cubo();
        gl.glPopMatrix();

        gl.glFlush();
    }

    public void drawPico()
    {
        orangeMat();
        //pico bajo
        gl.glPushMatrix();
        if (ban[2] != 0 && con < 20)
        {
            gl.glTranslatef(0, 0.5f, 0);
            gl.glRotatef(15, 0, 0, 1);
            gl.glScaled(1, 0.5f, 1);
        }
        gl.glPushMatrix();
        gl.glTranslatef(-0.4f, 0.9f, 0.05f);
        gl.glScalef(0.35f, 0.1f, 0.1f);
        gl.glRotatef(-90, 0, 1, 0);
        cono();
        gl.glPopMatrix();
        gl.glPopMatrix();
        //pico arriba
        gl.glPushMatrix();
        gl.glTranslatef(-0.4f, 0.9f, 0.05f);
        gl.glScalef(0.35f, 0.1f, 0.1f);
        gl.glRotatef(-90, 0, 1, 0);
        cono();
        gl.glPopMatrix();
        gl.glFlush();

    }

    public void sombrero()
    {
        blackMat(15);
        //copa
        gl.glPushMatrix();
        gl.glTranslatef(0f, 1.5f, 0.05f);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(0.3f, 0.3f, 0.3f);
        glu.gluCylinder(quad, 1, 1, 1, 30, 30);
        gl.glPopMatrix();

        //aro
        gl.glPushMatrix();
        gl.glTranslatef(0f, 1.25f, 0.05f);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(0.3f, 0.3f, 0.2f);
        draw_torus(1, 0.3f, 30, 30);
        gl.glPopMatrix();

        //tapa
        gl.glPushMatrix();
        gl.glTranslatef(0f, 1.5f, 0.05f);
        gl.glRotatef(90, 1, 0, 0);
        gl.glScalef(0.3f, 0.3f, 0.3f);
        glu.gluDisk(quad, 1f, 0f, 30, 30);
        gl.glPopMatrix();

        gl.glPushMatrix();
        if (ban[7] != 0 && con <= 10)
        {
            gl.glRotatef(20, 0.1f, 1.5f, 0);
        } else if (ban[7] != 0 && con <= 30 && con > 20)
        {
            gl.glRotatef(-20, 0.1f, 1.5f, 0);
        }
        drawMon();
        gl.glPopMatrix();
        gl.glFlush();

    }

    public void drawMon()
    {
        redMat();
        gl.glPushMatrix();
        gl.glTranslatef(-0.3f, 1.35f, 0.05f);
        gl.glScalef(0.05f, 0.05f, 0.05f);
        esfera();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-0.3f, 1.35f, -0.01f);
        gl.glScalef(0.05f, 0.05f, 0.05f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-0.3f, 1.35f, 0.08f);
        gl.glScalef(0.05f, 0.05f, 0.05f);
        cubo();
        gl.glPopMatrix();
    }

    public void ojoV()
    {
        //Dibujar la V
        blackMat(0);
        gl.glPushMatrix();
        gl.glTranslatef(-0.51f, 1.03f, 0.08f);
        gl.glRotatef(45, 1, 0, 0);
        gl.glScalef(0.023f, 0.07f, 0.03f);
        cubo();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(-0.51f, 1f, 0.17f);
        gl.glRotatef(-45, 1, 0, 0);
        gl.glScalef(0.023f, 0.07f, 0.03f);
        cubo();
        gl.glPopMatrix();

        //pupila atras
        gl.glPushMatrix();
        gl.glTranslatef(-0.51f, 1f, -0.07f);
        gl.glScalef(0.05f, 0.08f, 0.05f);
        cubo();
        gl.glPopMatrix();

        whiteMat();
        //ojo atras
        gl.glPushMatrix();
        gl.glTranslatef(-0.47f, 1f, -0.05f);
        gl.glRotatef(90, 0, 1, 0);
        gl.glScalef(0.05f, 0.05f, 0.05f);
        esfera();
        gl.glPopMatrix();

        gl.glFlush();
    }

    public void esfera()
    {
        gl.glPushMatrix();
        gl.glTranslatef(0.2f, 0.4f, 0.2f);
        glu.gluSphere(quad, 1, 30, 30);
        gl.glPopMatrix();
    }

    public void cono()
    {
        gl.glPushMatrix();
        glu.gluCylinder(quad, 1, 0, 1, 30, 30);
        gl.glPopMatrix();
    }

    public void cubo()
    {
        gl.glPushMatrix();
        gl.glBegin(GL.GL_POLYGON);/* f1: front */
        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f2: bottom */
        gl.glNormal3f(0.0f, 0.0f, -1.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);/* f3:back */
        gl.glNormal3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);/* f4: top */
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f5: left */
        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f6: right */
        gl.glNormal3f(0.0f, -1.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glPopMatrix();
    }

    public void draw_torus(float R, float r, int N, int n)
    {

        int maxn = 1000;
        n = Math.min(n, maxn - 1);
        N = Math.min(N, maxn - 1);
        float rr = 1.5f * r;
        double dv = 2 * Math.PI / n;
        double dw = 2 * Math.PI / N;
        double v = 0.0f;
        double w = 0.0f;
        while (w < 2 * Math.PI + dw)
        {
            v = 0.0f;
            gl.glBegin(GL.GL_TRIANGLE_STRIP);
            while (v < 2 * Math.PI + dv)
            {
                gl.glNormal3d(
                        (R + rr * Math.cos(v)) * Math.cos(w) - (R + r * Math.cos(v)) * Math.cos(w),
                        (R + rr * Math.cos(v)) * Math.sin(w) - (R + r * Math.cos(v)) * Math.sin(w),
                        (rr * Math.sin(v) - r * Math.sin(v)));
                gl.glVertex3d((R + r * Math.cos(v)) * Math.cos(w),
                        (R + r * Math.cos(v)) * Math.sin(w),
                        r * Math.sin(v));
                gl.glNormal3d(
                        (R + rr * Math.cos(v + dv)) * Math.cos(w + dw) - (R + r * Math.cos(v + dv)) * Math.cos(w + dw),
                        (R + rr * Math.cos(v + dv)) * Math.sin(w + dw) - (R + r * Math.cos(v + dv)) * Math.sin(w + dw),
                        rr * Math.sin(v + dv) - r * Math.sin(v + dv));
                gl.glVertex3d((R + r * Math.cos(v + dv)) * Math.cos(w + dw),
                        (R + r * Math.cos(v + dv)) * Math.sin(w + dw),
                        r * Math.sin(v + dv));
                v += dv;
            }
            gl.glEnd();
            w += dw;
        }
    }

    public void yellowMat()
    {
        float[] amb =
        {
            0.937f, 0.745f, 0f, 1f
        };
        float[] diff =
        {
            0.5f, 0.5f, 0.5f, 1f
        };
        float[] spec =
        {
            0.5f, 0.5f, 0.5f, 1f
        };
        float shine = 0;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void yellowGo()
    {
        gl.glColor3f(0.937f, 0.745f, 0f);
        gl.glColorMaterial(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT_AND_DIFFUSE);
    }

    public void orangeMat()
    {
        float[] amb =
        {
            0.859f, 0.298f, 0f, 1f
        };
        float[] diff =
        {
            0.1f, 0.1f, 0.1f, 1f
        };
        float[] spec =
        {
            0.1f, 0.1f, 0.1f, 1f
        };
        float shine = 0;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void blackMat(float shine)
    {
        float[] amb =
        {
            0.1f, 0.1f, 0.1f, 1f
        };
        float[] diff =
        {
            0f, 0f, 0f, 1f
        };
        float[] spec =
        {
            0f, 0f, 0f, 1f
        };
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
        gl.glFlush();
    }

    public void whiteMat()
    {
        float[] amb =
        {
            1f, 1f, 1f, 1f
        };
        float[] diff =
        {
            0.5f, 0.5f, 0.5f, 1f
        };
        float[] spec =
        {
            0.5f, 0.5f, 0.5f, 1f
        };
        float shine = 20;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
    }

    public void redMat()
    {
        float[] amb =
        {
            0.8f, 0.1f, 0.1f, 1f
        };
        float[] diff =
        {
            0f, 0f, 0f, 1f
        };
        float[] spec =
        {
            0f, 0f, 0f, 1f
        };
        float shine = 20;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, diff, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, spec, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);
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

}
