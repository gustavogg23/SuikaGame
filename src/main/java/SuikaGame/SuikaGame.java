package SuikaGame;

import java.awt.Color;
import javax.swing.JFrame;

public class SuikaGame {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("SUIKA GAME");
        
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setBackground(new Color(213, 137, 54));
        
        GamePanel panelJuego = new GamePanel();
        ventana.add(panelJuego);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);     
        
        panelJuego.iniciarJuego();
    }
}
