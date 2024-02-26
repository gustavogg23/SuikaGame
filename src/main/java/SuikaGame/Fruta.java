package SuikaGame;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Fruta {
    // Atributos
    public int posX;
    public int posY;
    public static int diametro = 30;
    private BufferedImage imagen; 
    public int contadorCaida = 0;
    public boolean colisionIzquierda;
    public boolean colisionDerecha;
    public boolean colisionFondo;
    public boolean frutaActiva;

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

    // Método para actualizar la posición y movimiento de la fruta
    public void actualizar() {
        // Actualizar la fruta aquí
        contadorCaida++;
        
        comprobarColision();
        
        // Mover la fruta
        if (Controles.botonIzquierda) {
            if (colisionIzquierda == false) {
                posX -= diametro;               
            }
            Controles.botonIzquierda = false;
        }
        if (Controles.botonDerecha) {
            if (colisionDerecha == false) {
                posX += diametro;               
            }
            Controles.botonDerecha = false;
        }
        
        if (colisionFondo) {
            frutaActiva = false;
        }
        else {
            
            if (contadorCaida == ManagerJuego.caidaFruta) {
                if (colisionFondo == false) {
                    posY += diametro;
                    contadorCaida = 0;
                }
            }
        }        
    }
    
    public void comprobarColision() {
        // Se establecen las variables de colisión en false
        colisionDerecha = false;
        colisionIzquierda = false;
        colisionFondo = false;
        
        // Se verifican las colisiones con el contenedor
        
        // Lado Izquierdo
        if (posX < ManagerJuego.xIzquierda) {
            colisionIzquierda = true;
        }
        // Lado Derecho
        if (posX + diametro > ManagerJuego.xDerecha) {
            colisionDerecha = true;
        }
        // Fondo 
        if (posY > ManagerJuego.yAbajo) {
            colisionFondo = true;
        }
    }

    public void dibujarFruta(Graphics2D graficos2) {
    // Creamos una nueva imagen que será un círculo perfecto del tamaño correcto
    BufferedImage imagenCircular = new BufferedImage(diametro, diametro, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = imagenCircular.createGraphics();

    // Dibujamos la imagen de la fruta dentro del círculo
    g.setClip(new Ellipse2D.Float(0, 0, diametro, diametro));
    g.drawImage(this.imagen, 0, 0, diametro, diametro, null);
    g.dispose();

    // Dibujamos la imagen circular en el círculo
    graficos2.drawImage(imagenCircular, posX, posY, null);
}

}

