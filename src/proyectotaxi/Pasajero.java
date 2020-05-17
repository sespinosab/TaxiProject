/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaxi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

/**
 *
 * @author User
 */
public class Pasajero {
    public Timer timer;
    int Sprite;
    public ArrayList<Integer> posicionX;
    public ArrayList<Integer> posicionY;
    public ArrayList<Integer> DireccionX;
    public ArrayList<Integer> DireccionY;
    public ArrayList<Integer> Mirar;

    public Pasajero() {
        this.timer = new Timer();
        this.posicionX = new ArrayList<>();
        this.posicionY = new ArrayList<>();
        this.DireccionX =new ArrayList<>();
        this.DireccionY = new ArrayList<>();
        this.Mirar = new ArrayList<>();
    }
    
    
    
    
    public void posicionXini(String nombre){
        File pos= new File("Pasajeros/" + nombre + ".txt");
        if (pos.exists()){
            try{
                Scanner lectura = new Scanner(pos);
                while (lectura.hasNextInt()){
                    posicionX.add(lectura.nextInt());
                }
            }catch(FileNotFoundException ex){
                
            }
        }
    }
    
    public void posicionYini(String nombre){
        File pos= new File("Pasajeros/" + nombre + ".txt");
        if (pos.exists()){
            try{
                Scanner lectura = new Scanner(pos);
                while (lectura.hasNextInt()){
                    posicionY.add(lectura.nextInt());
                }
            }catch(FileNotFoundException ex){
                
            }
        }
    }
    
    public void posicionXfin(String nombre){
        File pos= new File("Pasajeros/" + nombre + ".txt");
        if (pos.exists()){
            try{
                Scanner lectura = new Scanner(pos);
                while (lectura.hasNextInt()){
                    DireccionX.add(lectura.nextInt());
                }
            }catch(FileNotFoundException ex){
                
            }
        }
    }
    
    public void posicionYfin(String nombre){
        File pos= new File("Pasajeros/" + nombre + ".txt");
        if (pos.exists()){
            try{
                Scanner lectura = new Scanner(pos);
                while (lectura.hasNextInt()){
                    DireccionY.add(lectura.nextInt());
                }
            }catch(FileNotFoundException ex){
                
            }
        }
    }
    
    public void Direccion(){
        int[] coordenadas={3,2,1,4,3,1,3,3,3,2,4,3,4,1,4,3,4,3,4,2,2,3,4,1,1,2,4,2,3,4,4,1,1,2,1,1,3,4,1,2,2,2,2,1,2,4,4,1,4,1,1,3,4,2,4,3,3};
        for(int a=0; a<57; a++){
            Mirar.add(coordenadas[a]);
        }
    }
    
    
    public int pedir_taxi(int x1, int y1){
        int dif= 100000;
        int resultado=0;
        x1=x1*2;
        y1=y1*2;
        x1+=375;
        y1+=300;
        for (int i=0; i<=posicionX.size()-1;i++){
            int diferenciax;
            int diferenciay;
            if(posicionX.get(i)<x1){
                diferenciax=x1-posicionX.get(i);
            }
            else
                diferenciax=posicionX.get(i)-x1;
            if(this.posicionY.get(i)<y1){
                diferenciay=y1-posicionY.get(i);
            }
            else
                diferenciay=posicionY.get(i)-y1;

            int diferencia=diferenciax+diferenciay;
            if(diferencia<=dif){
                dif=diferencia;
                resultado=i;
            }        
        }
        
        return resultado;
    }
    
    public int  Destino(){
//        Random r = new Random();
        int i=(int) (Math.random() * this.DireccionX.size());
        return i;
    }
    
    public int dinero(int tiempo,int x, int y, int index){
        int diferenciax;
            int diferenciay;
            x+=375;
            y+=300;
            if(posicionX.get(index)<x){
                diferenciax=x-posicionX.get(index);
            }
            else
                diferenciax=posicionX.get(index)-x;
            if(this.posicionY.get(index)<y){
                diferenciay=y-posicionY.get(index);
            }
            else
                diferenciay=posicionY.get(index)-y;

            int distT=diferenciax+diferenciay;
            
            if(distT<0){
                distT=distT*-1;
            }
        int dinero=40;
        if(distT>3000){
            dinero=300;
        }
        else if(distT>1500){
            dinero=150;
        }
        else if(distT>1000){
            dinero=100;
        }
        else if(distT>500){
            dinero=50;
        }
        else
            dinero=40;
        
        
        dinero=dinero-tiempo;
        return dinero;
    }
}
