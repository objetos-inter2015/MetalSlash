import greenfoot.*;
import javax.swing.*;

/**
 * @author Jose Luis Portilla Aria
 * 
 */
public class Jugador extends Actor
{
   //int armas;
   //int escudo;
   
   private MunicionGranada munG = new MunicionGranada();
   private BalaPistola balaP = new BalaPistola();
   private BalaRifle balaR;
   private BalaCañon balaC;
   
   private Granada g=new Granada();
   private cañon c = new cañon();
   private Rifle r = new Rifle();
   private Pistola p = new Pistola();
   
   private Puntos coin = new Puntos();
   private Vida life = new Vida();
   
   public int puntuacion;
   private int direccion;
   private int tipoArma;
   //banderas de ciclos
   private int cicloSalto,cicloDisparo,cicloVidas,cicloCambio;
   //contadores
   private int contMunicionP,contMunicionRif,contMunicionCañon,contMunGranadas;
   public int contVidas;
   //banderas de armas
   private int  bandRifle,bandSalto,bandCañon, ban,banG;
   String nombre = new String();
    /**
    * constructor de la clase Jugador
    */
    public Jugador()
    {
        
        puntuacion=0;
        direccion = 0;
        tipoArma=0;
        
        cicloVidas=0;
        cicloCambio=0;
        cicloDisparo = 0;
        cicloSalto = 0;
        

        contMunGranadas=0;
        contMunicionP = 70;
        contMunicionRif=10;
        contMunicionCañon=5;
        contVidas=50;
        
        bandSalto=0;

        banG=0;
        ban=0;
        bandCañon=0;
        bandRifle=0;
    }
    /**
     * en este metodo se verifican los movimientos del jugador, si esta tocando otro objeto, cambios de armas y acciones como saltar o disparar
     */
    public void act()
    {
            setImage("Personaje_Parado.png");
        
            if(Greenfoot.isKeyDown("right"))
            {
                direccion = 1;
                move(10);
                setImage("Personaje_Parado2.png");
            }
            
            if(Greenfoot.isKeyDown("left"))
            {
                direccion = 2;
                move(-10);
                setImage("Personaje_ParadoI.png");
            }
        
       if(Greenfoot.isKeyDown("up"))
        {
            direccion = 3;
            setImage("Personaje_Arriba.png");
        }
        
        if(Greenfoot.isKeyDown("s"))
            bandSalto = 1;
            if(bandSalto == 1 )
            {
                cicloSalto++;
                setImage("Personaje_Arriba.png");
                salto();
            }
        
        if(Greenfoot.isKeyDown("c") && cicloCambio>=10)
        {
            Greenfoot.playSound("cargando-arma.mp3");
            if(tipoArma>2)
                tipoArma=0;
            else
                tipoArma++;
            
            if(tipoArma==0)
            {
                p=new Pistola();
                getWorld().addObject(p,800,40);
            }
            
            if(tipoArma==1)
            {
                r=new Rifle();
                getWorld().addObject(r,800,40);
            }
            
            if(tipoArma==2)
            {
                c=new cañon();
                getWorld().addObject(c,800,40);
            }
            
            if(tipoArma==3)
            {
                munG=new MunicionGranada();
                getWorld().addObject(munG,800,40);
            }
            cicloCambio=0;
        }
        

        if(contMunicionP != 0)
        {
            if(Greenfoot.isKeyDown("space"))
            {
                
                switch(tipoArma)
                {
                    case 0:
                    {
                        if(cicloDisparo >= 25)
                        {
                            
                            contMunicionP--;
                            cicloDisparo=0;
                            disparaBala(0);
                        }
                    }
                        break;
                    case 1:
                    {
                        if(contMunicionRif!=0 && bandRifle == 1)
                        {
                            contMunicionRif--;
                            disparaBala(1);
                        }
                    }
                        break;
                    case 2:
                    {
                        if(contMunicionCañon != 0 && cicloDisparo >= 5 && bandCañon == 1)
                        {
                            contMunicionCañon--;
                            cicloDisparo=0;
                            disparaBala(2);
                        }
                    }
                        break;
                    case 3:
                    {
                        if(contMunGranadas!=0)
                        if(cicloDisparo>=20)
                        {
                            contMunGranadas--;
                            cicloDisparo=0;
                            disparaBala(3);
                        }
                    }
                    break;
                }
            }   
        }
        
        if(isTouching(PuntosEneAereo.class))
        {
            removeTouching(PuntosEneAereo.class);
            puntuacion+=20;
        }
        
        if(ban==0)
        {
            getWorld().addObject(coin,50,80);
            getWorld().addObject(life,50,20);
            getWorld().addObject(p,50,50);
            getWorld().addObject(p,50,550);
            ban=1;
        }
        
        if(isTouching(MunicionPistola.class))
        {
            contMunicionP+=10;
            removeTouching(MunicionPistola.class);
            Greenfoot.playSound("Carga-pistola.mp3");
        }
        getWorld().showText(String.valueOf(contMunicionP),100,50);
        
        if(isTouching(MunicionRifle.class))
        {
            contMunicionRif+=20;
            removeTouching(MunicionRifle.class);
            Greenfoot.playSound("Carga-pistola.mp3");
        }
        
        if(isTouching(MunicionCañon.class))
        {
            contMunicionCañon+=5;
            removeTouching(MunicionCañon.class);
            Greenfoot.playSound("Carga-pistola.mp3");
        }
        
        if(isTouching(MunicionGranada.class))
        {
            if(banG==0)
            {
                munG = new MunicionGranada();
                getWorld().addObject(munG,250,20);
                banG=1;
            }
            Greenfoot.playSound("Carga-pistola.mp3");
            removeTouching(MunicionGranada.class);
            contMunGranadas++;
            getWorld().showText(String.valueOf(contMunGranadas),280,20);
        }
        if (banG==1)
            getWorld().showText(String.valueOf(contMunGranadas),280,20);
        
        if(isTouching(Rifle.class))
        {
            if(bandRifle==0)
            {
                getWorld().addObject(r,150,50);
                bandRifle=1;
            }
            Greenfoot.playSound("Carga-pistola.mp3");
            removeTouching(Rifle.class);
        }
        if(bandRifle==1)
            getWorld().showText(String.valueOf(contMunicionRif),200,50);
        
        if(isTouching(cañon.class)&&bandCañon==0)
        {
            getWorld().addObject(c,150,20);
            removeTouching(cañon.class);
            Greenfoot.playSound("Carga-pistola.mp3");
            bandCañon=1;
        }
        if(bandCañon==1)
            getWorld().showText(String.valueOf(contMunicionCañon),200,20);
        
        if(isTouching(Puntos.class))
        {
            removeTouching(Puntos.class);
            puntuacion+=10;
        }
        
        if(isTouching(Vida.class))
        {   
            removeTouching(Vida.class);
            life = new Vida();    
            contVidas+=10;
        }
        getWorld().showText(String.valueOf(contVidas),100,20);
        
        if(contVidas != 0)
        {
            if(isTouching(BalaEnemiga.class) || isTouching(EnemigoTerrestre.class) && cicloVidas >= 500)
            {
                contVidas--;
                cicloVidas=0;
            }
        }
        
        cicloCambio++;
        cicloVidas++;
        cicloDisparo++;
    }
    
    /**
     * Este metodo realiza el disparo del jugador verificando primero que tipo de arma esta utilizando en el momento de disparar
     */
 
     public void disparaBala(int tipo)
    {
         
         switch(tipo)
         {
             case 0:
                 {
                     Greenfoot.playSound("pistola.mp3");
                     if( direccion == 1)
                     {
                         setImage("Personaje_Disparo.png");
                         balaP = new BalaPistola();
                         getWorld().addObject(balaP, getX() + 60, getY()-22 );
                         balaP.setRotation(0);
                     }
                            
                     if( direccion == 2)
                     {
                         setImage("Personaje_DisparoI.png");
                         balaP = new BalaPistola();
                         getWorld().addObject(balaP, getX() - 60, getY()-22 );
                         balaP.setRotation(180);
                     }
                            
                     if( direccion == 3)
                     {
                         setImage("Personaje_Arriba.png");
                         balaP = new BalaPistola();
                         getWorld().addObject(balaP, getX(), getY()-15 );
                         balaP.setRotation(270);
                     }
                 }
                 break;
             case 1:
                 {
                     Greenfoot.playSound("pistola.mp3");
                     if( direccion == 1)
                     {
                         setImage("Personaje_Disparo.png");
                         balaR = new BalaRifle();
                         getWorld().addObject(balaR, getX() + 60, getY()-22 );
                         balaR.setRotation(0);
                     }
                            
                     if( direccion == 2)
                     {
                         setImage("Personaje_DisparoI.png");
                         balaR = new BalaRifle();
                         getWorld().addObject(balaR, getX() - 60, getY()-22 );
                         balaR.setRotation(180);
                     }
                            
                     if( direccion == 3)
                     {
                         setImage("Personaje_Arriba.png");
                         balaR = new BalaRifle();
                         getWorld().addObject(balaR, getX() , getY()-15);
                         balaR.setRotation(270);
                     }
                 }
                 break;
             case 2:
                 {
                     Greenfoot.playSound("pistola.mp3");
                     if( direccion == 1)
                     {
                         setImage("Personaje_Disparo.png");
                         balaC = new BalaCañon();
                         getWorld().addObject(balaC, getX() + 60, getY()-22 );
                         balaC.setRotation(0);
                     }
                            
                     if( direccion == 2)
                     {
                         setImage("Personaje_DisparoI.png");
                         balaC = new BalaCañon();
                         getWorld().addObject(balaC, getX() - 60, getY()-22 );
                         balaC.setRotation(180);
                     }
                            
                     if( direccion == 3)
                     {
                         setImage("Personaje_Arriba.png");
                         balaC = new BalaCañon();
                         getWorld().addObject(balaC, getX() , getY()-15 );
                         balaC.setRotation(270);
                     }
                 }
                 break;
             case 3:
                 {
                     Greenfoot.playSound("granada.mp3");
                     if( direccion == 1)
                     {
                         setImage("Personaje_Disparo.png");
                         g = new Granada();
                         getWorld().addObject(g, getX() + 60, getY()-22 );
                         g.setRotation(0);
                     }
                            
                     if( direccion == 2)
                     {
                         setImage("Personaje_DisparoI.png");
                         g = new Granada();
                         getWorld().addObject(g, getX() - 60, getY()-22 );
                         g.setRotation(180);
                     }
                 }
                 break;
    }
   }
    /**
     * Metodo que realiza el salto del jugador
     */
    public void salto()
    {
        if(cicloSalto == 2)
        {
            setLocation(getX(),getY()-20);
        }
        if(cicloSalto == 4)
        {
            setLocation(getX(),getY()-20);
        }
        if(cicloSalto == 6)
        {
            setLocation(getX(),getY()-20);
        }
        if(cicloSalto == 8)
        {
            setLocation(getX(),getY()-20);
        }
         if(cicloSalto == 10)
        {
            setLocation(getX(),getY()-20);
        }
        if(cicloSalto == 12)
        {
            setLocation(getX(),getY()-20);
        }
        if(cicloSalto == 14)
        {
            setLocation(getX(),getY()-20);
        }
        if(cicloSalto == 16)
        {
            setLocation(getX(),getY()-20);
        }
         if(cicloSalto == 18)
        {
            setLocation(getX(),getY()-20);
        }
        if(cicloSalto == 20)
        {
            setLocation(getX(),getY()-20);
        }
        if(cicloSalto == 22)
        {
            setLocation(getX(),getY()+20);
        }
        if(cicloSalto == 24)
        {
            setLocation(getX(),getY()+20);
        }
         if(cicloSalto == 26)
        {
            setLocation(getX(),getY()+20);
        }
        if(cicloSalto == 28)
        {
            setLocation(getX(),getY()+20);
        }
        if(cicloSalto == 30)
        {
            setLocation(getX(),getY()+20);
        }
          if(cicloSalto == 32)
        {
            setLocation(getX(),getY()+20);
        }
         if(cicloSalto == 34)
        {
            setLocation(getX(),getY()+20);
        }
        if(cicloSalto == 36)
        {
            setLocation(getX(),getY()+20);
        }
        if(cicloSalto == 38)
        {
            setLocation(getX(),getY()+20);
        }
        if(cicloSalto == 40)
        {
            setLocation(getX(),getY()+20);
            bandSalto=0;
            cicloSalto=0;
        }
    }
    
}