package br.com.rick.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author rickt
 */
public class Bootcamp {
    private String nome, descricao;
    private final LocalDate dataInicial, dataFinal;
    private Set<Dev> devsInscritos;
    private Set<Conteudo> conteudos;

    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicial = LocalDate.now();
        this.dataFinal = dataInicial.plusDays(45);
        this.devsInscritos = new HashSet<>();
        this.conteudos = new LinkedHashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.descricao);
        hash = 43 * hash + Objects.hashCode(this.dataInicial);
        hash = 43 * hash + Objects.hashCode(this.dataFinal);
        hash = 43 * hash + Objects.hashCode(this.devsInscritos);
        hash = 43 * hash + Objects.hashCode(this.conteudos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bootcamp other = (Bootcamp) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.dataInicial, other.dataInicial)) {
            return false;
        }
        if (!Objects.equals(this.dataFinal, other.dataFinal)) {
            return false;
        }
        if (!Objects.equals(this.devsInscritos, other.devsInscritos)) {
            return false;
        }
        if (!Objects.equals(this.conteudos, other.conteudos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bootcamp: " + nome + " | " +
                descricao + " | Data de Início: " + dataInicial +
                " | Data de Fim: " + dataFinal + " | Quantidade de Devs: " +
                devsInscritos.size();
    }
}
