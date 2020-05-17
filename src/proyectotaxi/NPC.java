package proyectotaxi;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SergioCamilo
 */
public class  NPC {
    private int Sprite;
    private int avatar;
    private int x;
    private int y;
    private int x_inicial;
    private int y_inicial;
    private Rectangle rect;
     //Últimas dos cmabiar dependiendo de las dimensiones que tengan los carros
    
    ArrayList<Integer> trayectoria= new ArrayList<>();

    public NPC(int avatar, int x_inicial, int y_inicial) {
        this.x_inicial = x_inicial;
        this.y_inicial = y_inicial;
        this.x= x_inicial;
        this.y= y_inicial;
        this.avatar= avatar;
    }
    
    
    public void recibirtrayectoria(String nombre){
        File tray= new File("NPC/" + nombre + ".txt");
        if (tray.exists()){
            try{
                Scanner lectura =new Scanner(tray);
                while(lectura.hasNextInt()){
                    trayectoria.add(lectura.nextInt());
                }
                
            }catch(FileNotFoundException ex){
                
            }
        }
        
    }
    
    public void setRect(int x,int y){
        this.rect= new Rectangle(this.getX_inicial()-(2*x),this.getY_inicial()-(2*y),30,30);
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getX_inicial() {
        return x_inicial;
    }

    public int getY_inicial() {
        return y_inicial;
    }

    public Rectangle getRect() {
        return rect;
    }

    public int getAvatar() {
        return avatar;
    }

    public int getSprite() {
        return Sprite;
    }
    
    

    public void setX_inicial(int x_inicial) {
        this.x_inicial = x_inicial;
    }

    public void setY_inicial(int y_inicial) {
        this.y_inicial = y_inicial;
    }

    public void setSprite(int Sprite) {
        this.Sprite = Sprite;
    }
    
    
    public int trayectoriaPersonas(int tiempo){
        int numero=0;
        int paso=0;
        for(int a: this.trayectoria){
            if(numero==(tiempo%this.trayectoria.size())){
                paso=a;
                break;
            }
            else if(numero==(this.trayectoria.size()-1)){
                this.x_inicial= x;
                this.y_inicial= y;
            }
            numero++;
        }
        return paso;
    }
}
