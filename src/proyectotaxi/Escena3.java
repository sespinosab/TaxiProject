/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaxi;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Escena3 {
    AudioClip ac;
   private Scene scene;
    
   private GridPane grid;
   private Text scenetitle;
    
   private Label name1;
    
   private Label name2;
   private Label name3;
   private Text messageT;

   private Button Jugardenuevo; 
   private Button inicio;
   private URL url;
   public Escena3(){
       try {
            url = new URL("file:EndGame.wav");
                 ac= Applet.newAudioClip(url);
                 ac.loop();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
             }
      grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(25, 25, 25, 25));
 
      // Ueberschrift
      scenetitle = new Text("Juego Terminado");
      scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
      grid.add(scenetitle, 4, 0, 6, 2);
 
      // Vorname    
      File tray= new File("Puntaje.txt");
        if (tray.exists()){
            try{
                Scanner lectura =new Scanner(tray);
                    int i=lectura.nextInt();
                    name2 = new Label("Tu puntaje es: " + i);
                    grid.add(name2, 4,2);
                    int j= lectura.nextInt();
                    name3 = new Label("El puntaje más alto es: " + j);
                    grid.add(name3, 5,2);
            }catch(FileNotFoundException ex){
                
            }
        }
      
      
      Jugardenuevo = new Button("Jugar de nuevo");
      grid.add(Jugardenuevo,4,3);
      inicio = new Button("Inicio");
      grid.add(inicio,5,3);
      scene = new Scene(grid, 750, 600);
    }
    public void show(Stage stage) {
      stage.setTitle("CrazyTaxi");
      stage.setScene(scene);
      stage.show();
      
      
      
      
      
      
   }

    public Button getJugardenuevo() {
        return Jugardenuevo;
    }

    public Button getInicio() {
        return inicio;
    }

}
