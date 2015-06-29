import greenfoot.*;

/**
 * Write a description of class EnemigoAereo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemigoAereo extends Enemigos
{
    BalaEnemiga bala;
    int cicloDisparo=0;
    int ban=0;
    
    public void act() 
    {
        if(getX()>=60 && ban==0)
        {
            move(-3);
            setImage("Nave2.png");
        }
        else
        {
            ban=1;
            move(3);
            setImage("Nave2-1.png");
            if(getX()==1000)
                ban=0;
        }
        
        if(cicloDisparo >= 45)
            disparaBala();
        
        if(isTouching(BalaPistola.class))
            removeTouching(BalaPistola.class);
        
        cicloDisparo++;
    }
    
    public void disparaBala()
    {
         bala = new BalaEnemiga();
         getWorld().addObject(bala, getX() - 10, getY() );
         bala.setRotation(90);
         cicloDisparo=0;
         bala.tipoEnemigo(2);
     }
}
