package br.com.rick.desafio.dominio;

/**
 *
 * @author rickt
 */
public abstract class Conteudo {
    protected static final double XP_PADRAO = 10d;
    private /*final*/ String titulo, descricao;

//    public Conteudo(String titulo, String descricao) {
//        this.titulo = titulo;
//        this.descricao = descricao;
//    }
    
    public abstract double calcularXP();

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
