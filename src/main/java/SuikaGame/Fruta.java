package SuikaGame;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Fruta {
    // Atributos
    public int posX;
    public int posY;
    public static int diametro = 40;
    private BufferedImage imagen; 
    public int contadorCaida = 0;

    public Fruta(String rutaImagen) {
        try {
            this.imagen = ImageIO.read(new File(rutaImagen));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void establecerPosicion(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public void actualizarPosicion(int posicion) {
        // Actualizar la posición de la fruta aquí
    }

    public void actualizar() {
        // Actualizar la fruta aquí
        contadorCaida++;
        
        // Mover la fruta
        if (Controles.botonIzquierda) {
            posX -= diametro;
            Controles.botonIzquierda = false;
        }
        if (Controles.botonDerecha) {
            posX += diametro;
            Controles.botonDerecha = false;
        }
        
        if (contadorCaida == ManagerJuego.caidaFruta){
           posY += diametro;
           contadorCaida = 0;
        }
    }

    public void dibujarFruta(Graphics2D graficos2) {
        // Redimensionamos la imagen al tamaño del círculo
        Image imagenEscalada = this.imagen.getScaledInstance(diametro, diametro, Image.SCALE_SMOOTH);

        // Dibujamos la imagen en el círculo
        graficos2.drawImage(imagenEscalada, posX, posY, null);
    }
}

