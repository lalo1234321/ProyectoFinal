/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels.targetShottingLevel;

import com.sun.opengl.util.texture.Texture;
import java.util.Random;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import menu.Menu1;
import menu.MenuLevel;
import personajes.DrawPollo;

/**
 *
 * @author theowl
 */
public class DrawPollito extends DrawPollo{
    private static final int SLICES=40;
    private static final int STACKS=40;
    private static final float BOTTOM_BODY=0.40f;
    private GLUquadric q=null;
    private float moveAD=0,moveTarget=0f,moveTarget1=0f, moveTarget2=0f;
    public boolean movingForward, movingBack = false,fire = true,destroyed = false;
    public boolean movingForward1, movingBack1 = false, destroyed1 = false;
    public boolean movingForward2, movingBack2 = false, destroyed2 = false;
    private float k = 0;
    private JFrame frame;
    private Random generator;
    private  String [] tips  =new String[] {
    "During class, view the examples seriously, and copy them quickly in detail.",
    "Read the section before coming to class, it would help a lot. Ask lots of questions in class.\n" +
"",
    "Go to each and every class. If you don't understand something, try reading the book. Learn how to write good notes",
    "Do not depend on your instructor to teach you everything.\n" +
""
    }; 
    public DrawPollito(GL gl,GLU glu,int[] ban,int con,JFrame frame) {
        super(gl, glu, ban, 0);
        this.frame = frame;
        generator = new Random();
    }
    public void draw(GL gl,GLU glu,boolean left, boolean right,boolean fire) {
        q=glu.gluNewQuadric();
        if(left){
            moveAD+=.05f;
        }
        if(right) {
            moveAD -=.05f;
        }
        if(moveTarget>=3.5f) {
            movingBack = true;
            movingForward = false;
        }   

       if(moveTarget<=-3.5f) {
           movingForward = true;
           movingBack = false;

       }
       if(moveTarget1>3.5f) {
           movingBack1 = true;
           movingForward1 = false;
       }
       if(moveTarget1<-3.5f) {
           movingForward1 = true;
           movingBack1 = false;
       }

       if(moveTarget2>3.5f) {
           movingBack2 = true;
           movingForward2 = false;
       }
       if(moveTarget2<-3.5f) {
           movingForward2 = true;
           movingBack2 = false;
       }
        if(!fire) {
            k = 0;
        }
        if(fire&&this.fire) {
                shotLaser(gl);
                
        }
        if(!destroyed) {
            gl.glPushMatrix();
            gl.glRotated(65, 0, 1, 0);
            
            drawTarget(gl, glu);
            moveTarget(gl);
            gl.glPopMatrix();
        }
        if(!destroyed1) {
            gl.glPushMatrix();
            gl.glRotated(65, 0, 1, 0);
            drawTarget1(gl, glu);
            moveTarget1(gl);
            gl.glPopMatrix();
        }
        if(!destroyed2) {
            gl.glPushMatrix();
            gl.glRotated(65, 0, 1, 0);
            drawTarget2(gl, glu);
            moveTarget2(gl);
            gl.glPopMatrix();
        }
        if(destroyed&&destroyed1&&destroyed2)
                {
                    JOptionPane.showMessageDialog(null, "You have won a tip for calculus \n"+getRandomTip());
                    frame.setVisible(false);
                    Menu1 menu = new Menu1();
                    menu.setVisible(true);
                    MenuLevel.animator.stop();
                   
                }
        gl.glTranslatef(4, moveAD, 0);
        super.DrawBird();
    }
    
    
    public void drawTarget(GL gl, GLU glu) {
        if(Math.abs(k-2)<.565&&Math.abs(moveAD-moveTarget)<.565) {
            set_blue_material(gl);
            gl.glTranslatef(this.moveTarget,0f , 2f);
            glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);
            destroyed = true;
        }
        if(destroyed==false) {
            set_red_material(gl);
            gl.glTranslatef(0f,this.moveTarget , 2f);
            glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);        
        }
        
    }
    
    public void drawTarget1(GL gl, GLU glu) {
        if(Math.abs(k-3)<.565&&Math.abs(moveAD-moveTarget1)<.565) {
            set_red_material(gl);
            gl.glTranslatef(this.moveTarget1,0f , 3f);
            glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);
            destroyed1 = true;
        }
        if(destroyed1==false) {
            set_blue_material(gl);
            gl.glTranslatef(0f,this.moveTarget1 , 1f);
            glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);        
        }
    
    }
    
    public void drawTarget2(GL gl, GLU glu) {
        if(Math.abs(k-5)<.565&&Math.abs(moveAD-moveTarget2)<.565) {
            set_black_material(gl);
            gl.glTranslatef(this.moveTarget2,0f , 5f);
            glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);
            destroyed2 = true;
        }
        if(destroyed2==false) {
            set_black_material(gl);
            gl.glTranslatef(0f,this.moveTarget2 , 0f);
            glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);  
        
        }
    
    }
    
    public void moveTarget(GL gl) {
        if(this.moveTarget<=3.5f&&this.movingForward) {
            this.moveTarget+=.17f;
        }
        if(this.moveTarget>=-3.5f&&this.movingBack) {
            this.moveTarget-=.17f;
            
        }
    }
    
    public void moveTarget2(GL gl) {
         if(this.moveTarget2<=3.5f&&this.movingForward2) {
            this.moveTarget2+=.21f;
        }
        if(this.moveTarget2>=-3.5f&&this.movingBack2) {
            this.moveTarget2-=.21f;
            
        }
    
    
    }
    
    public void moveTarget1(GL gl) {
        if(this.moveTarget1<=3.5f&&this.movingForward1) {
            this.moveTarget1+=.13f;
        }
        if(this.moveTarget1>=-3.5f&&this.movingBack1) {
            this.moveTarget1-=.13f;
            
        }
    }
    
    public void shotLaser(GL gl) {
        this.fire  = true;
            set_red_material(gl);
            float bandY = moveAD;
        if(k<=1000000.5f||k == 0) {

            k+=.44f;
            gl.glPushMatrix();
            gl.glTranslated(3, 0, 0);
            gl.glTranslatef(-k, bandY, 0);
            gl.glScaled(.2, .2, .2);
            box(gl);
            gl.glPopMatrix();
        }
            if(k>=1000000.5f) {

                k = 0;

                //shoot = this.shoot;
                //System.out.println(shoot);
            }
    
    }
    public void set_blue_material (GL gl) {
    
  
        
        float mat_ambient[]={0.2f,0.2f,0.6f,1.0f};
        float mat_diffuse[]={1.0f,1.0f,1.0f,1.0f};
        float mat_specular[]={0.8f,0.8f,0.8f,1.0f};
        float shine=125.2f;    
                
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
    public void set_black_material (GL gl){
        float mat_ambient[]={0.0f,0.0f,0.0f,1.0f};
        float mat_diffuse[]={0.0f,0.0f,0.0f,1.0f};
        float mat_specular[]={0.0f,0.0f,0.0f,1.0f};

       
        float shine=125.2f;    
                
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
    
    public void set_red_material(GL gl) {
        float mat_ambient[]={1.0f,0.0f,0.0f,1.0f};
        float mat_diffuse[]={1.0f,0.0f,0.0f,1.0f};
        float mat_specular[]={1.0f,0.0f,0.0f,1.0f};
        float shine=51.2f;    
                
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
    }
    
    public void fondo(GL gl, GLU glu, Texture t) {
        int m = t.getTextureObject();
        gl.glEnable(GL.GL_TEXTURE_2D);
        gl.glBindTexture(GL.GL_TEXTURE_2D, m);
        gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
        gl.glBegin(GL.GL_QUADS);
        
        gl.glTexCoord2d(0.0f,1.0f);
        gl.glVertex3f(-6.0f, -6.0f,-6.0f );
        
        gl.glTexCoord2d(1.0f,1.0f);
        gl.glVertex3f(6.0f, -6.0f,-6.0f );
        
        gl.glTexCoord2d(0.0f,0.0f);
        gl.glVertex3f(6.0f, 6.0f,-6.0f );
        
        gl.glTexCoord2d(0.0f,0.0f);
        gl.glVertex3f(-6.0f, 6.0f,-6.0f );
        
        gl.glEnd();
        gl.glFlush();
        gl.glDisable(GL.GL_TEXTURE_2D);
    }
    
    public void box (GL gl){
        
        gl.glBegin(GL.GL_POLYGON);/* f1: front */
            gl.glNormal3f(-1.0f,0.0f,0.0f);
            gl.glVertex3f(0.0f,0.0f,0.0f);
            gl.glVertex3f(0.0f,0.0f,1.0f);
            gl.glVertex3f(1.0f,0.0f,1.0f);
            gl.glVertex3f(1.0f,0.0f,0.0f);
          gl.glEnd();
          
          gl.glBegin(GL.GL_POLYGON);/* f2: bottom */
            gl.glNormal3f(0.0f,0.0f,-1.0f);
            gl.glVertex3f(0.0f,0.0f,0.0f);
            gl.glVertex3f(1.0f,0.0f,0.0f);
            gl.glVertex3f(1.0f,1.0f,0.0f);
            gl.glVertex3f(0.0f,1.0f,0.0f);
          gl.glEnd();
          
          gl.glBegin(GL.GL_POLYGON);/* f3:back */
            gl.glNormal3f(1.0f,0.0f,0.0f);
            gl.glVertex3f(1.0f,1.0f,0.0f);
            gl.glVertex3f(1.0f,1.0f,1.0f);
            gl.glVertex3f(0.0f,1.0f,1.0f);
            gl.glVertex3f(0.0f,1.0f,0.0f);
          gl.glEnd();
         
          gl.glBegin(GL.GL_POLYGON);/* f4: top */
            gl.glNormal3f(0.0f,0.0f,1.0f);
            gl.glVertex3f(1.0f,1.0f,1.0f);
            gl.glVertex3f(1.0f,0.0f,1.0f);
            gl.glVertex3f(0.0f,0.0f,1.0f);
            gl.glVertex3f(0.0f,1.0f,1.0f);
          gl.glEnd();
         
          gl.glBegin(GL.GL_POLYGON);/* f5: left */
            gl.glNormal3f(0.0f,1.0f,0.0f);
            gl.glVertex3f(0.0f,0.0f,0.0f);
            gl.glVertex3f(0.0f,1.0f,0.0f);
            gl.glVertex3f(0.0f,1.0f,1.0f);
            gl.glVertex3f(0.0f,0.0f,1.0f);
          gl.glEnd();
         
          gl.glBegin(GL.GL_POLYGON);/* f6: right */
            gl.glNormal3f(0.0f,-1.0f,0.0f);
            gl.glVertex3f(1.0f,0.0f,0.0f);
            gl.glVertex3f(1.0f,0.0f,1.0f);
            gl.glVertex3f(1.0f,1.0f,1.0f);
            gl.glVertex3f(1.0f,1.0f,0.0f);
          gl.glEnd();
          
    }
    
    
    public String getRandomTip() {
        String tip;
        int randomIndex = generator.nextInt(tips.length);
        tip = tips[randomIndex];
        return tip;
    }
    
}
