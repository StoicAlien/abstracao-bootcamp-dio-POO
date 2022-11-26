package br.com.rick.desafio.dominio;

import java.time.LocalDate;

/**
 *
 * @author rickt
 */
public class Mentoria extends Conteudo {    
    private final LocalDate data;

    public Mentoria(LocalDate data) {
        this.data = data;
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO + 20d;
    }
    
    public LocalDate getData() {
        return data;
    }    

    @Override
    public String toString() {
        return "Mentoria: " + getTitulo() + " | " +
                getDescricao() + " | Data: " + data;
    }
    
}
