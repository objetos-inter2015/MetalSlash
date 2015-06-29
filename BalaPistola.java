import greenfoot.*;

/**
 * Write a description of class BalaPistola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BalaPistola extends Bala
{
    Puntos coin;
    int grados=0;
    int contEnemigos=0;
    public void act() 
    {
        move (20);
        if(isTouching(EnemigoTerrestre.class))
        {
            contEnemigos++;
            removeTouching(EnemigoTerrestre.class);
            coin=new Puntos();
            getWorld().addObject(coin,getX(),getY());
        }
       
        if(isTouching(EnemigoAereo.class))
        {
            contEnemigos++;
            removeTouching(EnemigoAereo.class);
            coin=new Puntos();
            getWorld().addObject(coin,getX(),getY());
        }
    }   
  
}
