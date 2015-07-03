import greenfoot.*;

/**
 * Write a description of class Creditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditos extends Actor
{
   int ban=0;
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        ban=1;
        else
        ban=0;
    } 
    public int presiona()
    {
        return ban;
    }
}
