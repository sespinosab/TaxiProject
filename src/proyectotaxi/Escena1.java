/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaxi;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Escena1 {

   private Scene scene;
    AudioClip ac;
   private GridPane grid;
   private Text scenetitle;
    
   private Label name1;
    
   private Label name2;
    
   private Text messageT;
   private ImageView im;
   private Button Jugar;  
   private URL url;
   public Escena1(){
     grid = new GridPane();
      grid.setAlignment(Pos.CENTER);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(25, 25, 25, 25));
      try {
            url = new URL("file:StartGame.wav");
                 ac = Applet.newAudioClip(url);
                 ac.loop();
             } catch (MalformedURLException ex) {
                 Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
             }
      // Ueberschrift
      scenetitle = new Text("Crazy Taxi");
      scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
      grid.add(scenetitle, 0, 0, 3, 2);
      
        FileInputStream input;
       try {
           input = new FileInputStream("Interfaz.png");
           javafx.scene.image.Image image = new javafx.scene.image.Image(input);
            Label label3 = new Label(" ",new ImageView(image));
        
            grid.add(label3, 4, 0,7,7);
           
       } catch (FileNotFoundException ex) {
           
       }
        
      
      
      
      name1 = new Label("Sergio Camilo Espinoza Botero");
      grid.add(name1, 0, 2, 2, 2);

      name2 = new Label("Berny Alejandro Orozco Córdoba");
      grid.add(name2, 0, 3, 2, 3);
      
      Jugar = new Button("Jugar");
      grid.add(Jugar,0,5,2,5);
      
      scene = new Scene(grid, 750, 600);
    }
    public void show(Stage stage) {
      stage.setTitle("CrazyTaxi");
      stage.setScene(scene);
      stage.show();
      
      
      
      
      
      
   }
    public Button getJugar() {
      return Jugar;
   }
 
}
