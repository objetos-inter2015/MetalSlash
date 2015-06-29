import greenfoot.*;

/**
 * Write a description of class BalaEnemiga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaEnemiga extends Bala
{
    /**
     * Act - do whatever the BalaEnemiga wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(10);
    }
    
    public void tipoEnemigo(int tipo)
    {
        switch(tipo)
        {
            case 1:setRotation(180);
            break;
            case 2:setRotation(90);
            break;
        }
    }
}
