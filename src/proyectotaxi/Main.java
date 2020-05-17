/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaxi;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }
      
    @Override
    public void start(Stage primaryStage) {
        
        // ambito de sesión / ámbito de aplicación ¡inicializar beans!
        // necesita ser pasado el controlador de la aplicacion
       Modelo m = new Modelo(primaryStage);
        
 
       // LLamar el primer controlador
       Escena1VC e1VC = new Escena1VC(m);
       e1VC.show();      
    }
}
