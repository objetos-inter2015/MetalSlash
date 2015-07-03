import greenfoot.*;

/**
 * Write a description of class PuntosEneAereo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuntosEneAereo extends Actor
{
    /**
     * Act - do whatever the PuntosEneAereo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setRotation(90);
        if(getY() < 400)
            move(10);
    }    
}
