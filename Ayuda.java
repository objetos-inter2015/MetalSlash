import greenfoot.*;

/**
 * Write a description of class Ayuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ayuda extends Actor
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
