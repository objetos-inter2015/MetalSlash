import greenfoot.*;

/**
 * Write a description of class Puntos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puntos extends Actor
{
    int cont=0;
    public void act() 
    {
        if(getY()!=80)
        {
            cont ++;
            if(cont>200)
                getWorld().removeObject(this);
        }       
    }   
}
