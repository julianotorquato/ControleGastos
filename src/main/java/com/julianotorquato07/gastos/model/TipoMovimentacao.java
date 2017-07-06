package com.julianotorquato07.gastos.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_movimentacao")
public class TipoMovimentacao implements Serializable{

    public static final Long RECEITA = new Long("1");
    public static final Long DESPESA = new Long("2");
    
    private Long idTipoMovimentacao;
    private String nome;
    
    public TipoMovimentacao() { }

    public TipoMovimentacao(String nome) {
        super();
        this.nome = nome;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_tipo_movimentacao")
    public Long getIdTipoMovimentacao() {
        return idTipoMovimentacao;
    }
    
    public void setIdTipoMovimentacao(Long idTipoMovimentacao) {
        this.idTipoMovimentacao = idTipoMovimentacao;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTipoMovimentacao == null) ? 0 : idTipoMovimentacao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TipoMovimentacao other = (TipoMovimentacao) obj;
        if (idTipoMovimentacao == null) {
            if (other.idTipoMovimentacao != null)
                return false;
        } else if (!idTipoMovimentacao.equals(other.idTipoMovimentacao))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "TipoMovimentacao [idTipoMovimentacao=" + idTipoMovimentacao + ", nome=" + nome + "]";
    }
}
