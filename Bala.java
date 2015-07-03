import greenfoot.*;

/**
 * Write a description of class Bala here.
 * 
 * @author (jose luis portilla arias) 
 * @version (a version number or a date)
 */
public class Bala extends Actor
{
     Puntos coin;
    PuntosEneAereo coinA;
    int cont;
    /**
     * Constructor de la clase Bala
     */
    public Bala()
    {
        cont=0;
    }
    /**
     * metodo que verifica que tipo de enemigo toca la bala y dependiento de
     * que enemigo sea se dan los puntos
     */
    public void verifica()
    {
        if(isTouching(EnemigoTerrestre.class) )
        {
            coin=new Puntos();
            getWorld().addObject(coin,getX(),getY());
        }
        
        if(isTouching(EnemigoAereo.class))
        {
            coinA=new PuntosEneAereo();
            getWorld().addObject(coinA,getX(),getY());
        }
        cont++;
        if(cont>30)
        {
            cont=0;
            getWorld().removeObject(this);
        }
    }
}
