import greenfoot.*;

/**
 * Write a description of class BalaEnemiga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaEnemiga extends Bala
{
    int cont=0;
    public void act() 
    {
        if(isTouching(Jugador.class) || cont>50)
        getWorld().removeObject(this);
        move(10);
        
        cont++;
    }
    
    public void tipoEnemigo(int tipo)
    {
        switch(tipo)
        {
            case 1:setRotation(180);
            break;
            case 2:setRotation(90);
            break;
            case 3:setRotation(0);
            break;
            case 4:setRotation(Greenfoot.getRandomNumber(270));
            break;
        }
    }
}
