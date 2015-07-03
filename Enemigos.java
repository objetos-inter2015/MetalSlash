import greenfoot.*;

/**
 * Write a description of class Enemigos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigos extends Actor
{
    int cont;
    int ban,cicloDisparo;
    BalaEnemiga bala;
    int dispara;
    Puntos coin;
    /**
     * Constructor de la clase Enemigos: estos atributos son heredados a cada tipo de enemigo
     * (clases hijas de esta clase)
     */
    public Enemigos()
    {
        ban=0;
        cicloDisparo=0;
        cont=0;
        dispara=0;
    }
 
    /**
     * Metodo que realiza el disparo de los enemigos, este metodo lo heredan los diferentes
     * tipos de enemigos
     */
    public void disparaBala()
    {
         Greenfoot.playSound("pistola.mp3");
         bala = new BalaEnemiga();
         getWorld().addObject(bala, getX() - 10, getY() );
         cicloDisparo=0;
    }
   
}
