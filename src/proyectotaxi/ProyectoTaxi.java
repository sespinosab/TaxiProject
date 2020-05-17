/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectotaxi;
import java.awt.Container;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
/**
 *
 * @author User
 */
public class ProyectoTaxi extends JFrame{

    Tablero T;
    public ProyectoTaxi() {
        
        initUI();
        
        this.setVisible(true);
    }


    private void initUI() {
        T=new Tablero();
        
        add(T);
        setSize(750, 600);
        setTitle("CrazyTaxi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    

    
}
