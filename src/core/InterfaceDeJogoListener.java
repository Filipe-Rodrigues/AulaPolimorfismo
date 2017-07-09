package core;

import io.Comando;
import io.JogoEvent;

/**Interface InterfaceDeJogoListener.
 * 
 * Esta Interface eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.07.01
 */
public interface InterfaceDeJogoListener {
    public void envioDeComandoPerformed (JogoEvent evt);
}
