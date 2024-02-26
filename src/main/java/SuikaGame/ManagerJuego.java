package SuikaGame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class ManagerJuego {
    
    // Atributos del contenedor de juego
    final int ANCHO = 360;
    final int ALTO = 600;
    public static int xIzquierda;
    public static int xDerecha;
    public static int yArriba;
    public static int yAbajo;
    
    Lista frutas = new Lista(); // Se crea la lista de frutas que se dejarán caer
    
    Fruta datil = new Fruta(ALTO, ALTO, 10, 2, "C:\\Users\\gusta\\Imágenes\\Sprites\\datil.png");
    Fruta cotoperi = new Fruta(ALTO, ALTO, 15, 3, "C:\\Users\\gusta\\Imágenes\\Sprites\\cotoperi.png");
    Fruta mamey = new Fruta(ALTO, ALTO, 18, 4, "C:\\Users\\gusta\\Imágenes\\Sprites\\mamey.png");
    Fruta cereza = new Fruta(ALTO, ALTO, 20, 5, "C:\\Users\\gusta\\Imágenes\\Sprites\\cereza.png");
    Fruta pumalaca = new Fruta(ALTO, ALTO, 23, 6, "C:\\Users\\gusta\\Imágenes\\Sprites\\pumalaca.png");  
    Fruta[] grupoFrutas = {datil, cotoperi, mamey, cereza, pumalaca};
    
    Random random = new Random();
    
    public ManagerJuego() {
        
        // Se dibuja el contenedor de las frutas
        xIzquierda = (GamePanel.ANCHO / 2) - (ANCHO / 2);
        xDerecha = xIzquierda + ANCHO;
        yArriba = 50;
        yAbajo = yArriba + ALTO;
    }
    
    public void actualizar() {
        
        // Si no hay una fruta cayendo, se crea una nueva fruta
        if (frutas.estaVacia()) {
            int indice = random.nextInt(grupoFrutas.length); // Se elige una fruta al azar
            Fruta frutaCaer = grupoFrutas[indice];
            
            // Se crea una nueva fruta y se agrega a lista
            Fruta nuevaFruta = new Fruta(frutaCaer.getPosX(), frutaCaer.getPosY(), frutaCaer.getDiametro(), frutaCaer.getVelCaida(), frutaCaer.getRuta());
            frutas.agregar(nuevaFruta);
        }
        
        // Se actualiza la posición de la fruta que está cayendo
        Fruta frutaCayendo = frutas.getCabeza().getValor();
        frutaCayendo.actualizarPos();
        
        // Si la fruta está en el fonod del contenedor se elimina de la lista
        if (frutaCayendo.getPosY() + frutaCayendo.getDiametro() >= ManagerJuego.yAbajo) {
            frutas.eliminar(frutaCayendo);
        }
    }
    
    public void dibujar(Graphics2D graficos2) {
        // Dibujar contenedor
        graficos2.setColor(Color.yellow);
        graficos2.setStroke(new BasicStroke(4f));
        graficos2.drawRect(xIzquierda - 4, yArriba - 4, ANCHO + 8, ALTO + 8);
        
        // Dibujar cuadrado para mostrar la siguiente fruta a caer
        int x = xIzquierda - 200;
        int y = yArriba + 50;
        graficos2.drawRect(x, y, 100, 100);
    }
}
