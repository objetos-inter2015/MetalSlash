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
    Jugador player;
    Vida life,life2 = new Vida();
    Granada G;
    Rifle rif;
    cañon can;
    Granada gran;
    
    ScoreBoard rec;
    
    Jugar play = new Jugar();
    Ayuda help;
    Records record;
    BotonVolver buttom;
    Creditos cred ;
    
    MunicionPistola munP;
    MunicionRifle munR;
    MunicionCañon munC;
    MunicionGranada munG;
    
    BalaPistola balaP=new BalaPistola();
    BalaRifle balaR;
    BalaCañon balaC;
    
    EnemigoTerrestre eneT;
    EnemigoAereo eneA;
    EnemigoFinal1 eneF;
    EnemigoFinal2 eneF2;
   
    int vidaJugador=10;
    
    int timeEneTe,timeEneA;
    int timeGranada,timeCañon,timeRifle,timeMunicionPistola;
    int timeMunicionCañon, timeMunicionRifle,timeMunGranada;
    int granada,Cañon,rifle,munPistola,munCañon,munRifle,vida;
    int contEneT,contEneA,contCicloVida;
    int tiempoAparicionEne;
    int timeVida;
    int banC=0,banR=0,ban=0,ban1,ban2,ban3,banJug=0,banG=0,banEneF=0,banEneF2=0,iniciaJuego;
    int munGranada;
    int mGranada;
    
    int volver=0;
    int nuevaPos=0;
    
    int contPistola,contCañon,contGranada,contRifle,contMunGranada;
    int jugar=0,jugar1=0;
    List<Actor> listaActor = new ArrayList<Actor>();
    List<Enemigos> listaEne = new ArrayList<Enemigos>();
    
    int entra=0,crea=0,nuevoBoton=0,tiempo=0,puntosJugador=0;
    public Niveles()
    {    
        super(1079, 603, 1);
        
        iniciaJuego=0;
        
        contMunGranada=0;
        contRifle=0;
        contGranada=0;
        contCicloVida=0;
        
        vida=800;
        
        timeEneA = 0;
        timeEneTe = 0;
        
        munGranada=400;
        granada=400;
        munPistola=500;
        rifle=100;
        munRifle=600;
        Cañon=100;
        munCañon=300;
        contPistola=0;
        contEneT=0;
        contEneA=0;
    }
    
    public void act()
    {
        timeVida = Greenfoot.getRandomNumber(1000);
        timeCañon = Greenfoot.getRandomNumber(1000);
        timeMunicionPistola = Greenfoot.getRandomNumber(800);
        timeMunicionCañon = Greenfoot.getRandomNumber(1000);
        timeMunicionRifle = Greenfoot.getRandomNumber(1000);
        timeRifle = Greenfoot.getRandomNumber(500);
        timeGranada = Greenfoot.getRandomNumber(500);
        tiempoAparicionEne = Greenfoot.getRandomNumber(2500);
        timeMunGranada=Greenfoot.getRandomNumber(500);
        
        timeEneTe=Greenfoot.getRandomNumber(500);
        timeEneA++;
        
        contCicloVida++;
        contCañon++;
        contRifle++;
        contPistola++;
        contGranada++;
        contMunGranada++;
        
        
            
        if(entra==0)
        {
            if(nuevoBoton==0)
            {
                play = new Jugar();
                nuevoBoton=1;
            }
            if(play.presiona()!=1)
            {
                   if(crea==0)
                   {
                       setBackground("menuP.jpg");
                       help = new Ayuda();
                       record = new Records();
                       buttom = new BotonVolver();
                       cred = new Creditos();
                       addObject(cred,100,500);
                       addObject(record,300,100);
                       addObject(play,100,100);
                       addObject(help,100,300);
                       crea=1;
                    }
                    if(buttom.presiona()==1 )
                    {
                        listaActor=getObjects(Actor.class);
                        removeObjects(listaActor);
                        setBackground("menuP.jpg");
                        play = new Jugar();
                        help = new Ayuda();
                        record = new Records();
                        cred = new Creditos();
                        buttom = new BotonVolver();
                        addObject(cred,100,500);
                        addObject(record,300,100);
                       addObject(play,100,100);
                       addObject(help,100,300);
                   }
                   if(cred.presiona()==1)
                   {
                       listaActor=getObjects(Actor.class);
                       removeObjects(listaActor);
                       setBackground("CREDITOS.png");
                       addObject(buttom,50,565);
                   }
                   if(help.presiona()==1)
                   {
                       listaActor=getObjects(Actor.class);
                       removeObjects(listaActor);
                       setBackground("Ayuda.png");
                       addObject(buttom,50,565);
                   }
                   if(record.presiona()==1)
                   {
                       listaActor=getObjects(Actor.class);
                       removeObjects(listaActor);
                       setBackground("menuRecords.jpg");
                       addObject(buttom,50,565);
                       addObject(new ScoreBoard(1070,400),getWidth()/2,getHeight()/2);                 
                   }
                }
                else 
                {
                    entra=1;
                    jugar=0;
                    ban1=0;
                    ban2=0;
                    ban3=0;
                    banJug=0;
                    tiempo=0;
                    banEneF2=0;
                    banEneF=0;
                    banR=0;
                    banC=0;
                }
        }
        else
        {
            if(jugar==0)
            {
                listaActor=getObjects(Actor.class);
                removeObjects(listaActor);
                jugar=1;
            }
            if(ban1==0)
                primerNivel();
            else
                if(ban2==0)
                    segundoNivel();
                else
                    if(ban3==0)
                       tercerNivel();
                    else
                    {
                        setBackground("misioncompletada.png");
                        if(buttom.presiona()==1 )
                        {
                               listaActor=getObjects(Actor.class);
                               removeObjects(listaActor);
                          }
                        listaActor=getObjects(Actor.class);
                        removeObjects(listaActor);
                    }
        }
        tiempo++;
    }
    
   
    public void primerNivel()
    {
        
        setBackground("Escenario1.jpg");
        if(banJug==0)
        {
            player =  new Jugador();
            addObject(player,100,500); 
            banJug=1;
        }
        
        if(timeEneTe > 50 && timeEneTe <60 && contEneT < 45)
        {
            contEneT++;
            timeEneTe=0;
            eneT=new EnemigoTerrestre();
            addObject(eneT,1000,500);   
        }
        
        if(timeGranada > granada && contGranada > granada && banG == 0)
        {
             munG = new MunicionGranada();
             addObject(munG,Greenfoot.getRandomNumber(700),500);
             contGranada=0;
             banG=1;
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
        showText(String.valueOf(player.puntuacion + puntosJugador),100,80);
        if(player.contVidas<=0)
        {
            listaActor=getObjects(Actor.class);
            removeObjects(listaActor);
            showText("                         ",100,50);
            showText("                         ",280,20);
            showText("                         ",200,20);
            showText("                         ",200,50);
            showText("                         ",100,80);
            showText("                         ",100,20);
            
            
            setBackground("misionincompleta.png");
            if(tiempo>=1000)
            {
                nuevoBoton=0;
                entra=0;
                crea=0;
                
                if (UserInfo.isStorageAvailable()) 
                {
                    UserInfo myInfo = UserInfo.getMyInfo();
                    if (player.puntuacion > myInfo.getScore()) 
                    {
                        myInfo.setScore(player.puntuacion + puntosJugador);
                        myInfo.setString(0, player.nombre);
                        myInfo.store();  // write back to server
                    }
                }
                puntosJugador=0;
                tiempo=0;
            }
        }
        else
            if(player.puntuacion>=100)
            {
                    if(tiempo>=1000)
                    {
                        puntosJugador += player.puntuacion;
                        listaEne=getObjects(Enemigos.class);
                        removeObjects(listaEne);
                        removeObject(player);
                        contEneT=0;
                        contEneA=0;
                        banJug=0;
                        ban1=1;
                        tiempo=0;
                    }
            }
                
    }
    
    public void segundoNivel()
    {
        setBackground("Escenario2.jpg");
        if(banJug==0)
        {
            player =  new Jugador();
            addObject(player,100,400); 
            banJug=1;
        }
        if(timeVida > vida && contCicloVida > vida)
        {
            life = new Vida();
            addObject(life,Greenfoot.getRandomNumber(700),400);
            contCicloVida=0;
        }
        
        if(timeEneTe > 50 && timeEneTe < 58 && contEneT < 15)
        {
            contEneT++;
            timeEneTe=0;
            creaEnemigoTerrestre();
        }
        if(timeEneA > 80 && contEneA < 15)
        {
            contEneA++;
            timeEneA=0;
            creaEnemigoAereo();
        }
        
        if(timeRifle > rifle && contRifle > rifle && banR == 0)
        {
             rif = new Rifle();
             addObject(rif, Greenfoot.getRandomNumber(700),400);
             contRifle=0;
             banR=1;    
        }
        
        if(timeGranada > granada && contGranada > granada && banG == 0)
        {
             G = new Granada();
             addObject(G,500,400);
             banG=1;
        }
        
        if(timeMunicionPistola > munPistola && contPistola > munPistola)
        {
            munP = new MunicionPistola();
            addObject(munP,Greenfoot.getRandomNumber(700),400);
            contPistola = 0;
        }
        
        if(timeMunicionRifle > munRifle && contRifle > munRifle)
        {
            munR = new MunicionRifle();
            addObject(munR,Greenfoot.getRandomNumber(700),400);
            contRifle = 0;
        }
        
        if((puntosJugador + player.puntuacion)>=650 && banEneF==0)
        {
            eneF= new EnemigoFinal1();
            addObject(eneF,800,300);
            banEneF=1;
        }
                showText(String.valueOf(player.puntuacion + puntosJugador),100,80);
        if(player.contVidas<=0)
        {
            listaActor=getObjects(Actor.class);
            removeObjects(listaActor);
            showText("                         ",100,50);
            showText("                         ",280,20);
            showText("                         ",200,20);
            showText("                         ",200,50);
            showText("                         ",100,80);
            showText("                         ",100,20);
            
            setBackground("misionincompleta.png");
            if(tiempo>=1500)
            {
                puntosJugador+=player.puntuacion;
                iniciaJuego=0;
                nuevoBoton=0;
                entra=0;
                crea=0;
                
                if (UserInfo.isStorageAvailable()) 
                {
                    UserInfo myInfo = UserInfo.getMyInfo();
                    if (player.puntuacion > myInfo.getScore()) 
                    {
                        myInfo.setScore(puntosJugador);
                        myInfo.setString(0, player.nombre);
                        myInfo.store();  // write back to server
                    }
                }
                puntosJugador=0;
                tiempo=0;
            }
        }
        else
            if((puntosJugador + player.puntuacion)>=900 && eneF.bandera()==1)
            {
                if(tiempo>=1500)
                {
                    puntosJugador+=player.puntuacion;
                    listaEne=getObjects(Enemigos.class);
                    removeObjects(listaEne);
                    nuevaPos=0;
                    contEneT=0;
                    contEneA=0;
                    banJug=0;
                    ban2=1;
                    tiempo=0;
                }
            }       
            
    }
    
    public void tercerNivel()
    {
        int vidas=0;
        int numEnemigos=0;
        int siguienteNivel = 0;
        
        setBackground("Escenario3.jpg");
        if(banJug==0)
        {
            player.setLocation(100,500); 
            banJug=1;
        }
        
        if(timeVida > vida && contCicloVida > vida)
        {
            life = new Vida();
            addObject(life,Greenfoot.getRandomNumber(700),500);
            contCicloVida=0;
        }
        
        if(timeEneA > 80 && contEneA < 15)
        {
            contEneA++;
            timeEneA=0;
            creaEnemigoAereo();
        }
        
        if(timeEneTe > 50 && timeEneTe <100 && contEneT < 15)
        {
            contEneT++;
            timeEneTe=0;
            eneT=new EnemigoTerrestre();
            addObject(eneT,900,500);   
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
        
        if((player.puntuacion + puntosJugador)>1000 && banEneF2==0)
        {
            eneF2= new EnemigoFinal2();
            addObject(eneF2,800,400);
            banEneF2=1;
        }
        showText(String.valueOf(player.puntuacion + puntosJugador),100,80);
         if(player.contVidas<=0)
        {
            listaActor=getObjects(Actor.class);
            removeObjects(listaActor);
            showText("                         ",100,50);
                showText("                         ",280,20);
                showText("                         ",200,20);
                showText("                         ",200,50);
                showText("                         ",100,80);
                showText("                         ",100,20);
            setBackground("misionincompleta.png");
            if(tiempo>1500)
            {
                puntosJugador+=player.puntuacion;
                iniciaJuego=0;
                nuevoBoton=0;
                entra=0;
                crea=0;
                
            
                if (UserInfo.isStorageAvailable()) 
                {
                    UserInfo myInfo = UserInfo.getMyInfo();
                    if (player.puntuacion > myInfo.getScore()) 
                    {
                        myInfo.setScore(puntosJugador);
                        myInfo.setString(0, player.nombre);
                        myInfo.store();  // write back to server
                    }
                }
                puntosJugador=0;
                tiempo=0;
            }
        }
        else
            if((player.puntuacion + puntosJugador)>1000 && eneF2.bandera()==1)
            {
                listaActor=getObjects(Actor.class);
                removeObjects(listaActor);
                showText("                         ",100,50);
                    showText("                         ",280,20);
                    showText("                         ",200,20);
                    showText("                         ",200,50);
                    showText("                         ",100,80);
                    showText("                         ",100,20);
                setBackground("misioncompletada.png");
                
                if(tiempo>1500)
                {
                    puntosJugador+=player.puntuacion;
                    iniciaJuego=0;
                    ban3=1;
                    nuevoBoton=0;
                    entra=0;
                    crea=0;
                    contEneA=0;
                    contEneT=0;
            
                    if (UserInfo.isStorageAvailable()) 
                    {
                        UserInfo myInfo = UserInfo.getMyInfo();
                        if (player.puntuacion > myInfo.getScore()) 
                        {
                            myInfo.setScore(puntosJugador);
                            myInfo.setString(0, player.nombre);
                            myInfo.store();  // write back to server
                        }
                    }
                    puntosJugador=0;
                }
            }
       
    }
    
    public void creaEnemigoTerrestre()
    {
            eneT=new EnemigoTerrestre();
            addObject(eneT,900,400);   
    }
    
    public void creaEnemigoAereo()
    {
            eneA=new EnemigoAereo();
            addObject(eneA,950,100);   
    }
    
}
