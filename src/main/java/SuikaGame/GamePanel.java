package SuikaGame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    public static final int ANCHO = 1280;
    public static final int ALTO = 720;
    final int FPS = 60;
    Thread hiloJuego;
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(ANCHO, ALTO));
        this.setBackground(new Color(213, 137, 54));
        this.setLayout(null);
    }
    
    public void iniciarJuego() {
        hiloJuego = new Thread();
        hiloJuego.start();
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
