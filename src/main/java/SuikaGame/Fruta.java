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
        // Redimensionamos la imagen al tamaño del círculo
        Image imagenEscalada = this.imagen.getScaledInstance(diametro, diametro, Image.SCALE_SMOOTH);

        // Dibujamos la imagen en el círculo
        graficos2.drawImage(imagenEscalada, posX, posY, null);
    }
}

