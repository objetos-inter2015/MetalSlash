import greenfoot.*;

/**
 * Write a description of class Puntos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puntos extends Actor
{
    public void act() 
    {
        if(getY()!=500&&getX()!=50)
        {
            setRotation(90);
            move(20);
        }
    }   
}
