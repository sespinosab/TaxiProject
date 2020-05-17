/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaxi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author User
 */
public class Escena1VC {
    private Modelo modelo;
    private Escena1 escena1;

    public Escena1VC(Modelo modelo) {
        this.modelo = modelo;
      this.escena1 = new Escena1();
       
      // Eventhandler registrieren
      escena1.getJugar().setOnAction(new JugarEventHandler());
      
    }
        class JugarEventHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            
            //Manda a otro controlador
          escena1.ac.stop();  
          ProyectoTaxi proyT= new ProyectoTaxi();
          
        }
        
    }
    public void show(){
      escena1.show(modelo.getPrimaryStage());
   }
    
    
}
