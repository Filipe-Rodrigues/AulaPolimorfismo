package io;

/**Classe FormatoDeComandoException.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Ela tem como função tratar excessões, quando um comando não é usado de 
 * maneira correta, essa classe especificamente na parte da entrada dos comandos.
 * 
 * @author Filipe Barros Rodrigues
 * @version 2017.07.01
 * 
 */
public class FormatoDeComandoException extends RuntimeException {

    /**
     * Creates a new instance of <code>ExcessoDeComandosException</code> without
     * detail message.
     */
    public FormatoDeComandoException() {
    }

    /**
     * Constructs an instance of <code>ExcessoDeComandosException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public FormatoDeComandoException(int numeroDeComandos) {
        super("São esperadas 1 ou 2 palavras de comando, mas foram enviadas " + numeroDeComandos + "!\n");
    }
}
