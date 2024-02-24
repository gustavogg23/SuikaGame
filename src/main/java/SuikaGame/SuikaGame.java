package SuikaGame;

import java.awt.Color;
import javax.swing.JFrame;

public class SuikaGame {

    public static void main(String[] args) {
        MENU menu = new MENU();
        
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setResizable(false);
        menu.setBackground(new Color(213, 137, 54));
        menu.setLocationRelativeTo(null);
        
        menu.setVisible(true);
    }
}
