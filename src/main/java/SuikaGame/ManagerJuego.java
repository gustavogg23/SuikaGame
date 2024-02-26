package SuikaGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class ManagerJuego {
    
    // Atributos del contenedor de juego
    final int ANCHO = 360;
    final int ALTO = 500;
    public static int xIzquierda;
    public static int xDerecha;
    public static int yArriba;
    public static int yAbajo;
  
    // Fruta
    Fruta fruta;
    final int posInicialX;
    final int posInicialY;
    
    public static int caidaFruta = 60; // Intervalo de caída de la fruta
    
    public ManagerJuego() {
        
        // Se dibuja el contenedor de las frutas
        xIzquierda = (GamePanel.ANCHO / 2) - (ANCHO / 2);
        xDerecha = xIzquierda + ANCHO;
        yArriba = 50;
        yAbajo = yArriba + ALTO;
        
        fruta = new Datil("C:\\Users\\gusta\\Imágenes\\Sprites\\datil.png");
        posInicialX = xIzquierda + (ANCHO / 2) - fruta.diametro; // La fruta se crea en la mitad del eje horizontal del contenedor
        posInicialY = yArriba + fruta.diametro; // Y en la parte superior del contenedor
        
        fruta.establecerPosicion(posInicialX, posInicialY);
    }
    
    public void actualizar() {
        fruta.actualizar();
    }
    
    public void dibujar(Graphics2D graficos2) {
        // Dibujar contenedor
        graficos2.setColor(Color.yellow);
        graficos2.setStroke(new BasicStroke(4f));
        graficos2.drawRect(xIzquierda - 4, yArriba + 40, ANCHO + 8, ALTO + 8);
        
        // Dibujar cuadrado para mostrar la siguiente fruta a caer
        int x = xIzquierda - 200;
        int y = yArriba + 50;
        graficos2.drawRect(x, y, 100, 100);
        
        // Se dibuja la fruta
        if (fruta != null) {
            fruta.dibujarFruta(graficos2);
        }
    }
}
