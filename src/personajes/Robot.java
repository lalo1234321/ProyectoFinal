
package personajes;
//comentario
import com.sun.opengl.util.texture.Texture;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class Robot {
    private static final int SLICES=40;
    private static final int STACKS=40;
    private GLUquadric q=null;
    private static int mvt=0;
    private char aux = 'n';
    
    //heigth and widht of each components
    private static final float HEIGHT_BODY=0.5f;
    private static final float TOP_BODY=0.55f;
    private static final float BOTTOM_BODY=0.40f;
    private static final float HEIGHT_LEGS=0.2f;
    private static final float WIDTH_LEGS=0.185f;
    private static final float HEIGHT_ARMS=0.22f;
    private static final float WIDTH_ARMS=0.09f;
    private static final float WIDTH_HEAD=0.5f;
    private static final float WIDTH_EYES=0.3f;
    private static final float WIDTH_HANDS=0.1f;
    private static final float WIDTH_FINGERS=0.0525f;
    private static final float WIDTH_SHOES=0.28f;
    private static final float HEIGHT_SHOES=0.05f;
    private static final float WIDTH_OPEN_MOUTH=0.1f;
    private static final float WIDTH_BUTTONS=0.0525f;
    private static final float SPACE_BETWEEN_BUTTONS=0.12f;
    private static final float WIDTH_BOTTOM_BONNET=0.525f;
    private static final float HEIGHT_BOTTOM_BONNET=0.12f;
    private static final float WIDTH_BONNET=0.52f;
    private static final float WIDTH_PUPILS=0.03f;
    private static final float WIDTH_POMPON=0.12f;
    //variables for the traslation animtion
    private static  float xInicial = 0.05f;
    private static  float xFinal= 2f;
    private static  float distanceBetweenTwoPoints = xFinal - xInicial;
    private static  float currentX = xInicial;
    private static  final float factor = 0.03f;
    private static  float offset = distanceBetweenTwoPoints * factor;
    private static  boolean isForward = true;
    private static double angle1 = 25,angle2 = -25,limitAngle1=40,inicialAngle1 = 25;
    private static float xInicial1 = -1.6f;
    private static float xFinal1= 2.9f;
    private static float distanceBetweenTwoPoints1 = xFinal1 - xInicial1;
    private static float currentX1 = xInicial1;
    private static final float factor1 = 1.0f;
    private static float offset1 = distanceBetweenTwoPoints1 * factor1;
    private static boolean isForward1 = true;
    private static float xInicial2 = 0f;
    private static float xFinal2= 9.9f;
    private static float distanceBetweenTwoPoints2 = xFinal2 - xInicial2;
    private static float currentX2 = xInicial2;
    private static final float factor2 = .02f;
    private static float offset2 = distanceBetweenTwoPoints2 * factor2;
    private static boolean isForward2 = true;
    private static boolean translate1 = false;
    private static boolean translate = false;
    private static boolean earMoving = false;
    public Robot(){}
    
    public void drawRobot(GL gl, boolean jump,boolean translate, boolean ears, boolean body, boolean attack) {
        GLU glu = new GLU();
        q=glu.gluNewQuadric();
        glu.gluQuadricDrawStyle(q, GLU.GLU_FILL);
        glu.gluQuadricOrientation(q, GLU.GLU_OUTSIDE);
        glu.gluQuadricNormals(q, GLU.GLU_SMOOTH);
        //System.out.println(currentX);
//        System.out.println(jump);
        gl.glPushMatrix();
        if(attack==false) {
            currentX2 = xInicial2;
            isForward2 = true;
            Robot.translate1 = false;
        
        }
        if(ears==false) {
            drawLeftEar(gl, glu, ' ');
            currentX1 = xInicial1;
            isForward1 = true;
            Robot.earMoving = false;
        }
        if(translate==false){
            drawBowl(gl, glu);
            currentX = xInicial;
            isForward = true;
            Robot.translate = false;
        }
        if(translate){
            
            if(currentX < xFinal && isForward) {
            gl.glTranslatef( currentX, 0.0f, 0.0f);
            currentX = currentX + offset;
            drawBowl(gl, glu);
            }else {
            isForward = false;
            if(currentX > xInicial)
                gl.glTranslatef( currentX, 0.0f, 0.0f);
            else
                gl.glTranslatef( xInicial, 0.0f, 0.0f);
            currentX = currentX - offset;
            //regreso
                drawBowl(gl, glu);
            }
            Robot.translate = true;
        }
        gl.glPopMatrix();
        if(jump) {
            
            drawFaceCat(gl, glu,' ');
            drawLeftEar(gl, glu,' ');
            gl.glTranslated(1, 0, 0);
            drawRightEar(gl, glu,' ');
            gl.glTranslatef(-0.7f, 0f, 0f);
            drawLegs(gl, glu,'J');
            gl.glTranslatef(-0.6f, 0f, 0f);
            drawLegs(gl, glu,'J');
            gl.glPushMatrix();
            drawBody(gl, glu,'J');
            gl.glPopMatrix();    
        
        }
        if(ears) {
             
            
           
           
            
             System.out.println("He entrado");
            earMoving = true;
            if(currentX1 < xFinal1 && isForward1) {
            gl.glRotated(currentX1, 0, 0, 1);
            currentX1 = currentX1 + offset1;
            drawFaceCat(gl, glu,' ');
            drawLeftEar(gl, glu, aux);
            
            }else {
            isForward1 = false;
            if(currentX1 > xInicial1)
                gl.glRotated(currentX1, 0, 0, 1);
            else
                gl.glRotated(currentX1, 0, 0, 1);
            currentX1 = currentX1 - offset1;
            drawFaceCat(gl, glu,' ');
            drawLeftEar(gl, glu,'E');
            
            }
            gl.glTranslated(1, 0, 0);
            drawRightEar(gl, glu,'E');
            gl.glTranslatef(-0.7f, 0f, 0f);
            gl.glPushMatrix();
            drawLegs(gl, glu,' ');
            gl.glTranslatef(-0.6f, 0f, 0f);
            drawLegs(gl, glu,' ');
            gl.glPopMatrix();
            drawBody(gl, glu, ' ');
            
            
            
        
        }
        if(attack) {
            gl.glPushMatrix();
            drawFaceCat(gl, glu,'A');
            
            drawLeftEar(gl, glu,' ');
            gl.glTranslated(1, 0, 0);
            drawRightEar(gl, glu,' ');
            gl.glTranslatef(-0.7f, 0f, 0f);
            drawLegs(gl, glu,' ');
            gl.glTranslatef(-0.6f, 0f, 0f);
            drawLegs(gl, glu,' ');
            drawBody(gl, glu, ' ');
            gl.glScalef(.1f, .1f, .5f);
            gl.glTranslated(1.9, 3.5, 0);
            if(currentX2 < xFinal2 && isForward2) {
            gl.glTranslatef( 0, 0.0f, currentX2);
            currentX2 = currentX2 + offset2;
                drawLaser(gl);
            }else {
            isForward2 = false;
            if(currentX2 > xInicial2)
                gl.glTranslatef( 0, 0.0f, currentX2);
            else
                gl.glTranslatef( xInicial2, 0.0f, 0.0f);
            currentX2 = currentX2 - offset2;
            //regreso
                drawLaser(gl);
            }
            Robot.translate1 = true;
            drawLaser(gl);
            gl.glPopMatrix();    
        
        
        
        }
        if(body) {
            gl.glPushMatrix();
            drawFaceCat(gl, glu,'L');
            drawLeftEar(gl, glu,' ');
            gl.glTranslated(1, 0, 0);
            drawRightEar(gl, glu,' ');
            gl.glTranslatef(-0.7f, 0f, 0f);
            drawLegs(gl, glu,' ');
            gl.glTranslatef(-0.6f, 0f, 0f);
            drawLegs(gl, glu,' ');
            
            drawBody(gl, glu, 'L');
            gl.glPopMatrix();    
        
        }
        
        else {
            gl.glPushMatrix();
            drawFaceCat(gl, glu,' ');
            
            drawLeftEar(gl, glu,' ');
            gl.glTranslated(1, 0, 0);
            drawRightEar(gl, glu,' ');
            gl.glTranslatef(-0.7f, 0f, 0f);
            drawLegs(gl, glu,' ');
            gl.glTranslatef(-0.6f, 0f, 0f);
            drawLegs(gl, glu,' ');
            
            drawBody(gl, glu, ' ');
            gl.glPopMatrix();    
        }
        
    }
    public void drawBowl(GL gl, GLU glu) {
        gl.glPushMatrix();
        gl.glRotated(85, 1, 0, 0);
        set_blue_material(gl);
        glu.gluCylinder(q, TOP_BODY, BOTTOM_BODY, HEIGHT_BODY, SLICES, STACKS);
        gl.glRotatef(90f, -1f, 0f, 0f);
        gl.glTranslatef(0.0f, -HEIGHT_BODY, 0f);
        gl.glRotatef(90f, 1f, 0f, 0f);
        set_black_material(gl);
        glu.gluDisk(q, 0f, BOTTOM_BODY, SLICES, STACKS);
        gl.glTranslatef(-0.033f, .01f, -.35f);
//        gl.glRotatef(90f, 1f, 0f, 0f);
        set_white_material(gl);
        glu.gluDisk(q, 0f, .49f, SLICES, STACKS);
        gl.glPopMatrix();
        
    
    }
    public void drawFaceCat(GL gl, GLU glu,char c) {
        set_black_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.5f, -1.0f);
        glu.gluSphere(q, WIDTH_HEAD, 40, 40);
        gl.glPopMatrix();
        if(c=='A') {
            
            set_red_material(gl);
            
        }
        if(c=='L'||c==' '){
            
            set_eyes_material(gl);
            
            
        }    
        gl.glPushMatrix();
        gl.glTranslatef(-0.08f, 0.45f, -0.505f);
        if(c == 'L') {
            gl.glPushMatrix();
            gl.glScalef(.1f,.1f, .1f);
            gl.glTranslatef(0.4f, 0.5f, 0.0f); 
            box(gl);
            gl.glTranslatef(0.6f, 0.0f, 0.0f);   
            gl.glScalef(.1f,.1f, .1f);
            box(gl);
            gl.glPopMatrix();
        }
        
        if(translate) {
            gl.glPushMatrix();
            glu.gluSphere(q, .07f, SLICES, STACKS);
            gl.glTranslatef(0.16f, 0.0f, 0.0f);        
            glu.gluSphere(q, .07f, SLICES, STACKS);
            gl.glPopMatrix();
        }
        
        else {
            gl.glPushMatrix();
            glu.gluSphere(q, .05f, SLICES, STACKS);
            gl.glTranslatef(0.16f, 0.0f, 0.0f);        
            glu.gluSphere(q, .05f, SLICES, STACKS);
            gl.glPopMatrix();
        }
        
        gl.glPopMatrix();
        
        
        set_mouth_material(gl);
        gl.glPushMatrix();
        gl.glTranslatef(0.9f, -0.65f, 0.12f); 
        gl.glRotatef(90f, 1f, 0f, 0f);
        
        
        gl.glTranslatef(-1.0f, -0.8f, -0.8f);        
        gl.glRotatef(90f, 1f, 0f, 0f);
        if(earMoving) {
            gl.glPushMatrix();
            glu.gluDisk(q, 0f, WIDTH_SHOES/2, SLICES, STACKS);
            gl.glPopMatrix();
        }else {
            gl.glPushMatrix();
            glu.gluDisk(q, 0f, WIDTH_SHOES/4, SLICES, STACKS);
            gl.glPopMatrix();
        }
        
        gl.glPopMatrix();
    }
    
    public void drawLeftEar(GL gl, GLU glu, char c) {
        System.out.println(currentX1);
        gl.glPushMatrix();
        gl.glTranslatef(-.2f, 0.95f, -1.0f);
        gl.glRotated(angle1, 0, 0, 1);
        gl.glScaled(.12, .12, .12);
        
        
            gl.glBegin( GL.GL_TRIANGLES ); 

            //drawing triangle in all dimensions
            // Front
            set_red_material(gl);
            
            gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top Of Triangle (Front)


            gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Left Of Triangle (Front)


            gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Right Of Triangle (Front)

            // Right
            set_black_material(gl);
            gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top Of Triangle (Right)


            gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Left Of Triangle (Right)


            gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Right Of Triangle (Right)

            // Left

            gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top Of Triangle (Back)


            gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Left Of Triangle (Back)

            gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Right Of Triangle (Back)

            //left
            gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Top Of Triangle (Left)

            gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Left Of Triangle (Left)

            gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Right Of Triangle (Left)

            gl.glEnd(); // Done Drawing 3d triangle (Pyramid)
           
        
        
       
        
        gl.glPopMatrix();
       
    }
    
    public void drawRightEar(GL gl, GLU glu, char c) {
        
        gl.glPushMatrix();
        gl.glTranslatef(-.79f, 0.95f, -1.0f);
        gl.glRotated(angle2, 0, 0, 1);
        gl.glScaled(.12, .12, .12);
        gl.glBegin( GL.GL_TRIANGLES ); 

        //drawing triangle in all dimensions
        // Front
        set_red_material(gl);
        gl.glVertex3f( -1.0f, 2.0f, 0.0f ); // Top Of Triangle (Front)

        
        gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Left Of Triangle (Front)

        
        gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Right Of Triangle (Front)

        // Right
        set_black_material(gl);
        gl.glVertex3f( -1.0f, 2.0f, 0.0f ); // Top Of Triangle (Right)

        
        gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Left Of Triangle (Right)

        
        gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Right Of Triangle (Right)

        // Left
        
        gl.glVertex3f( -1.0f, 2.0f, 0.0f ); // Top Of Triangle (Back)

        
        gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Left Of Triangle (Back)

        gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Right Of Triangle (Back)

        //left
        gl.glVertex3f( -1.0f, 2.0f, 0.0f ); // Top Of Triangle (Left)

        gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Left Of Triangle (Left)

        gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Right Of Triangle (Left)

        gl.glEnd(); // Done Drawing 3d triangle (Pyramid)
        gl.glPopMatrix();
    }
    
    public void drawLegs(GL gl, GLU glu, char c) {
        set_black_material(gl);
       
        if (c=='J'){
            gl.glPushMatrix();
            gl.glRotated(10, 1, 0, 0);
            gl.glRotated(90, 1, 0, 0);
            gl.glScaled(1.5,1.5,1.5);
            gl.glTranslatef(0f, -.8f, 0f);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS); 
            gl.glTranslatef(0f, 0.16f, 0.25f);
            gl.glRotated(90, 1, 0, 0);
            gl.glScaled(.89, .89, .89);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
            gl.glTranslatef(0f, .003f, .19f);
             glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
             gl.glPopMatrix();
             aux = ' ';
        }
        else{
            gl.glPushMatrix();
            gl.glRotated(90, 1, 0, 0);
            gl.glScaled(1.5,1.5,1.5);
            gl.glTranslatef(0f, -.8f, 0f);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS); 
            gl.glTranslatef(0f, 0.16f, 0.25f);
            gl.glRotated(90, 1, 0, 0);
            gl.glScaled(.89, .89, .89);
            glu.gluCylinder(q, WIDTH_ARMS, WIDTH_ARMS, HEIGHT_ARMS, SLICES, STACKS);
            glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
            gl.glTranslatef(0f, .003f, .19f);
             glu.gluSphere(q, WIDTH_ARMS, SLICES, STACKS);
             gl.glPopMatrix();
            aux = 'J';
        }
        
    }
    
    public void drawBody(GL gl, GLU glu, char c) {
        set_black_material(gl);
        if(c == 'J') {
            gl.glPushMatrix();
            gl.glTranslatef(.0f, .2f, .1f);
            gl.glRotated(90, 0, 0, 0);
    //        gl.glScaled(1.5,1.5,1.5);
            gl.glTranslatef(.35f, -.1f, -1.70f);
            gl.glRotated(-40, 1, 0, 0);
            glu.gluCylinder(q, .30f, .30f, .55f, SLICES, STACKS);
            glu.gluSphere(q, .30f, SLICES, STACKS); 
            gl.glPopMatrix();
        
        }
        if(c == 'L') {
            gl.glPushMatrix();
            gl.glRotated(90, 0, 0, 0);
    //        gl.glScaled(1.5,1.5,1.5);
            gl.glTranslatef(.35f, -.1f, -1.70f);
            gl.glRotated(06, 1, 0, 0);
            glu.gluCylinder(q, .30f, .30f, .55f, SLICES, STACKS);
            glu.gluSphere(q, .30f, SLICES, STACKS); 
            gl.glPopMatrix();
        }
        else {
        
            gl.glPushMatrix();
            gl.glRotated(90, 0, 0, 0);
    //        gl.glScaled(1.5,1.5,1.5);
            gl.glTranslatef(.35f, -.1f, -1.70f);
            gl.glRotated(-40, 1, 0, 0);
            glu.gluCylinder(q, .30f, .30f, .55f, SLICES, STACKS);
            glu.gluSphere(q, .30f, SLICES, STACKS); 
            gl.glPopMatrix();
        
        }
        
    
    }
    public void drawLaser(GL gl) {
        gl.glPushMatrix();
        set_red_material(gl);
        box(gl);
        
        gl.glPopMatrix();
    
    }
    public void set_blue_material (GL gl){
        
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
    public void set_white_material (GL gl){
         float mat_ambient[]={1.0f,1.0f,1.0f,1.0f};
        float mat_diffuse[]={1.0f,1.0f,1.0f,1.0f};
        float mat_specular[]={1.0f,1.0f,1.0f,1.0f};
                float shine=125.2f;    
                
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
    public void set_eyes_material (GL gl){
        
        float mat_ambient[]={0.0f,1.0f,0.0f,1.0f};
        float mat_diffuse[]={0.0f,1.0f,0.0f,1.0f};
        float mat_specular[]={0.0f,1.0f,0.0f,1.0f};
        float shine=51.2f;    
                
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_AMBIENT,mat_ambient, 0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_DIFFUSE,mat_diffuse,0);
        gl.glMaterialfv(GL.GL_FRONT_AND_BACK,GL.GL_SPECULAR,mat_specular,0);
        gl.glMaterialf(GL.GL_FRONT_AND_BACK,GL.GL_SHININESS,shine);
        
    }
    public void set_mouth_material(GL gl) {
        float mat_ambient[]={1.0f,0.0f,0.3f,1.0f};
        float mat_diffuse[]={1.0f,0.0f,0.3f,1.0f};
        float mat_specular[]={1.0f,0.0f,0.3f,1.0f};
        float shine=51.2f;    
                
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
}
