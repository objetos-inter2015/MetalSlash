import greenfoot.*;

/**
 * Write a description of class EnemigoFinal2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemigoFinal2 extends Enemigos
{
    public void act() 
    {
        if(isTouching(BalaPistola.class))
        {
            removeTouching(BalaPistola.class);
            cont++;
            if(cont>50)
            {
                getWorld().removeObject(this);
                ban=1;
            }
        }
        else
          if(isTouching(BalaCañon.class))
        {
            removeTouching(BalaCañon.class);
            cont++;
            if(cont>50)
            {
                getWorld().removeObject(this);
                ban=1;
            }
        }
        else
        if(isTouching(BalaRifle.class))
        {
            removeTouching(BalaRifle.class);
            cont++;
            if(cont>50)
            {
                getWorld().removeObject(this);
                ban=1;
            }
        }
        
        dispara=Greenfoot.getRandomNumber(500);
        if(cicloDisparo >= 5 && dispara > 350)
        {
            disparaBala();
            bala.tipoEnemigo(4);
        }
        
        cicloDisparo++;
    }
    
    public int bandera()
    {
        return ban;
    }
}
