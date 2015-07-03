
import greenfoot.*;

/**
 * Write a description of class EnemigoAereo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemigoAereo extends Enemigos
{
    Puntos coin;
    int dir=0;
    public void act() 
    {
        if(getX()>=60 && dir==0)
        {
            move(-3);
            setImage("Nave2.png");
        }
        else
        {
            dir=1;
            move(3);
            setImage("Nave2-1.png");
            if(getX()==1000)
                dir=0;
        }
        
        if(cicloDisparo >= 55)
        {
            disparaBala();
            bala.tipoEnemigo(2);
        }
        
        if(isTouching(BalaPistola.class))
        {

            cont++;
            if(cont>2)
            {
                getWorld().removeObject(this);
                cont=0;
            }
            
        }
        else
         if(isTouching(BalaCañon.class))
        {
            removeTouching(BalaCañon.class);
            getWorld().removeObject(this);
        }
        else
        if(isTouching(BalaRifle.class))
        {
            removeTouching(BalaRifle.class);
            getWorld().removeObject(this);
        }
        
        cicloDisparo++;
    }
    
    
}
