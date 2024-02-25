package SuikaGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    public static final int ANCHO = 1280;
    public static final int ALTO = 720;
    final int FPS = 60;
    Thread hiloJuego;
    ManagerJuego managerJuego;
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(ANCHO, ALTO));
        this.setBackground(new Color(213, 137, 54));
        this.setLayout(null);
        
        managerJuego = new ManagerJuego();
    }
    
    public void iniciarJuego() {
        hiloJuego = new Thread();
        hiloJuego.start();
    }

    @Override
    public void run() {
        
        double intervalo = 1000000000/FPS;
        double delta = 0;
        long tiempoPrevio = System.nanoTime();
        long tiempoActual;
        
        while (hiloJuego != null) {
            
            tiempoActual = System.nanoTime();
            
            delta += (tiempoActual - tiempoPrevio) / intervalo;
            tiempoPrevio = tiempoActual;
            
            if (delta >= 1) {
                actualizar();
                repaint();
                delta--;
            }
        }
    }
    
    public void actualizar() {
        managerJuego.actualizar();
    }
    
    @Override
    public void paintComponent(Graphics graficos) {
        super.paintComponents(graficos);
        
        Graphics2D graficos2 = (Graphics2D)graficos;
        managerJuego.dibujar(graficos2);
    }
}
