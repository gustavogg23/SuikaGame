package SuikaGame;

import com.jogamp.newt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles implements KeyListener {
    
    public static boolean botonIzquierda, botonDerecha;

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {}

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        int codigo = e.getKeyCode();
        
        if (codigo == KeyEvent.VK_LEFT) { // Se verifica si se presiona la flecha izquierda para mover a la izquierda
            botonIzquierda = true;
        }
        
        if (codigo == KeyEvent.VK_RIGHT) { // Se verifica si se presiona la flecha derecha para mover a la derecha
            botonDerecha = true;
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {}
    
}
