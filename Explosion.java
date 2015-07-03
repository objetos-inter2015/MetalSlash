import greenfoot.*;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Actor
{
    int cont =0;
    Puntos coin;
    public void act() 
    {
        if(isTouching(Enemigos.class)&& cont >9)
        {
            removeTouching(Enemigos.class);
            coin=new Puntos();
            getWorld().addObject(coin,getX()+10,getY()+100);
            coin=new Puntos();
            getWorld().addObject(coin,getX()+18,getY()+100);
            coin=new Puntos();
            getWorld().addObject(coin,getX()-10,getY()+100);
            coin=new Puntos();
            getWorld().addObject(coin,getX()-20,getY()+100);
            coin=new Puntos();
            getWorld().addObject(coin,getX(),getY()+100);
        }
          
        if(cont>10)
        {
            getWorld().removeObject(this);
            cont=0;
        }
        cont ++;
    }    
}
