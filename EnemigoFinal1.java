import greenfoot.*;
import java.util.*;
/**
 * Write a description of class EnemigoFinal1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemigoFinal1 extends Enemigos
{
    PuntosEneAereo coin;
    public void act() 
    {
        if(isTouching(BalaPistola.class))
        {
            removeTouching(BalaPistola.class);
            cont++;
            if(cont>25)
            {
                coin=new PuntosEneAereo();
                getWorld().addObject(coin,getX()-20,getY()-5);
                coin=new PuntosEneAereo();
                getWorld().addObject(coin,getX()-40,getY()-10);
                coin=new PuntosEneAereo();
                getWorld().addObject(coin,getX(),getY()+5);
                coin=new PuntosEneAereo();
                getWorld().addObject(coin,getX()+20,getY());
                getWorld().removeObject(this);
                ban=1;
            }
        }
        else
          if(isTouching(BalaCañon.class))
        {
            removeTouching(BalaCañon.class);
             cont++;
            if(cont>25)
            {
                coin=new PuntosEneAereo();
                getWorld().addObject(coin,getX(),getY());
                getWorld().removeObject(this);
                ban=1;
            }
        }
        else
        if(isTouching(BalaRifle.class))
        {
            removeTouching(BalaRifle.class);
             cont++;
            if(cont>25)
            {
                coin=new PuntosEneAereo();
                getWorld().addObject(coin,getX(),getY());
                getWorld().removeObject(this);
                ban=1;
            }
        }
        
        
        dispara=Greenfoot.getRandomNumber(500);
        if(cicloDisparo >= 20 && dispara >410 && ban!=1)
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
