import greenfoot.*;

/**
 * Write a description of class Enemigos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigos extends Actor
{
    int cont;
    
    public Enemigos()
    {
        cont=0;
    }
    
    public void act() 
    {
        cont++;
        move(-10);
        insertaEnemy();
    }   
    
    public void insertaEnemy()
    {
        int random = Greenfoot.getRandomNumber(500);
        
        if(cont > random && random > 1000)
        {
            getWorld().addObject(this,798,500);
            cont=0;
        }
    }
}
