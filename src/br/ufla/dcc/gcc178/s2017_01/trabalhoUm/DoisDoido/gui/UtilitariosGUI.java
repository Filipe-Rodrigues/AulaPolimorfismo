package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui;

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
 
    public static final String DIR_APLICACAO = System.getProperty("user.dir");
    public static final String CAMINHO_DOS_BACKGROUNDS = DIR_APLICACAO + "/res/images/bg/";
    public static final String CAMINHO_DOS_ICONES = DIR_APLICACAO + "/res/images/icons/";
    public static final String CAMINHO_DAS_FONTES = DIR_APLICACAO + "/res/fonts/";
    public static final String CAMINHO_DOS_AUDIOS = DIR_APLICACAO + "/res/sound/";
    public static final String CAMINHO_DOS_JOGOS_SALVOS = DIR_APLICACAO + "/res/saved/gameData/";
    public static final String CAMINHO_DOS_MAPAS = DIR_APLICACAO + "/res/saved/maps/";
    
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
