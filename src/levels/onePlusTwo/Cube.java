/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package levels.onePlusTwo;

/**
 *
 * @author abraham
 */
public class Cube
{

    private float x;
    private float y;
    private float z;
    private float ancho;
    private float alto;
    private float deep;

    public Cube()
    {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.ancho = 0;
        this.alto = 0;
        this.deep = 0;
    }

    public Cube(float x, float y, float z, float ancho, float alto, float deep)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.ancho = ancho;
        this.alto = alto;
        this.deep = deep;
    }

    /**
     * @return the x
     */
    public float getX()
    {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x)
    {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY()
    {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y)
    {
        this.y = y;
    }

    /**
     * @return the z
     */
    public float getZ()
    {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(float z)
    {
        this.z = z;
    }

    /**
     * @return the ancho
     */
    public float getAncho()
    {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(float ancho)
    {
        this.ancho = ancho;
    }

    /**
     * @return the alto
     */
    public float getAlto()
    {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(float alto)
    {
        this.alto = alto;
    }

    /**
     * @return the deep
     */
    public float getDeep()
    {
        return deep;
    }

    /**
     * @param deep the deep to set
     */
    public void setDeep(float deep)
    {
        this.deep = deep;
    }

    
    }
