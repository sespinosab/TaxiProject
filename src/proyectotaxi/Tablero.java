/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaxi;

/**
 *
 * @author User
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Estudiante
 * Jpanel dado que voy a pintar en el Canvas
 * ActionListener: Para poder ejecutar el escenario cada ciertos milisegundos
 */
public class Tablero extends JPanel implements ActionListener,KeyListener{
    private Timer timer ;
    int tiempo;
    int cronometro;
    int x;
    int y;
    int x2;
    int y2;
    int Sprite;
    int horario;
    int horariov2;
    int minutero;
    int minuterov2;
    int cronometrofinal;
    int a;
    int b;
    URL url;
    URL url2;
    NPC persona[]= new NPC[36];
    NPC carros[]= new NPC[6];
    Edificio Izquierda= new Edificio();
    Edificio Derecha= new Edificio();
    Edificio Arriba= new Edificio();
    Edificio Abajo= new Edificio();
    Pasajero ps;
    int TurnoP;
    int contador;
    int dinero;
    int Sprite2;
    int variablecarros=-1;
    int variablepersonas=-1;
    boolean terminado;
    public Tablero(){
        //Lanza un evento de tipo ActionListener cada 25 Milisegundo
        //Se hace referencia a this porque la misma clase (Tablero) procesa el evento
        this.timer = new Timer(50, this);//timer en 50
        this.x= 0;
        this.y= 0;
        this.x2=0;
        this.y2=0;
        this.terminado=false;
        this.cronometrofinal=0;
        this.ps= new Pasajero();
        this.ps.posicionXfin("XiniDIRECCION");
        this.ps.posicionXini("XiniPASAJERO");
        this.ps.posicionYfin("YiniDIRECCION");
        this.ps.posicionYini("YiniPASAJERO");
        this.ps.Direccion();
        this.TurnoP=0;
        this.contador=0;
        this.dinero=0;
        this.horario=0;
        this.horariov2=0;
        this.minutero= 0;
        this.minuterov2= 0;
        this.tiempo=0;
        this.Sprite=0;
        this.Izquierda.CoordenadaXfin("XfinIzq");
        this.Izquierda.CoordenadaXini("XiniIzq");
        this.Izquierda.CoordenadaYfin("YfinIzq");
        this.Izquierda.CoordenadaYini("YiniIzq");
        this.Derecha.CoordenadaXfin("XfinDer");
        this.Derecha.CoordenadaXini("XiniDer");
        this.Derecha.CoordenadaYfin("YfinDer");
        this.Derecha.CoordenadaYini("YiniDer");
        this.Arriba.CoordenadaXfin("XfinArri");
        this.Arriba.CoordenadaXini("XiniArri");
        this.Arriba.CoordenadaYfin("YfinArri");
        this.Arriba.CoordenadaYini("YiniArri");
        this.Abajo.CoordenadaXfin("XfinAba");
        this.Abajo.CoordenadaXini("XiniAba");
        this.Abajo.CoordenadaYfin("YfinAba");
        this.Abajo.CoordenadaYini("YiniAba");

        this.carros[0]= new NPC(0,440,700);
        this.carros[0].recibirtrayectoria("C-440-700");
        this.carros[1]= new NPC(1,900,860);
        this.carros[1].recibirtrayectoria("C-900-860");
        this.carros[2]= new NPC(2,1040,510);
        this.carros[2].recibirtrayectoria("C-1040-510");
        this.carros[3]= new NPC(3,1080,460);
        this.carros[3].recibirtrayectoria("C-1080-460");
        this.carros[4]= new NPC(1,1080,510);
        this.carros[4].recibirtrayectoria("C-1080-510");
        this.carros[5]= new NPC(2,1440,610);
        this.carros[5].recibirtrayectoria("C-1440-610");
        this.persona[0]=new NPC(1,40,40);
        this.persona[0].recibirtrayectoria("P-20-60");
        this.persona[1]=new NPC(2,50,940);
        this.persona[1].recibirtrayectoria("P-60-890");
        this.persona[2]=new NPC(3,140,1580);
        this.persona[2].recibirtrayectoria("P-140-1590");
        this.persona[3]=new NPC(4,150,700);
        this.persona[3].recibirtrayectoria("P-150-700");
        this.persona[4]=new NPC(5,140,1190);
        this.persona[4].recibirtrayectoria("P-160-1070");
        this.persona[5]=new NPC(6,150,1470);
        this.persona[5].recibirtrayectoria("P-160-1470");
        this.persona[6]=new NPC(7,220,320);
        this.persona[6].recibirtrayectoria("P-240-340");
        this.persona[7]=new NPC(8,240,1300);
        this.persona[7].recibirtrayectoria("P-240-1300");
        this.persona[8]=new NPC(0,440,300);
        this.persona[8].recibirtrayectoria("P-420-310");
        this.persona[9]=new NPC(1,400,470);
        this.persona[9].recibirtrayectoria("P-440-480");    
        this.persona[10]=new NPC(2,440,830);
        this.persona[10].recibirtrayectoria("P-440-850");
        this.persona[11]=new NPC(3,440,1120);
        this.persona[11].recibirtrayectoria("P-440-1220");
        this.persona[12]=new NPC(4,520,340);
        this.persona[12].recibirtrayectoria("P-530-340");
        this.persona[13]=new NPC(5,600,130);
        this.persona[13].recibirtrayectoria("P-600-130");
        this.persona[14]=new NPC(6,820,100);
        this.persona[14].recibirtrayectoria("P-820-130");
        this.persona[15]=new NPC(7,820,530);
        this.persona[15].recibirtrayectoria("P-820-540");
        this.persona[16]=new NPC(8,830,880);
        this.persona[16].recibirtrayectoria("P-840-900");   
        this.persona[17]=new NPC(0,840,1500);
        this.persona[17].recibirtrayectoria("P-840-1200");
        this.persona[18]=new NPC(1,890,1260);
        this.persona[18].recibirtrayectoria("P-890-1300");
        this.persona[19]=new NPC(2,1020,1000);
        this.persona[19].recibirtrayectoria("P-1040-1000");
        this.persona[20]=new NPC(3,1250,130);
        this.persona[20].recibirtrayectoria("P-1090-120");
        this.persona[21]=new NPC(4,1070,870);
        this.persona[21].recibirtrayectoria("P-1130-880");
        this.persona[22]=new NPC(5,800,1660);
        this.persona[22].recibirtrayectoria("P-1130-1680");
        this.persona[23]=new NPC(6,1180,1500);
        this.persona[23].recibirtrayectoria("P-1180-1520");
        this.persona[24]=new NPC(7,1120,350);
        this.persona[24].recibirtrayectoria("P-1220-380");
        this.persona[25]=new NPC(8,1280,1220);
        this.persona[25].recibirtrayectoria("P-1280-1220");
        this.persona[26]=new NPC(0,1330,410);
        this.persona[26].recibirtrayectoria("P-1340-500");
        this.persona[27]=new NPC(1,1350,890);
        this.persona[27].recibirtrayectoria("P-1360-870");
        this.persona[28]=new NPC(2,1370,1330);
        this.persona[28].recibirtrayectoria("P-1380-1220");
        this.persona[29]=new NPC(3,1470,1000);
        this.persona[29].recibirtrayectoria("P-1500-1010");
        this.persona[30]=new NPC(4,1540,930);
        this.persona[30].recibirtrayectoria("P-1550-960");
        this.persona[31]=new NPC(5,1640,840);
        this.persona[31].recibirtrayectoria("P-1560-870");
        this.persona[32]=new NPC(6,1570,670);
        this.persona[32].recibirtrayectoria("P-1570-670");
        this.persona[33]=new NPC(7,1600,330);
        this.persona[33].recibirtrayectoria("P-1600-350");
        this.persona[34]=new NPC(8,1600,1360);
        this.persona[34].recibirtrayectoria("P-1600-1160");
        this.persona[35]=new NPC(0,1610,120);
        this.persona[35].recibirtrayectoria("P-1610-120");
        //Registrar evento del Teclado
        setFocusable(true); //Debe estar en modo Focus para que puede detectar el evento
        addKeyListener(new EventosTeclado()); //Inner class que procesa los eventos del teclado
        this.timer.start(); //Inicio con el escenario
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {   
    }   

     @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       ImageIcon Fondo= new ImageIcon("Mapa.jpg");
       g.drawImage(Fondo.getImage(), 0, 0, 750, 600, 0+x, 0+y, 375+x, 300+y, this);
       
       Rectangle taxi= new Rectangle(375,300,40,40);
       //CODIGO PARA EL MOVIMIENTO DE LAS PERSONAS
      for(int a=0; a<36; a++){
           persona[a].setRect(x, y);
           Rectangle rect= persona[a].getRect();
           if(rect.intersects(taxi)){
               if(a!=variablepersonas){
               try {
                 url = new URL("file:GolpeP.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
             }
               variablepersonas=a;
               }
           }
       }
       for(NPC persona: persona){
           if(persona.trayectoriaPersonas(tiempo)==1){
               persona.setY_inicial(persona.getY_inicial()-5);
               if(persona.getSprite()==1){
                   persona.setSprite(2);
               }
               else
                   persona.setSprite(1);
           }
           if(persona.trayectoriaPersonas(tiempo)==3){
               persona.setX_inicial(persona.getX_inicial()+5);
               if(persona.getSprite()==3){
                   persona.setSprite(4);
               }
               else
                   persona.setSprite(3);
           }
           if(persona.trayectoriaPersonas(tiempo)==5){
               persona.setY_inicial(persona.getY_inicial()+5);
               if(persona.getSprite()==5){
                   persona.setSprite(6);
               }
               else
                   persona.setSprite(5);
           }
           if(persona.trayectoriaPersonas(tiempo)==7){
               persona.setX_inicial(persona.getX_inicial()-5);
               if(persona.getSprite()==7){
                   persona.setSprite(8);
               }
               else
                   persona.setSprite(7);
           }
           ImageIcon Persona= new ImageIcon("NPC_Personas.png");
           g.drawImage(Persona.getImage(), persona.getX_inicial()-(x*2), persona.getY_inicial()-(y*2), 40+persona.getX_inicial()-(x*2), 40+persona.getY_inicial()-(y*2), 0+((persona.getSprite()-1)*32), 0+(persona.getAvatar()*32), 32+((persona.getSprite()-1)*32), 32+(persona.getAvatar()*32), this);
       }
       
       for(int a=0; a<6; a++){
           carros[a].setRect(x, y);
           Rectangle rect= carros[a].getRect();
           if(rect.intersects(taxi)){
               if(a!=variablecarros){
               try {
                 url = new URL("file:GolpeV.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
             }
               variablecarros=a;
               }
           }
       }
       
       
       
       for(NPC carro: carros){
           if(carro.trayectoriaPersonas(tiempo)==1){
               carro.setY_inicial(carro.getY_inicial()-10);
                   carro.setSprite(1);
           }
           if(carro.trayectoriaPersonas(tiempo)==2){
               carro.setY_inicial(carro.getY_inicial()-10);
               carro.setX_inicial(carro.getX_inicial()+6);
                   carro.setSprite(2);
           }
           if(carro.trayectoriaPersonas(tiempo)==3){
               carro.setX_inicial(carro.getX_inicial()+10);
                   carro.setSprite(3);
           }
           if(carro.trayectoriaPersonas(tiempo)==4){
               carro.setY_inicial(carro.getY_inicial()-10);
               carro.setX_inicial(carro.getX_inicial()-6);
                   carro.setSprite(4);
           }
           
           if(carro.trayectoriaPersonas(tiempo)==5){
               carro.setY_inicial(carro.getY_inicial()+10);
                   carro.setSprite(5);
           }
           if(carro.trayectoriaPersonas(tiempo)==6){
               carro.setY_inicial(carro.getY_inicial()+10);
               carro.setX_inicial(carro.getX_inicial()-6);
                   carro.setSprite(6);
           }
           if(carro.trayectoriaPersonas(tiempo)==7){
               carro.setX_inicial(carro.getX_inicial()-10);
                   carro.setSprite(7);
           }
           if(carro.trayectoriaPersonas(tiempo)==8){
               carro.setY_inicial(carro.getY_inicial()+10);
               carro.setX_inicial(carro.getX_inicial()+6);
                   carro.setSprite(8);
           }
           if(carro.trayectoriaPersonas(tiempo)==9){
               carro.setY_inicial(carro.getY());
               carro.setX_inicial(carro.getX());
           }
           ImageIcon Persona= new ImageIcon("CARROS.png");
           g.drawImage(Persona.getImage(), carro.getX_inicial()-(x*2), carro.getY_inicial()-(y*2), 40+carro.getX_inicial()-(x*2), 40+carro.getY_inicial()-(y*2), 0+((carro.getSprite()-1)*88), 0+(carro.getAvatar()*85), 88+((carro.getSprite()-1)*88), 85+(carro.getAvatar()*85), this);
       }


       for(int a=0; a<Derecha.coorXini.size();a++){
           Rectangle rect2= new Rectangle(Derecha.coorXini.get(a)-(x*2), Derecha.coorYini.get(a)-(y*2), Derecha.coorXfin.get(a)-Derecha.coorXini.get(a), Derecha.coorYfin.get(a)-Derecha.coorYini.get(a));
           if(taxi.intersects(rect2)){
               System.out.println("CRASSH!");
               x+=5;
           }
       }
       for(int a=0; a<Izquierda.coorXini.size();a++){
           Rectangle rect3= new Rectangle(Izquierda.coorXini.get(a)-(x*2), Izquierda.coorYini.get(a)-(y*2), Izquierda.coorXfin.get(a)-Izquierda.coorXini.get(a), Izquierda.coorYfin.get(a)-Izquierda.coorYini.get(a));
           if(taxi.intersects(rect3)){
               System.out.println("CRASSH!");
               x-=5;
           }
       }
       for(int a=0; a<Arriba.coorXini.size();a++){
           Rectangle rect4= new Rectangle(Arriba.coorXini.get(a)-(x*2), Arriba.coorYini.get(a)-(y*2), Arriba.coorXfin.get(a)-Arriba.coorXini.get(a), Arriba.coorYfin.get(a)-Arriba.coorYini.get(a));
           if(taxi.intersects(rect4)){
               System.out.println("CRASSH!");
               y-=5;
           }
       }
       for(int a=0; a<Abajo.coorXini.size();a++){
           Rectangle rect5= new Rectangle(Abajo.coorXini.get(a)-(x*2), Abajo.coorYini.get(a)-(y*2), Abajo.coorXfin.get(a)-Abajo.coorXini.get(a), Abajo.coorYfin.get(a)-Abajo.coorYini.get(a));
           if(taxi.intersects(rect5)){
               y+=5;
           }
       }
       
       if(TurnoP==1){
           Sprite2= 0;
           cronometro=0;
           ImageIcon Persona= new ImageIcon("NPC_Clientes.png");
           Rectangle rect= new Rectangle(ps.posicionX.get(a)-(x*2), ps.posicionY.get(a)-(y*2), 35, 35);
           g.setColor(Color.YELLOW);
           g.fillRect(ps.posicionX.get(a)-(x*2), ps.posicionY.get(a)-(y*2), 35, 35);
           b=ps.Destino();
           g.drawImage(Persona.getImage(), ps.posicionX.get(a)-(x*2), ps.posicionY.get(a)-(y*2), 40+ps.posicionX.get(a)-(x*2), 40+ps.posicionY.get(a)-(y*2), 0+((ps.Mirar.get(a)-1)*30), 0+((Sprite2%9)*32), 30+((ps.Mirar.get(a)-1)*30), 32+((Sprite2%9)*32), this);
           if(taxi.intersects(rect)){
               TurnoP=2;
           }
       
           
           
       }
       else if(TurnoP==2){
           Sprite2 ++;
           //Codigo de imprimir direccion y flecha
           if(tiempo%50==0){
           cronometro++;
           }
           int DirX=ps.DireccionX.get(b);
           int DirY=ps.DireccionY.get(b);
           Rectangle rect= new Rectangle(DirX-(x*2), DirY-(y*2), 50, 50);
           g.setColor(Color.YELLOW);
           g.drawRect(DirX-(x*2), DirY-(y*2), 50, 50);
           
           
           ImageIcon Persona= new ImageIcon("mano.png");
           
           int variable=0;
           if(DirX<((2*x)+375)){//cuadro a la izquierda del taxi
               if(DirY<((2*y)+300)){
                   variable=3;
               }
               else if(DirY>((2*y)+300)){
                   variable=5;
               }
               else if(DirY==((2*y)+300)){
                   variable=6;
               }
               
           }
           else if(DirX>((2*x)+375)){
               if(DirY<((2*y)+300)){
                  variable=1; 
               }
               else if(DirY>((2*y)+300)){
                   variable=7;
               }
               else if(DirY==((2*y)+300)){
                   variable=2;
               }
           }
           else if(DirX==((2*x)+375)){
               if(DirY<((2*y)+300)){
                   variable=0;
               }
               else if(DirY>((2*y)+300)){
                   variable=4;
               }

           }
           g.drawImage(Persona.getImage(), 410, 270, 430, 300, 0+(variable*31), 0, 31+(variable*30), 34, this);

           if(taxi.intersects(rect)){
               dinero+=ps.dinero(cronometro, x, y, a);
               try {
                 url = new URL("file:GanarDinero.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
             }
               
               
               TurnoP=3;
           }
           
           
           
       }
       else if(TurnoP==3){
           a=ps.pedir_taxi(x, y);
           TurnoP=1;
       }
       if(terminado==false){
       
       //Codigo del dinero
       int car1=dinero%10;
       int car2=(dinero%100)-car1;
       int car3=(dinero%1000)-car2;
       int car4=(dinero%10000)-car3;
       int car5=(dinero%100000)-car4;
       ImageIcon Din= new ImageIcon("DINERO.png");
       g.drawImage(Din.getImage(), 700, 0, 730, 30, 0+((car1)*17), 0, 17+(car1*17), 26, this);
       g.drawImage(Din.getImage(), 670, 0, 700, 30, 0+((car2/10)*17), 0, 17+((car2/10)*17), 26, this);
       g.drawImage(Din.getImage(), 640, 0, 670, 30, 0+((car3/100)*17), 0, 17+((car3/100)*17), 26, this);
       g.drawImage(Din.getImage(), 610, 0, 640, 30, 0+((car4/1000)*17), 0, 17+((car4/1000)*17), 26, this);
       g.drawImage(Din.getImage(), 580, 0, 610, 30, 0+((car5/10000)*17), 0, 17+((car5/10000)*17), 26, this);
       ImageIcon Din2= new ImageIcon("DINEROv2.png");
       g.drawImage(Din2.getImage(), 550, 0, 580, 30, 0, 0, 37, 37, this);
       
       }
       else{    
          int car1=dinero%10;
        int car2=(dinero%100)-car1;
       int car3=(dinero%1000)-car2;
       int car4=(dinero%10000)-car3;
       int car5=(dinero%100000)-car4;
       ImageIcon Din= new ImageIcon("DINERO.png");
       g.drawImage(Din.getImage(), 450, 450, 500, 500, 0+((car1)*17), 0, 17+(car1*17), 26, this);
       g.drawImage(Din.getImage(), 400, 450, 450, 500, 0+((car2/10)*17), 0, 17+((car2/10)*17), 26, this);
       g.drawImage(Din.getImage(), 350, 450, 400, 500, 0+((car3/100)*17), 0, 17+((car3/100)*17), 26, this);
       g.drawImage(Din.getImage(), 300, 450, 350, 500, 0+((car4/1000)*17), 0, 17+((car4/1000)*17), 26, this);
       g.drawImage(Din.getImage(), 250, 450, 300, 500, 0+((car5/10000)*17), 0, 17+((car5/10000)*17), 26, this);
           
       ImageIcon Din3= new ImageIcon("puntuacion.png");
       g.drawImage(Din3.getImage(), 0, 0, 750, 600, this);    
           
           
           
           
       }
       
       
       
       

       ImageIcon TaxiSprite= new ImageIcon("TAXI.png");
       g.drawImage(TaxiSprite.getImage(), 375, 300, 425, 350, 0+(Sprite*88), 30, 88+(Sprite*88), 166, this);
       
       //Codigo de la hora:
       
       ImageIcon Hora= new ImageIcon("numeros.png");
       g.drawImage(Hora.getImage(), 0, 0, 25, 28, 0+27*(horariov2%24), 0, 24+27*(horariov2%24), 28, this);
       g.drawImage(Hora.getImage(), 25, 0, 50, 28, 0+27*(horario%10), 0, 24+27*(horario%10), 28, this);
       g.drawImage(Hora.getImage(), 50, 0, 75, 28, 0, 28, 25, 54, this);
       g.drawImage(Hora.getImage(), 75, 0, 100, 28, 0+27*(minuterov2%6), 0, 24+27*(minuterov2%6), 28, this);
       g.drawImage(Hora.getImage(), 100, 0, 125, 28, 0+27*(minutero%10), 0, 24+27*(minutero%10), 28, this);
       
       
        
    }
    private class EventosTeclado extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key=e.getKeyCode();
            if(tiempo>6){
           if (key == KeyEvent.VK_UP) {
            y-=5;
            Sprite=0;
           }
           if (key == KeyEvent.VK_DOWN) {
            y+=5;
            Sprite=4;
           }
           if (key == KeyEvent.VK_LEFT) {
            x-=5;
            Sprite=6;
           }
           if (key == KeyEvent.VK_RIGHT) {
            x+=5;
            Sprite=2;
           }
           if(key==KeyEvent.VK_ESCAPE){
               File tray= new File("Puntaje.txt");
        
            if (tray.exists()){
            try{
                Scanner lectura =new Scanner(tray);
                    int i=lectura.nextInt();
                    int j= lectura.nextInt();
                    try {
                    PrintStream A = new PrintStream(tray);
                    A.print(dinero);
                    A.print(" ");
                    if(j>dinero){
                        A.print(j);
                        A.print(" ");
                    }
                    else{
                        A.print(dinero);
                        A.print(" ");}
                    
                    
                    } catch (IOException ex) {} 
            }catch(FileNotFoundException ex){
                
            }
            
            
        }
            
          terminado=true;
          
           }  
           }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tiempo++;
        if(terminado==true){
            cronometrofinal++;
        }
        if(cronometrofinal==100){
            System.exit(1);
        }
        if(tiempo==2){
            try {
                 url = new URL("file:Llaves.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
                 
             } catch (MalformedURLException ex) {
             }
        }
        if(tiempo==1){
            try {
                 url = new URL("file:Ciudad.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
                 ac.play();
             } catch (MalformedURLException ex) {
             }
        }
        if(tiempo<7){
            y+=5;
            a=ps.pedir_taxi(x, y);
            TurnoP=1;
        }
        if(tiempo%5==0){
            minutero++;
        }
        if(tiempo%50==0){
            minuterov2++;
        }
        if(tiempo%300==0){
            horario++;
        }
        if(tiempo%3000==0){
            horariov2++;
        }
        if(tiempo%1280==0){
            try {
                 url2 = new URL("file:Ciudad.wav");
                 AudioClip ac = Applet.newAudioClip(url);
                 ac.play();
                 ac.play();
             } catch (MalformedURLException ex) {
             }
        }
        
        
        if(tiempo%7200==0){
        File tray= new File("Puntaje.txt");
        
            if (tray.exists()){
            try{
                Scanner lectura =new Scanner(tray);
                    int i=lectura.nextInt();
                    int j= lectura.nextInt();
                    try {
                    PrintStream A = new PrintStream(tray);
                    A.print(dinero);
                    A.print(" ");
                    if(j>dinero){
                        A.print(j);
                        A.print(" ");
                    }
                    else{
                        A.print(dinero);
                        A.print(" ");}
                    
                    
                    } catch (IOException ex) {} 
            }catch(FileNotFoundException ex){
                
            }
            
            
        }
            
          
          terminado=true;
        }
        repaint();
    }

    public int getDinero() {
        return dinero;
    }

    public boolean isTerminado() {
        return terminado;
    }
    
    
    
}
