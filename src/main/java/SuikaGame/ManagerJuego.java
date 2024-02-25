package SuikaGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class ManagerJuego {
    final int ANCHO = 360;
    final int ALTO = 600;
    public static int xIzquierda;
    public static int xDerecha;
    public static int yArriba;
    public static int yAbajo;
    
    public ManagerJuego() {
        
        // Se dibuja el contenedor de las frutas
        xIzquierda = (GamePanel.ANCHO / 2) - (ANCHO / 2);
        xDerecha = xIzquierda + ANCHO;
        yArriba = 50;
        yAbajo = yArriba + ALTO;
    }
    
    public void actualizar() {
        
    }
    
    public void dibujar(Graphics2D graficos2) {
        // Dibujar contenedor
        graficos2.setColor(Color.yellow);
        graficos2.setStroke(new BasicStroke(4f));
        graficos2.drawRect(xIzquierda - 4, yArriba - 4, ANCHO + 8, ALTO + 8);
    }
}
