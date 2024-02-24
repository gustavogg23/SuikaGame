package SuikaGame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    public static final int ANCHO = 1280;
    public static final int ALTO = 720;
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(ANCHO, ALTO));
        this.setBackground(new Color(213, 137, 54));
        this.setLayout(null);
    }
}
