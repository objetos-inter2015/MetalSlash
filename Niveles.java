import greenfoot.*;
import java.util.*;
import javax.swing.*;

/**
 * Write a description of class Niveles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Niveles extends World
{
    Jugador player=  new Jugador();
    Jugador player2 = new Jugador();
    Vida life,life2 = new Vida();
    Granada gra;
    Rifle rif;
    cañon can;
    Granada gran;
    
    MunicionPistola munP;
    MunicionRifle munR;
    MunicionCañon munC;
    MunicionGranada munG;
    
    BalaPistola balaP,balaP2=new BalaPistola();
    BalaRifle balaR;
    BalaCañon balaC;
    
    EnemigoTerrestre eneT;
    EnemigoAereo eneA;
   
    int vidaJugador=10;
    
    int timeEneTe,timeEneA;
    int timeGranada,timeCañon,timeRifle,timeMunicionPistola;
    int timeMunicionCañon, timeMunicionRifle;
    int granada,Cañon,rifle,munPistola,munCañon,munRifle,vida;
    int contEneT,contEneA,contCicloVida;
    int tiempoAparicionEne;
    int timeVida;
    int banC=0,banR=0,ban=0,ban1=0,ban2=0,ban3=0;
    

    int contPistola,contCañon,contGranada,contRifle;
    
    boolean v;
    boolean c;
    public Niveles()
    {    
        super(1079, 603, 1);
        
        addObject(player,100,500); 

        contRifle=0;
        contGranada=0;
        contCicloVida=0;
        
        vida=800;
        
        timeEneA = 0;
        timeEneTe = 0;
        
        granada=500;
        munPistola=800;
        rifle=100;
        munRifle=1000;
        Cañon=100;
        munCañon=500;
        contPistola=0;
        contEneT=0;
        contEneA=0;
    }
    
    public void act()
    {
        timeVida = Greenfoot.getRandomNumber(2000);
        timeCañon = Greenfoot.getRandomNumber(1000);
        timeMunicionPistola = Greenfoot.getRandomNumber(2000);
        timeMunicionCañon = Greenfoot.getRandomNumber(2000);
        timeMunicionRifle = Greenfoot.getRandomNumber(2000);
        timeRifle = Greenfoot.getRandomNumber(1000);
        timeGranada = Greenfoot.getRandomNumber(1000);
        tiempoAparicionEne = Greenfoot.getRandomNumber(2500);
        timeEneTe++;
        
        timeEneA++;
        contCicloVida++;
        contCañon++;
        contRifle++;
        contPistola++;
        contGranada++;
        
       
    }
    
    public void primerNivel()
    {
        int siguienteNivel = 0;
        int numAleGra = 600;
        int maxEne=0;
        
        setBackground("Escenario1.jpg");
        
        if(timeEneTe == 500 && contEneT < 5)
        {
            contEneT++;
            timeEneTe=0;
            creaEnemigoTerrestre();
        }
        
        if(timeGranada > granada && contGranada > granada)
        {
             munG = new MunicionGranada();
             addObject(munG,Greenfoot.getRandomNumber(700),500);
             contGranada=0;
        }
         
        if(timeMunicionPistola > munPistola && contPistola > munPistola)
        {
            munP = new MunicionPistola();
            addObject(munP,Greenfoot.getRandomNumber(700),500);
            contPistola = 0;
        }
        
        if(timeVida > vida && contCicloVida > vida)
        {
            life = new Vida();
            addObject(life,Greenfoot.getRandomNumber(700),500);
            contCicloVida=0;
        }
        
                segundoNivel();
         
    }
    
    public void segundoNivel()
    {
        int vidas=0;
        int numEnemigos=0;
        int siguienteNivel = 0;
        int tiempoRifle = 1000;
        setBackground("Escenario2.jpg");
        
        if(timeEneTe==50 && contEneT < 5)
        {
            contEneT++;
            timeEneTe=0;
            creaEnemigoTerrestre();
        }
        
        if(timeRifle > rifle && contRifle > rifle && banR == 0)
        {
             rif = new Rifle();
             addObject(rif, Greenfoot.getRandomNumber(700),500);
             contRifle=0;
             banR=1;
             
        }
        
        if(timeGranada > granada && contGranada > granada)
        {
             munG = new MunicionGranada();
             addObject(munG,Greenfoot.getRandomNumber(700),500);
             contGranada=0;
        }
        
        //cargar el primer escenario, enemigos, obstaculos y jugador
        //llamar a un metodo de la clase Jugador que retorne en numero de vidas
        //llamar a un metodo de la clase Enemigo que retorne el numero de enemigos
        
            tercerNivel();
    }
    
    public void tercerNivel()
    {
        int vidas=0;
        int numEnemigos=0;
        int siguienteNivel = 0;
        
        setBackground("Escenario3.jpg");
        
        if(timeVida > vida && contCicloVida > vida)
        {
            life = new Vida();
            addObject(life,Greenfoot.getRandomNumber(700),500);
            contCicloVida=0;
        }
        
        if(timeEneA > 80 && contEneA < 5)
        {
            contEneA++;
            timeEneA=0;
            creaEnemigoAereo();
        }
        
        if(timeEneTe > 50 && contEneT < 5)
        {
            contEneT++;
            timeEneTe=0;
            creaEnemigoTerrestre();
        }
        
        if(timeCañon > Cañon && contCañon > Cañon && banC == 0)
        {
             can = new cañon();
             addObject(can,800,500);
             contCañon=0;
             banC=1;
        }
        
        if(timeRifle > rifle && contRifle > rifle && banR == 0)
        {
             rif = new Rifle();
             addObject(rif, Greenfoot.getRandomNumber(700),500);
             contRifle=0;
             banR=1;    
        }
        
        if(timeGranada > granada && contGranada > granada)
        {
             munG = new MunicionGranada();
             addObject(munG,500,500);
             contGranada=0;
        }
        
        if(timeMunicionPistola > munPistola && contPistola > munPistola)
        {
            munP = new MunicionPistola();
            addObject(munP,Greenfoot.getRandomNumber(700),500);
            contPistola = 0;
        }
        
        if(timeMunicionRifle > munRifle && contRifle > munRifle)
        {
            munR = new MunicionRifle();
            addObject(munR,Greenfoot.getRandomNumber(700),500);
            contRifle = 0;
        }
        
        if(timeMunicionCañon > munCañon && contCañon > munCañon)
        {
            munC = new MunicionCañon();
            addObject(munC,Greenfoot.getRandomNumber(700),500);
            contCañon = 0;
        }
        
        //cargar el primer escenario, enemigos, obstaculos y jugador
        //llamar a un metodo de la clase Jugador que retorne en numero de vidas
        //llamar a un metodo de la clase Enemigo que retorne el numero de enemigos
        
        //if(vidas>0 && numEnemigos==0)
            //mensaje de ganaste y borrar todo
    }
    
    public void creaEnemigoTerrestre()
    {
            eneT=new EnemigoTerrestre();
            addObject(eneT,790,500);   
    }
    
    public void creaEnemigoAereo()
    {
            eneA=new EnemigoAereo();
            addObject(eneA,790,200);   
    }
    
}
