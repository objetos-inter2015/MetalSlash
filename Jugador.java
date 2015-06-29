import greenfoot.*;

/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugador extends Actor
{
   //int armas;
   //int escudo;
   //String nombre;
   Granada g,g2;
   BalaPistola balaP,balaP2 = new BalaPistola();
   BalaRifle balaR;
   BalaCañon balaC;
   Vida life = new Vida();
   cañon c = new cañon();
   Rifle r = new Rifle();
   Pistola p = new Pistola();
   Puntos coin = new Puntos();

   
   int puntuacion=0;
   int direccion;
   int cicloSalto,bandSalto,cicloDisparo,cicloLanza,cicloVidas;
   int intervalo,contGranadas=10,contMunicionP,contVidas=10,contMunicionRif,contMunicionCañon,contMunGranadas=0;
   int cicloCambio;
   int tipoArma;
   int  bandRifle=0,bandCañon=0;
   
   int ban=0,banGranada=0,banCañon=0,banRifle=0;
   int lanza=0;
    public Jugador()
    {

        cicloCambio=0;
        tipoArma=0;
        cicloVidas=0;
        contVidas=10;
        cicloLanza = 0;
        g=new Granada();
        cicloDisparo = 0;
        //bandDisparo=0;
        bandSalto=0;
        intervalo = 5;
        cicloSalto = 0;
        direccion = 0;
        //escudo = 0;
        
        contMunicionP = 10;
        contMunicionRif=20;
        contMunicionCañon=5;
    }
    
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
            setImage("Personaje_Parado2.png");
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
                salto();
            }
        
        if(Greenfoot.isKeyDown("c") && cicloCambio>=10)
        {
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
                g=new Granada();
                getWorld().addObject(g,800,400);
            }
            cicloCambio=0;
        }
        
        if(contMunicionP != 0)
        {
            if(Greenfoot.isKeyDown("space"))
            {
                setImage("Personaje_Disparo.png");
                switch(tipoArma)
                {
                    case 0:
                        if(cicloDisparo >= 10)
                        {
                            cicloDisparo=0;
                            disparaBala(0);
                        }
                        break;
                    case 1:
                    {
                        contMunicionRif--;
                        if(bandRifle == 1)
                            disparaBala(1);
                    }
                        break;
                    case 2:
                        if(cicloDisparo >= 5 && bandCañon == 1)
                        {
                            cicloDisparo=0;
                            disparaBala(2);
                        }
                        break;
                    case 3:
                        if(cicloDisparo>=20)
                        {
                            cicloDisparo=0;
                            disparaBala(3);
                        }
                }
            }   
        }
        
        if(ban==0)
        {
            getWorld().addObject(coin,50,80);
            getWorld().addObject(life,50,20);
            getWorld().addObject(p,50,50);
            getWorld().addObject(p,50,550);
            ban=1;
        } 
        
        if(isTouching(cañon.class))
        {
            getWorld().addObject(c,150,20);
            removeTouching(cañon.class);
        }
        
        if(isTouching(MunicionPistola.class))
        {
            contMunicionP+=10;
            removeTouching(MunicionPistola.class);
        }
        getWorld().showText(String.valueOf(contMunicionP),100,50);
        
        if(isTouching(MunicionRifle.class))
        {
            contMunicionRif+=20;
            removeTouching(MunicionRifle.class);
            getWorld().showText(String.valueOf(contMunicionRif),200,50);
        }
        
        if(isTouching(MunicionCañon.class))
        {
            contMunicionCañon+=5;
            removeTouching(MunicionCañon.class);
            getWorld().showText(String.valueOf(contMunicionCañon),200,20);
        }
        
        if(isTouching(MunicionGranada.class))
        {
            removeTouching(MunicionGranada.class);
            contMunGranadas++;
            getWorld().showText(String.valueOf(contMunGranadas),280,20);
        }
        
        if(isTouching(Rifle.class))
        {
            if(banRifle==0)
            {
                getWorld().addObject(r,150,50);
                bandRifle=1;
                banRifle=1;
            }
            removeTouching(Rifle.class);
            getWorld().showText(String.valueOf(contMunicionRif),100,50);
        }
        
        if(isTouching(Puntos.class))
        {
            removeTouching(Puntos.class);
            puntuacion+=10;
        }
        getWorld().showText(String.valueOf(puntuacion),100,80);
        
        if(isTouching(Vida.class))
        {   
            removeTouching(Vida.class);
            life = new Vida();    
            contVidas++;
        }
        getWorld().showText(String.valueOf(contVidas),100,20);
        
        
        if(contVidas != 0)
        {
            if(isTouching(BalaCañon.class) || isTouching(BalaEnemiga.class) || isTouching(EnemigoTerrestre.class) && cicloVidas >= 50)
            {
                contVidas--;
                cicloVidas=0;
            }
        }
        else
        getWorld().setBackground("gameOver.png");
        
        cicloCambio++;
        cicloVidas++;
        cicloDisparo++;
        cicloLanza++;
        
        
    }
    
 
     public void disparaBala(int tipo)
    {
         
         switch(tipo)
         {
             case 0:
                 {
                     contMunicionP--;
                     if( direccion == 1)
                     {
                         balaP = new BalaPistola();
                         getWorld().addObject(balaP, getX() + 10, getY() );
                         balaP.setRotation(0);
                     }
                            
                     if( direccion == 2)
                     {
                         balaP = new BalaPistola();
                         getWorld().addObject(balaP, getX() + 10, getY() );
                         balaP.setRotation(180);
                     }
                            
                     if( direccion == 3)
                     {
                         balaP = new BalaPistola();
                         getWorld().addObject(balaP, getX() + 10, getY() );
                         balaP.setRotation(270);
                     }
                 }
                 break;
             case 1:
                 {
                     contMunicionRif--;
                     if( direccion == 1)
                     {
                         balaR = new BalaRifle();
                         getWorld().addObject(balaR, getX() + 10, getY() );
                         balaR.setRotation(0);
                     }
                            
                     if( direccion == 2)
                     {
                         balaR = new BalaRifle();
                         getWorld().addObject(balaR, getX() + 10, getY() );
                         balaR.setRotation(180);
                     }
                            
                     if( direccion == 3)
                     {
                         balaR = new BalaRifle();
                         getWorld().addObject(balaR, getX() + 10, getY() );
                         balaR.setRotation(270);
                     }
                 }
                 break;
             case 2:
                 {
                     if( direccion == 1)
                     {
                         balaC = new BalaCañon();
                         getWorld().addObject(balaC, getX() + 10, getY() );
                         balaC.setRotation(0);
                     }
                            
                     if( direccion == 2)
                     {
                         balaC = new BalaCañon();
                         getWorld().addObject(balaC, getX() + 10, getY() );
                         balaC.setRotation(180);
                     }
                            
                     if( direccion == 3)
                     {
                         balaC = new BalaCañon();
                         getWorld().addObject(balaC, getX() + 10, getY() );
                         balaC.setRotation(270);
                     }
                 }
                 break;
             case 3:
                 {
                     contGranadas++;
                     if( direccion == 1)
                     {
                         g = new Granada();
                         getWorld().addObject(g, getX() + 10, getY() );
                         g.setRotation(0);
                     }
                            
                     if( direccion == 2)
                     {
                         g = new Granada();
                         getWorld().addObject(g, getX() + 10, getY() );
                         g.setRotation(180);
                     }
                 }
                 break;
    }
   }
    
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