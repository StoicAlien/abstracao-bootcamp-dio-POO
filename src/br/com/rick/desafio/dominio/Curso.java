package br.com.rick.desafio.dominio;

/**
 *
 * @author rickt
 */
public class Curso extends Conteudo {
    private final int cargaHoraria;

    public Curso(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    @Override
    public double calcularXP() {
        return XP_PADRAO * cargaHoraria;
    }
    
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso: " + getTitulo() + " | " +
                getDescricao() + " | " + cargaHoraria + " h"
                + (cargaHoraria > 1 ? "rs" : "r");
    }
}
