import greenfoot.*;

/**
 * Write a description of class MunicionRifle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MunicionRifle extends Municiones
{
   
    int cont=0;
    public void act() 
    {
        cont++;
        if(cont>100)
        {
            getWorld().removeObject(this);
        }
    }    
}
