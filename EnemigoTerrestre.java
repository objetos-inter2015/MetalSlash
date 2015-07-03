import greenfoot.*;

/**
 * Write a description of class EnemigoTerrestre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemigoTerrestre extends Enemigos
{
    int cicloMovimiento=0;
    int animacion=0;
    public void act() 
    {
        animacion++;
        if(getX()>=60 && ban==0)
        {
            move(-3);
            if(animacion<10)
                setImage("Villanos2.png");
            else
            if(animacion<20)
            {
                setImage("Villanos.png");
                animacion=0;
            }
        }
        else
        {
            ban=1;
            move(3);
            if(animacion<10)
                setImage("VillanosD.png");
            else
            {
                setImage("VillanosD2.png");
                animacion=0;
            }
            if(animacion<20)
            
            bala.tipoEnemigo(3);
            if(getX()>=1060)
                ban=0;
        }
        
        cicloMovimiento=Greenfoot.getRandomNumber(300);
        if(isTouching(Jugador.class));
        else
            if(cicloMovimiento>60 && cicloMovimiento < 200)
                move(-5);
        
        if(cicloDisparo >= 30)
        {
            disparaBala();
            bala.tipoEnemigo(1);
        }
        if(isTouching(BalaPistola.class))
        {
            removeTouching(BalaPistola.class);
            getWorld().removeObject(this);
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

                

