package core;

import gui.NavegacaoEvent;

/**
 * Interface InterfaceDeNavegacaoListenter.
 *
 * Esta interface eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 *
 * @author  Filipe Barros Rodrigues
 * @version 2017.21.07
 */
public interface InterfaceDeNavegacaoListenter {
    public void solicitacaoDeNavegacaoPerformed (NavegacaoEvent evt);
}
