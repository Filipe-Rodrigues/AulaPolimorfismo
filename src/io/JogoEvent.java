package io;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author filip
 */
public class JogoEvent {
    private String saida;
    private String imagemDoAmbiente;
    private List<String> saidasDoAmbiente;
    private boolean querMapa;
    private boolean apagaTudo;
    private boolean finalizado;
    
    public JogoEvent (List<String> saidas) {
        saida = "";
        imagemDoAmbiente = "";
        apagaTudo = false;
        finalizado = false;
        querMapa = false;
        this.saidasDoAmbiente = saidas;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }
    
    public String getImagem() {
        return imagemDoAmbiente;
    }

    public void setImagem(String imagem) {
        this.imagemDoAmbiente = imagem;
    }
    
    public List<String> getSaidasDisponiveis() {
        return Collections.unmodifiableList(saidasDoAmbiente);
    }
    
    public void setSaidasDisponiveis(List<String> saidas) {
        this.saidasDoAmbiente = saidas;
    }
    
    public void emendarSaida(String saida) {
        this.saida += "\n" + saida;
    }

    public boolean querMapa() {
        return querMapa;
    }

    public void setQuerMapa(boolean querMapa) {
        this.querMapa = querMapa;
    }
    
    public boolean deveLimparTela() {
        return apagaTudo;
    }

    public void setLimparTela(boolean apagaTudo) {
        this.apagaTudo = apagaTudo;
    }
    
    public boolean taFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean apagaTudo) {
        this.finalizado = apagaTudo;
    }
    
}
