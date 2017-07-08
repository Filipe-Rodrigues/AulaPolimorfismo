package io;

/**
 * Interface Printavel - Define métodos para saída de dados.
 * 
 * Esta interface serve para assegurar que a classe que a implementar irá
 * suportar a capacidade de imprimir os dados fornecidos a ela em um campo
 * qualquer, seja no console, seja em uma caixa de texto em uma GUI, etc.
 * 
 * @author Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public interface SaidaDeJogoListener {
    /**
     * Imprime o conteúdo da String passada pelo parâmetro da função e continua
     * na mesma linha.
     *
     * @param sentenca String contendo a sentença a ser impressa.
     */
    public void imprimir(String sentenca);
    
    /**
     * Imprime o conteúdo da String passada pelo parâmetro da função e continua
     * na linha seguinte.
     *
     * @param sentenca String contendo a sentença a ser impressa.
     */
    public void imprimirLinha(String sentenca);
}
