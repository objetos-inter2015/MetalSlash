import greenfoot.*;

/**
 * Write a description of class BalaCañon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaCañon extends Bala
{
    /**
     * Act - do whatever the BalaCañon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(15);
        if(isTouching(EnemigoTerrestre.class))
        {
            removeTouching(EnemigoTerrestre.class);
        }
        if(isTouching(EnemigoAereo.class))
            removeTouching(EnemigoAereo.class);
    }    
}
