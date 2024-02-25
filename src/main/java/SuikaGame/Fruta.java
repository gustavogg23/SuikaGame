package SuikaGame;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Fruta {
    // Atributos
    private int posX;
    private int posY;
    private int diametro;
    private int velCaida;
    private Image imagen;

    // Método Constructor
    public Fruta(int posX, int posY, int diametro, int velCaida, String ruta) {
        this.posX = posX;
        this.posY = posY;
        this.diametro = diametro;
        this.velCaida = velCaida;
        this.imagen = new ImageIcon(ruta).getImage();
    }

    // Métodos Getters y Setters
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    public int getDiametro() {
        return diametro;
    }
    
    public void setDiametro(int diametro) {
        this.diametro = diametro;
    }

    public int getVelCaida() {
        return velCaida;
    }

    public void setVelCaida(int velCaida) {
        this.velCaida = velCaida;
    }
    
    // Método para actualizar la posición de la fruta
    public void actualizarPos() {
        posY += velCaida;
    }
    
    // Método para dibujar la fruta
    public void dibujarFruta(Graphics2D graficos2) {
        graficos2.drawImage(imagen, posX, posY, diametro, diametro, null);
    }
}
