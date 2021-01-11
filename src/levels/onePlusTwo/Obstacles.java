/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels.onePlusTwo;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author abrah clase para dibujar los obstaculos
 *
 */
public class Obstacles
{

    GL gl;
    GLU glu;
    GLUquadric quad;

    //Constructor
    public Obstacles(GL gl, GLU glu)
    {
        this.gl = gl;
        this.glu = glu;
        this.quad = glu.gluNewQuadric();
    }

    //Dibujar todos los objetos
    public void drawObstacles()
    {
        redMat();
        gl.glPushMatrix();
        //System.out.println("hola123");
        gl.glTranslatef(-2, 0, -3);
        gl.glScalef(4f, 0.4f, 0.4f);
        gl.glPushMatrix();
        drawBox();
        gl.glPopMatrix();

//        gl.glPushMatrix();
//        gl.glTranslatef(2, 0, -3);
//        gl.glScalef(0.8f, 0.3f, 0.3f);
//        drawBox();
//        gl.glPopMatrix();
//
//        gl.glPushMatrix();
//        gl.glTranslatef(-2, 0, -5);
//        gl.glScalef(0.8f, 0.3f, 0.3f);
//        drawBox();
//        gl.glPopMatrix();
        gl.glPopMatrix();
    }

    //Dibujar una caja
    //float s1, float s2, float s3, float t1, float t2, float t3
    public void drawBox()
    {

        gl.glPushMatrix();
        gl.glBegin(GL.GL_QUADS);/* f1: front */
        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);/* f2: bottom */
        gl.glNormal3f(0.0f, 0.0f, -1.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);/* f3:back */
        gl.glNormal3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glEnd();

        gl.glBegin(GL.GL_QUADS);/* f4: top */
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_QUADS);/* f5: left */
        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(0.0f, 1.0f, 1.0f);
        gl.glVertex3f(0.0f, 0.0f, 1.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_QUADS);/* f6: right */
        gl.glNormal3f(0.0f, -1.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 0.0f);
        gl.glVertex3f(1.0f, 0.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glEnd();
        gl.glPopMatrix();
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
}
