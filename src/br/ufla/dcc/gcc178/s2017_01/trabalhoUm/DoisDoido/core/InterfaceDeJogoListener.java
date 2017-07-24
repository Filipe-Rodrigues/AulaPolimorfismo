package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.core;

import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.io.Comando;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.io.JogoEvent;

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
