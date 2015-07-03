import greenfoot.*;

/**
 * Write a description of class MunicionPistola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MunicionPistola extends Municiones
{
    
    public void act() 
    {
        tiempo++;
        if(tiempo>100)
        {
            getWorld().removeObject(this);
        }
    }    
}
