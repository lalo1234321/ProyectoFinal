package personajes;

import com.sun.opengl.util.texture.Texture;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author TANIA
 */
public class DrawMonst
{

    //precision and global variables
    private static final int SLICES = 40;
    private static final int STACKS = 40;
    private GLUquadric q = null;
    private static int mvt = 0, movaux=0;
    private float mov=0f;
    private boolean moviendoa=true, moviendob=true;

    //heigth and widht of each components
    private static final float HEIGHT_BODY = 1.0f;
    private static final float TOP_BODY = 0.6f;
    private static final float BOTTOM_BODY = 0.75f;
    private static final float HEIGHT_LEGS = 0.2f;
    private static final float WIDTH_LEGS = 0.25f;
    private static final float HEIGHT_ARMS = 0.6f;
    private static final float WIDTH_ARMS = 0.11f;
    private static final float WIDTH_HEAD = 0.61f;
    private static final float WIDTH_EYES = 0.065f;
    private static final float WIDTH_HANDS = 0.1f;
    private static final float WIDTH_OPEN_MOUTH = 0.065f;

    //position of each component int the window
    public DrawMonst()
    {
    }
    

    public void draw_monst(GL gl)
    {

        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        gl.glRotatef(90, 20f, 15f, 15f);

//        gl.glScalef(2f, 2f, 2f);

        gl.glTranslated(0, 0, 3);
        //gl.glScalef(2f, 2f, 2f);

        draw_right_leg(gl, glu);
        draw_left_leg(gl, glu);
        draw_arm_left(gl, glu);
        draw_arm_right(gl, glu);
        draw_head(gl, glu);
        eyes(gl, glu);
        draw_mouth(gl, glu);
        draw_body(gl, glu);

    }
    

    public void saludar(GL gl)//expresion
    {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        gl.glRotatef(90, 20f, 15f, 15f);
//        gl.glScalef(2f, 2f, 2f);
        if (mvt % 20 + 10 > 20)
        {
            draw_right_leg(gl, glu);
            draw_left_leg(gl, glu);
            arm_hi_left1(gl, glu);
            draw_arm_right(gl, glu);
            draw_head(gl, glu);
            happy_eyes(gl, glu);
            smile_mouth(gl, glu);
            draw_body(gl, glu);
        } else
        {
            draw_right_leg(gl, glu);
            draw_left_leg(gl, glu);
            arm_hi_left(gl, glu);
            draw_arm_right(gl, glu);
            draw_head(gl, glu);
            happy_eyes(gl, glu);
            smile_mouth(gl, glu);
            draw_body(gl, glu);
        }
        mvt++;
    }

    public void brincar(GL gl)//movimiento
    {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        
        if (mvt % 20 + 10 > 20)
        {
            draw_monst(gl);
        } else
        {
//            gl.glScalef(2f, 2f, 2f);
            gl.glRotatef(90, 20f, 15f, 15f);
            gl.glTranslatef(0f, 1f, 0f);
            draw_right_leg(gl, glu);
            draw_left_leg(gl, glu);
            //draw_arm_left(gl,glu);
            arm_hi_left1(gl, glu);
            arm_hi_right1(gl, glu);
            //draw_arm_right(gl, glu);
            draw_head(gl, glu);
            eyes(gl, glu);
            draw_mouth(gl, glu);
            draw_body(gl, glu);
        }
        mvt++;
    }

    public void boo(GL gl)//expresion movimiento
    {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        if (mvt % 20 + 10 > 20)
        {
            draw_monst(gl);
        } else
        {
//            gl.glScalef(2f, 2f, 2f);
            gl.glRotatef(90, 20f, 15f, 15f);
            gl.glTranslatef(0f, 0f, 2f);//boo
            draw_right_leg(gl, glu);
            draw_left_leg(gl, glu);
            draw_arm_left(gl, glu);
            draw_arm_right(gl, glu);
            draw_head(gl, glu);
            eyes(gl, glu);
            draw_o_mouth(gl, glu);
            draw_body(gl, glu);

        }
        mvt++;
    }

    public void caminar(GL gl)
    {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        gl.glRotatef(90, 20f, 15f, 15f);
//        gl.glScalef(2f, 2f, 2f);
        if (mvt % 20 + 10 > 20)
        {
            draw_right_leg1(gl, glu);
            draw_left_leg(gl, glu);
            draw_arm_left(gl, glu);
            draw_arm_right(gl, glu);
            draw_head(gl, glu);
            surp_eyes(gl, glu);
            draw_lado_mouth(gl, glu);
            draw_body(gl, glu);

        } else
        {
            draw_right_leg(gl, glu);
            draw_left_leg1(gl, glu);
            draw_arm_left(gl, glu);
            draw_arm_right(gl, glu);
            draw_head(gl, glu);
            surp_eyes(gl, glu);
            draw_lado_mouth(gl, glu);
            draw_body(gl, glu);

        }
        mvt++;

    }

    public void guinar(GL gl)
    {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        gl.glRotatef(90, 20f, 15f, 15f);
//        gl.glScalef(2f, 2f, 2f);
        if (mvt % 20 + 10 > 20)
        {
            draw_right_leg(gl, glu);
            draw_left_leg(gl, glu);
            draw_arm_left(gl, glu);
            draw_arm_right(gl, glu);
            draw_head(gl, glu);
            guino(gl, glu);
            draw_mouth(gl, glu);
            draw_body(gl, glu);

        } else
        {
            draw_right_leg(gl, glu);
            draw_left_leg(gl, glu);
            draw_arm_left(gl, glu);
            draw_arm_right(gl, glu);
            draw_head(gl, glu);
            eyes(gl, glu);
            draw_mouth(gl, glu);
            draw_body(gl, glu);

        }
        mvt++;

    }

    public void triste(GL gl)
    {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        gl.glRotatef(90, 20f, 15f, 15f);
//        gl.glScalef(2f, 2f, 2f);
        if (mvt % 20 + 10 > 20)
        {
            draw_right_leg(gl, glu);
            draw_left_leg(gl, glu);
            draw_arm_left(gl, glu);
            draw_arm_right(gl, glu);
            draw_head(gl, glu);
            sad_eyes(gl, glu);
            sad_mouth(gl, glu);
            draw_body(gl, glu);

        } else
        {
            draw_right_leg(gl, glu);
            draw_left_leg(gl, glu);
            draw_arm_left(gl, glu);
            draw_arm_right(gl, glu);
            draw_head(gl, glu);
            eyes(gl, glu);
            sad_mouth(gl, glu);
            draw_body(gl, glu);

        }
        mvt++;

    }

    public void aplaude(GL gl)
    {
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        gl.glRotatef(90, 20f, 15f, 15f);
//        gl.glScalef(2f, 2f, 2f);
        if (mvt % 20 + 10 > 20)
        {
            draw_right_leg(gl, glu);
            draw_left_leg(gl, glu);
            arm_left_ap1(gl, glu);
            arm_right_ap1(gl, glu);
            draw_head(gl, glu);
            eyes(gl, glu);
            draw_mouth(gl, glu);
            draw_body(gl, glu);

        } else
        {
            draw_right_leg(gl, glu);
            draw_left_leg(gl, glu);
            arm_left_ap2(gl, glu);
            arm_right_ap2(gl, glu);
            draw_head(gl, glu);
            eyes(gl, glu);
            draw_mouth(gl, glu);
            draw_body(gl, glu);

        }
        mvt++;

    }
    public void rebota(GL gl){
        GLU glu = new GLU();
        q = glu.gluNewQuadric();
//        gl.glScalef(2f, 2f, 2f);

          if (mvt % 50 + 10 > 20)
        {
            gl.glTranslatef(movaux, 1, 1f);
            pelota(gl,glu);
            if(movaux<=3)
            movaux+=1;

        } else
        {
            gl.glTranslatef(movaux, -1, 1f);
            pelota(gl,glu);
            if(movaux>=-4)
            movaux-=1;
        }
        mvt++;
        
        
          
//        if (moviendoa)
//        {
//
//            mov-=0.5;
//            gl.glTranslatef(0, mov, 1f);
//            pelota(gl,glu);
//            movaux+=0.2;
//
//            if(movaux>-4){
////            move_ball(gl);
//            moviendoa=false;
//            }
//        } 
//        else
//        {
//            mov+=0.5;
//            gl.glTranslatef(0, mov, 1f);
//            pelota(gl,glu);
//            movaux-=0.2;
//            if(mov<=1){
//            moviendoa=true;
//            }
//            
//        }
        
    }
    
    public void draw_body(GL gl, GLU glu)
    {

        //we create stan body
        gl.glShadeModel(GL.GL_TEXTURE_SHADER_NV);
        gl.glPushMatrix();
        set_pink_material(gl);
        gl.glTranslatef(0f, 0.6f, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, TOP_BODY, BOTTOM_BODY, HEIGHT_BODY, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0.0f, -HEIGHT_BODY, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);
        gl.glPopMatrix();

    }

    public void draw_head(GL gl, GLU glu)
    {

        //we create head
        set_pink_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.5f, 0f);
        glu.gluSphere(q, WIDTH_HEAD, SLICES, STACKS);
        gl.glPopMatrix();

        //we draw horns
        gl.glPushMatrix();
        set_horns_material(gl);
        gl.glTranslatef(0.48f, 1.11f, 0.10f);
        gl.glRotatef(90f, 15.0f, -9.50f, 0.0f);
        glu.gluCylinder(q, 0.0f, 0.1f, 0.2f, SLICES, STACKS);
        gl.glPopMatrix();

        gl.glPushMatrix();
        set_horns_material(gl);
        gl.glTranslatef(-0.48f, 1.11f, 0.10f);
        gl.glRotatef(90f, 15.0f, 9.50f, 0.0f);
        glu.gluCylinder(q, 0.0f, 0.1f, 0.2f, SLICES, STACKS);
        gl.glPopMatrix();

    }

    public void eyes(GL gl, GLU glu)
    {
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.3f, 0.5f, 0.6f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();

        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.3f, 0.5f, 0.6f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void guino(GL gl, GLU glu)
    {
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.3f, 0.5f, 0.55f);
        gl.glRotatef(45, 0.5f, 0.0f, 0.0f);
//         gl.glRotatef(80, 0f, 0.5f, 0.0f);//rootacion de ojo en y
        glu.gluDisk(q, 0, 0.06, SLICES, SLICES);
        gl.glPopMatrix();

        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.3f, 0.5f, 0.6f);
        glu.gluSphere(q, WIDTH_EYES, SLICES, STACKS);
        gl.glPopMatrix();

    }

    public void happy_eyes(GL gl, GLU glu)
    {
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.3f, 0.5f, 0.55f);
        gl.glRotatef(45, 0.5f, 0.0f, 0.0f);
//         gl.glRotatef(80, 0f, 0.5f, 0.0f);//rootacion de ojo en y
        glu.gluDisk(q, 0, 0.06, SLICES, SLICES);
        gl.glPopMatrix();

        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.3f, 0.5f, 0.55f);
        gl.glRotatef(45, 0.5f, 0.0f, 0.0f);
        glu.gluDisk(q, 0, 0.06, SLICES, SLICES);
        gl.glPopMatrix();
    }

    public void surp_eyes(GL gl, GLU glu)
    {
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.3f, 0.5f, 0.55f);
        gl.glRotatef(20, -0.5f, 0.6f, 0.0f);
        glu.gluDisk(q, 0.07, 0.03, SLICES, SLICES);
        gl.glPopMatrix();

        set_black_material(gl);//surprise
        gl.glPushMatrix();
        gl.glTranslatef(-0.3f, 0.5f, 0.55f);
        gl.glRotatef(-20, 0.5f, 0.6f, 0.0f);
        glu.gluDisk(q, 0.07, 0.03, SLICES, SLICES);
        gl.glPopMatrix();
    }

    public void sad_eyes(GL gl, GLU glu)
    {
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.3f, 0.5f, 0.55f);
        gl.glRotatef(45f, 1f, 0f, 0f);
        gl.glScalef(-0.2f, 0.03f, 0.1f);
        draw_torus(gl, .6f, .3f, 4, 2);
        gl.glPopMatrix();

        set_black_material(gl);//surprise
        gl.glPushMatrix();
        gl.glTranslatef(-0.3f, 0.5f, 0.55f);
        gl.glRotatef(45f, 1f, 0f, 0f);
        gl.glScalef(-0.2f, 0.03f, 0.1f);
        draw_torus(gl, .6f, .3f, 4, 2);
        gl.glPopMatrix();
    }

    public void draw_mouth(GL gl, GLU glu)
    {
        //we create mouth
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glTranslatef(0.1f, 0.35f, 0.6f);
        gl.glRotatef(45f, 1f, 0f, 0f);
        gl.glScalef(-0.2f, 0.03f, 0.1f);
        box(gl);

        gl.glPopMatrix();
    }

    public void draw_lado_mouth(GL gl, GLU glu)
    {

        set_black_material(gl);
//        gl.glTranslatef(0.0f, 0.35f, 0.63f);   
        gl.glTranslatef(0.1f, 0.35f, 0.6f);
        gl.glRotatef(70f, 1.5f, .7f, 0.0f);
        gl.glScalef(-0.2f, 0.04f, 0.07f);
        box(gl);
        gl.glPopMatrix();
    }

    public void smile_mouth(GL gl, GLU glu)
    {
        //we create mouth
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glTranslatef(0.0f, 0.35f, 0.63f);
//        gl.glTranslatef(0.1f, 0.35f, 0.8f);   
        gl.glRotatef(-35f, 1f, 0f, 0f);
        gl.glScalef(-0.2f, 0.08f, 0.1f);
//        box(gl);
        draw_torus(gl, .6f, .3f, 4, 2);
        gl.glPopMatrix();
    }

    public void sad_mouth(GL gl, GLU glu)
    {
        //we create mouth
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glTranslatef(0.0f, 0.2f, 0.64f);
//        gl.glTranslatef(0.1f, 0.35f, 0.8f);   
        gl.glRotatef(20f, 1f, 0f, 0f);
        gl.glScalef(-0.2f, 0.08f, 0.1f);
//        box(gl);
        draw_torus(gl, .6f, .3f, 4, 2);
        gl.glPopMatrix();
    }

    public void draw_o_mouth(GL gl, GLU glu)
    {
        //we create mouth
        gl.glPushMatrix();
        set_black_material(gl);
        gl.glTranslatef(0.0f, 0.35f, 0.6f);
        glu.gluSphere(q, WIDTH_OPEN_MOUTH, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void draw_right_leg(GL gl, GLU glu)
    {
        gl.glPushMatrix();
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.3f, -0.4f, 0f);
        //gl.glRotatef(60f, 1f, 0f, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0f, -HEIGHT_LEGS, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void draw_right_leg1(GL gl, GLU glu)
    {
        gl.glPushMatrix();
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.3f, -0.4f, 0f);
        gl.glRotatef(60f, 1f, 0f, 0f);
        //gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0f, -HEIGHT_LEGS, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void draw_left_leg(GL gl, GLU glu)
    {
        gl.glPushMatrix();
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.3f, -0.4f, 0f);
        gl.glRotatef(90f, 1f, 0.0f, 0f);
//        gl.glRotatef(60f, 1f, 0.0f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0f, -HEIGHT_LEGS, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void draw_left_leg1(GL gl, GLU glu)
    {
        gl.glPushMatrix();
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.3f, -0.4f, 0f);
        //gl.glRotatef(90f, 1f, 0.0f, 0f);
        gl.glRotatef(60f, 1f, 0.0f, 0f);
        glu.gluCylinder(q, WIDTH_LEGS, WIDTH_LEGS, HEIGHT_LEGS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0f, -HEIGHT_LEGS, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        glu.gluDisk(q, 0f, WIDTH_LEGS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void draw_arm_left(GL gl, GLU glu)
    {
        //we create left arm
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.6f, 0.25f, 0.3f);
        gl.glRotatef(60f, 1f, -0.20f, 0f);
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0.20f, 0f);
        gl.glTranslatef(-0.122f, -0.58f, 0f);
        gl.glRotatef(90f, 1f, -0.20f, 0f);
        glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void arm_hi_left(GL gl, GLU glu)
    {
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.6f, 0.25f, 0.3f);
        gl.glRotatef(-90f, 1f, 0.20f, 0f);
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0.20f, 0f);
        gl.glTranslatef(-0.122f, -0.58f, 0f);
        gl.glRotatef(90f, 1f, -0.20f, 0f);
        glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void arm_hi_left1(GL gl, GLU glu)
    {
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.6f, 0.25f, 0.3f);
        gl.glRotatef(-75f, 1f, 0.95f, 0f);
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0.20f, 0f);
        gl.glTranslatef(-0.122f, -0.58f, 0f);
        gl.glRotatef(90f, 1f, -0.20f, 0f);
        glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void arm_left_ap2(GL gl, GLU glu)
    {        //arm_left_ap1
        //we create left arm

        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f, 0.25f, 0.5f);
        gl.glRotatef(10f, 1f, -0.20f, 0f);
        gl.glRotatef(45, 0f, 0.9f, 0f);
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0.20f, 0f);
        gl.glTranslatef(-0.122f, -0.58f, 0f);
        gl.glRotatef(90f, 1f, -0.20f, 0f);
        glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void arm_left_ap1(GL gl, GLU glu)
    {        //
        //we create left arm
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(-0.6f, 0.25f, 0.4f);
        gl.glRotatef(10f, 1f, -0.20f, 0f);
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0.20f, 0f);
        gl.glTranslatef(-0.122f, -0.58f, 0f);
        gl.glRotatef(90f, 1f, -0.20f, 0f);
        glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void draw_arm_right(GL gl, GLU glu)
    {
        gl.glPopMatrix();
        //we create right arm
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.6f, 0.25f, 0.3f);
        gl.glRotatef(75f, 1f, 0.20f, 0f);
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, -0.20f, 0f);
        gl.glTranslatef(0.122f, -0.58f, 0f);
        gl.glRotatef(90f, 1f, 0.20f, 0f);
        glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void arm_right_ap2(GL gl, GLU glu)
    {
        gl.glPopMatrix();
        //we create right arm
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, 0.25f, 0.5f);
        gl.glRotatef(10f, 1f, 0.20f, 0f);
        gl.glRotatef(45, 0f, -0.9f, 0f);
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, -0.20f, 0f);
        gl.glTranslatef(0.122f, -0.58f, 0f);
        gl.glRotatef(90f, 1f, 0.20f, 0f);
        glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void arm_right_ap1(GL gl, GLU glu)
    {
        gl.glPopMatrix();
        //we create right arm
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.6f, 0.25f, 0.4f);
        gl.glRotatef(10f, 1f, 0.20f, 0f);
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, -0.20f, 0f);
        gl.glTranslatef(0.122f, -0.58f, 0f);
        gl.glRotatef(90f, 1f, 0.20f, 0f);
        glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    public void arm_hi_right1(GL gl, GLU glu)
    {
        gl.glPopMatrix();
        //we create right arm
        set_armleg_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.6f, 0.25f, 0.3f);
        gl.glRotatef(75f, -1f, 0.66f, 0f);
        glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
        glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
        gl.glRotatef(90f, -1f, -0.20f, 0f);
        gl.glTranslatef(0.122f, -0.58f, 0f);
        gl.glRotatef(90f, 1f, 0.20f, 0f);
        glu.gluDisk(q, 0f, WIDTH_ARMS, SLICES, STACKS);
        gl.glPopMatrix();
    }

    //********************************************************************************************************************************    
    public void draw_torus(GL gl, float R, float r, int N, int n)
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


    public void set_pink_material(GL gl)
    {
        float[] mat_ambient =
        {
            0.9f, 0.5f, 0.5f, 0.5f
        };
        float[] mat_diffuse =
        {
            0.6f, 0.4f, 0.4f, 1.0f
        };
        float[] mat_specular =
        {
            0.9f, 0.6f, 0.6f, 1.0f
        };
        float shine = 125.2f;
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_horns_material(GL gl)
    {

        float[] mat_ambient =
        {
            0.5f, 0.5f, 0.5f, 0.2f
        };
        float[] mat_diffuse =
        {
            0.4f, 0.4f, 0.4f, 1.0f
        };
        float[] mat_specular =
        {
            0.7f, 0.6f, 0.6f, 1.0f
        };
        float shine = 15.0f;
        gl.glShadeModel(GL.GL_PHONG_WIN);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }

    public void set_black_material(GL gl)
    {

        float mat_ambient[] =
        {
            0.0f, 0.0f, 0.0f, 1.0f
        };
        float mat_diffuse[] =
        {
            0.0f, 0.0f, 0.0f, 1.0f
        };
        float mat_specular[] =
        {
            0.0f, 0.0f, 0.0f, 1.0f
        };
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

    }


    public void set_armleg_material(GL gl)
    {

        float[] mat_ambient =
        {
            0.2f, 0.5f, 0.5f, 0.2f
        };
        float[] mat_diffuse =
        {
            0.6f, 0.4f, 0.4f, 1.0f
        };
        float[] mat_specular =
        {
            0.9f, 0.6f, 0.6f, 1.0f
        };
        float shine = 125.2f;

        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT, mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_DIFFUSE, mat_diffuse, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, mat_specular, 0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shine);

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

    public void box_eye(GL gl)
    {
        gl.glBegin(GL.GL_POLYGON);/* f1: front */
        gl.glNormal3f(-.5f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, .5f);
        gl.glVertex3f(.5f, 0.0f, .5f);
        gl.glVertex3f(0.5f, 0.0f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f2: bottom */
        gl.glNormal3f(0.0f, 0.0f, -.5f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(.5f, 0.0f, 0.0f);
        gl.glVertex3f(.5f, .5f, 0.0f);
        gl.glVertex3f(0.0f, .5f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f3:back */
        gl.glNormal3f(.5f, 0.0f, 0.0f);
        gl.glVertex3f(.5f, .5f, 0.0f);
        gl.glVertex3f(.5f, .5f, .5f);
        gl.glVertex3f(0.0f, .5f, .5f);
        gl.glVertex3f(0.0f, .5f, 0.0f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f4: top */
        gl.glNormal3f(0.0f, 0.0f, .5f);
        gl.glVertex3f(.5f, .5f, .5f);
        gl.glVertex3f(.5f, 0.0f, .5f);
        gl.glVertex3f(0.0f, 0.0f, .5f);
        gl.glVertex3f(0.0f, .5f, .5f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f5: left */
        gl.glNormal3f(0.0f, .5f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, .5f, 0.0f);
        gl.glVertex3f(0.0f, .5f, .5f);
        gl.glVertex3f(0.0f, 0.0f, .5f);
        gl.glEnd();
        gl.glBegin(GL.GL_POLYGON);/* f6: right */
        gl.glNormal3f(0.0f, -.5f, 0.0f);
        gl.glVertex3f(.5f, 0.0f, 0.0f);
        gl.glVertex3f(.5f, 0.0f, .5f);
        gl.glVertex3f(.5f, .5f, .5f);
        gl.glVertex3f(.5f, .5f, 0.0f);
        gl.glEnd();
    }

    public void box(GL gl)
    {
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

    }
    public void pelota(GL gl, GLU glu){
        gl.glPushMatrix();
        set_blue_material(gl);
//        gl.glTranslatef(0, 0, 1f);
        glu.gluSphere(q, 0.2f, SLICES, STACKS);
        gl.glPopMatrix();
    }
    
//    public void move_ball(GL gl){
//        if(mov<=4f&& moviendoa) {
//            mov+=.11f;
//        }
//        if(mov>=4f&&moviendob) {
//            mov-=.11f;
//            
//        }
//        
//    }

}
