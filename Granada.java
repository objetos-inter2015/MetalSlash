import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Granada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Granada extends Bala
{
    int direccion;
    Explosion bum;
    int cicloSalto;
    /**
     * constructor de la clase granada
     */
    public Granada()
    {
        direccion=0;
        bum = new Explosion();
        cicloSalto=0;
    }
    /**
     * Accion que realiza la parabola de la granada
     */
    public void act() 
    {
        cicloSalto++;
        if(Greenfoot.isKeyDown("left"))
            direccion = 2;
            
        if(direccion==2)
        {
            if(cicloSalto == 2)
            {
                setLocation(getX()-20,getY()-20);
            }
            if(cicloSalto == 4)
            {
                setLocation(getX()-20,getY()-20);
            }
            if(cicloSalto == 6)
            {
                setLocation(getX()-20,getY()-20);
            }
            if(cicloSalto == 8)
            {
                setLocation(getX()-20,getY()-20);
            }
             if(cicloSalto == 10)
            {
                setLocation(getX()-20,getY()-20);
            }
            if(cicloSalto == 12)
            {
                setLocation(getX()-20,getY()-20);
            }
            if(cicloSalto == 14)
            {
                setLocation(getX()-20,getY()-20);
            }
            if(cicloSalto == 16)
            {
                setLocation(getX()-20,getY()-20);
            }
             if(cicloSalto == 18)
            {
                setLocation(getX()-20,getY()-20);
            }
            if(cicloSalto == 20)
            {
                setLocation(getX()-20,getY()-20);
            }
            if(cicloSalto == 22)
            {
                setLocation(getX()-20,getY()+20);
            }
            if(cicloSalto == 24)
            {
                setLocation(getX()-20,getY()+20);
            }
             if(cicloSalto == 26)
            {
                setLocation(getX()-20,getY()+20);
            }
            if(cicloSalto == 28)
            {
                setLocation(getX()-20,getY()+20);
            }
            if(cicloSalto == 30)
            {
                setLocation(getX()-20,getY()+20);
            }
              if(cicloSalto == 32)
            {
                setLocation(getX()-20,getY()+20);
            }
             if(cicloSalto == 34)
            {
                setLocation(getX()-20,getY()+20);
            }
            if(cicloSalto == 36)
            {
                setLocation(getX()-20,getY()+20);
            }
            if(cicloSalto == 38)
            {
                setLocation(getX()-20,getY()+20);
            }
            if(cicloSalto == 40)
            {
                Greenfoot.playSound("EXPLOBIG.mp3");
                getWorld().addObject(bum,getX(),getY()-70);
                getWorld().removeObject(this);
                cicloSalto=0;
                direccion=0;

            }
        }
        else{
            if(cicloSalto == 2)
            {
                setLocation(getX()+20,getY()-20);
            }
            if(cicloSalto == 4)
            {
                setLocation(getX()+20,getY()-20);
            }
            if(cicloSalto == 6)
            {
                setLocation(getX()+20,getY()-20);
            }
            if(cicloSalto == 8)
            {
                setLocation(getX()+20,getY()-20);
            }
             if(cicloSalto == 10)
            {
                setLocation(getX()+20,getY()-20);
            }
            if(cicloSalto == 12)
            {
                setLocation(getX()+20,getY()-20);
            }
            if(cicloSalto == 14)
            {
                setLocation(getX()+20,getY()-20);
            }
            if(cicloSalto == 16)
            {
                setLocation(getX()+20,getY()-20);
            }
             if(cicloSalto == 18)
            {
                setLocation(getX()+20,getY()-20);
            }
            if(cicloSalto == 20)
            {
                setLocation(getX()+20,getY()-20);
            }
            if(cicloSalto == 22)
            {
                setLocation(getX()+20,getY()+20);
            }
            if(cicloSalto == 24)
            {
                setLocation(getX()+20,getY()+20);
            }
             if(cicloSalto == 26)
            {
                setLocation(getX()+20,getY()+20);
            }
            if(cicloSalto == 28)
            {
                setLocation(getX()+20,getY()+20);
            }
            if(cicloSalto == 30)
            {
                setLocation(getX()+20,getY()+20);
            }
              if(cicloSalto == 32)
            {
                setLocation(getX()+20,getY()+20);
            }
             if(cicloSalto == 34)
            {
                setLocation(getX()+20,getY()+20);
            }
            if(cicloSalto == 36)
            {
                setLocation(getX()+20,getY()+20);
            }
            if(cicloSalto == 38)
            {
                setLocation(getX()+20,getY()+20);
            }
            if(cicloSalto == 40)
            {
                setLocation(getX()+20,getY()+20);
                Greenfoot.playSound("EXPLOBIG.mp3");
                getWorld().addObject(bum,getX(),getY()-80);
                getWorld().removeObject(this);
                cicloSalto=0;
            }
        }
    }
}
