/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaxi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Edificio {
    public ArrayList<Integer> coorXini;
    public ArrayList<Integer> coorYini;
    public ArrayList<Integer> coorXfin;
    public ArrayList<Integer> coorYfin;

    public Edificio() {
        this.coorXfin= new ArrayList<>();
        this.coorYfin= new ArrayList<>();
        this.coorXini= new ArrayList<>();
        this.coorYini= new ArrayList<>();
    }
    
    
        public void CoordenadaXini(String nombre){
        File tray= new File("Edificios/" + nombre + ".txt");
        if (tray.exists()){
            try{
                Scanner lectura =new Scanner(tray);
                while(lectura.hasNextInt()){
                    int i=lectura.nextInt();
                    coorXini.add(i);
                    coorXini.add(i);
                    coorXini.add(i);
                }
                
            }catch(FileNotFoundException ex){
                
            }
        }
        
    }
        public void CoordenadaYini(String nombre){
        File tray= new File("Edificios/" + nombre + ".txt");
        if (tray.exists()){
            try{
                Scanner lectura =new Scanner(tray);
                while(lectura.hasNextInt()){
                    int i=lectura.nextInt();
                    coorYini.add(i);
                    coorYini.add(i);
                    coorYini.add(i);
                }
                
            }catch(FileNotFoundException ex){
                
            }
        }
        
    }
        public void CoordenadaXfin(String nombre){
        File tray= new File("Edificios/" + nombre + ".txt");
        if (tray.exists()){
            try{
                Scanner lectura =new Scanner(tray);
                while(lectura.hasNextInt()){
                    int a= lectura.nextInt();
                    coorXfin.add(a);
                    coorXfin.add(a);
                    coorXfin.add(a);
                }
                
            }catch(FileNotFoundException ex){
                
            }
        }
        
    }
        public void CoordenadaYfin(String nombre){
        File tray= new File("Edificios/" + nombre + ".txt");
        if (tray.exists()){
            try{
                Scanner lectura =new Scanner(tray);
                while(lectura.hasNextInt()){
                    int i=lectura.nextInt();
                    coorYfin.add(i);
                    coorYfin.add(i);
                    coorYfin.add(i);
                }
                
            }catch(FileNotFoundException ex){
                
            }
        }
        
    }


}
