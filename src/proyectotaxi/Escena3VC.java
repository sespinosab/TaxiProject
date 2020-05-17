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
public class Escena3VC {
     private Modelo modelo;
    private Escena3 escena3;

    public Escena3VC(Modelo modelo) {
        this.modelo = modelo;
      this.escena3 = new Escena3();
       
      // Eventhandler registrieren
      escena3.getJugardenuevo().setOnAction(new JugarEventHandler());
      escena3.getInicio().setOnAction(new InicioEventHandler());
      
    }
    class JugarEventHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            
            //Manda a otro controlador
            
          ProyectoTaxi proyT= new ProyectoTaxi();
          escena3.ac.stop();
        }
        
        
    }
    class InicioEventHandler implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent t) {
            
            //Manda a otro controlador
            escena3.ac.stop();
          Escena1VC E1VC= new Escena1VC(modelo);
          E1VC.show();
        }
        
        
    }
    public void show(){
      escena3.show(modelo.getPrimaryStage());
   }
}
