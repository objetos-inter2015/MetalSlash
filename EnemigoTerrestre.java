import greenfoot.*;

/**
 * Write a description of class EnemigoTerrestre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemigoTerrestre extends Enemigos
{
    BalaEnemiga bala;
    int cicloDisparo=0;
    int cicloMovimiento=0;
    public void act() 
    {
        cicloMovimiento=Greenfoot.getRandomNumber(100);
        if(isTouching(Jugador.class));
        else
            if(cicloMovimiento>20 && cicloMovimiento < 40)
                move(-5);
        
        if(cicloDisparo >= 50)
            disparaBala();
            
        if(isTouching(BalaPistola.class))
            removeTouching(BalaPistola.class);
        cicloDisparo++;
    }
    
    public void disparaBala()
    {
         bala = new BalaEnemiga();
         getWorld().addObject(bala, getX() - 10, getY() );
         cicloDisparo=0;
         bala.tipoEnemigo(1);
    }
}
                

