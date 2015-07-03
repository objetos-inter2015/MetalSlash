import greenfoot.*;

/**
 * Write a description of class MunicionGranada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MunicionGranada extends Municiones
{
   
    int cont=0;
    public void act() 
    {
        if(getY()!=20)
        {
            cont++;
            if(cont>100)
            {
                getWorld().removeObject(this);
            }
        }
    }    
}
