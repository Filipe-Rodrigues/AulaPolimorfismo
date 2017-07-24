package gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import javax.swing.JComponent;

/**
 * Classe enumerada TipoDeGUI.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.21.09
 */ 
public class UtilitariosGUI {
 
    /**Metodo mudarFonte.
     * 
     * muda da fonte padrão para uma outra fonte passada.
     * 
     * @param campo JTextComponent.
     * @param fonte String nome da fonte.
     * @param tamanho float com o tamanho da fonte.
     */
    public static void mudarFonte(JComponent campo, String fonte, float tamanho) {
        try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/" + fonte)).deriveFont(tamanho);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/" + fonte)));
            //use the font
            campo.setFont(customFont);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }
    
}
