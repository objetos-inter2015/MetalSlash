import greenfoot.*;

/**
 * Write a description of class BalaRifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaRifle extends Bala
{
    Puntos p;
    public void act() 
    {
        move(40);
        if(isTouching(EnemigoTerrestre.class))
        {
            removeTouching(EnemigoTerrestre.class);
            p=new Puntos();
            getWorld().addObject(p,getX(),getY());
        }
        
        if(isTouching(EnemigoAereo.class))
        {
            removeTouching(EnemigoAereo.class);
            p=new Puntos();
            getWorld().addObject(p,getX(),getY());
        }
    }    
}
