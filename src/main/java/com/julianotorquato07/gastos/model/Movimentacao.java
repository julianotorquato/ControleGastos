package com.julianotorquato07.gastos.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="movimentacao")
public class Movimentacao {
    
    private Long idMovimentacao;
    private TipoMovimentacao tipoMovimentacao;
    private Date dtMovimentacao;
    private Double vlMovimentacao;
    private String nmNotas;
    private Usuario usuario;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_movimentacao")
    public Long getIdMovimentacao() {
        return idMovimentacao;
    }
    
    public void setIdMovimentacao(Long idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }
    
    @NotNull(message = "Tipo de gasto é obrigatório")
    @ManyToOne @JoinColumn(name = "id_tipo_movimentacao")
    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }
    
    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
    
    
    @NotNull(message = "Data do gasto é obrigatório")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name="dt_movimentacao")
    public Date getDtMovimentacao() {
        return dtMovimentacao;
    }
    
    public void setDtMovimentacao(Date dtMovimentacao) {
        this.dtMovimentacao = dtMovimentacao;
    }
    
    @Column(name = "nm_notas")
    public String getNmNotas() {
        return nmNotas;
    }
    
    public void setNmNotas(String nmNotas) {
        this.nmNotas = nmNotas;
    }
    @Column(name="vl_movimentacao")
    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
    @DecimalMax(value = "9999999.99", message = "Valor não pode ser maior que 9.999.999,99")
    @NumberFormat(pattern = "#,##0.00")
    public Double getVlMovimentacao() {
        return vlMovimentacao;
    }
    public void setVlMovimentacao(Double vlMovimentacao) {
        this.vlMovimentacao = vlMovimentacao;
    }

    @ManyToOne @JoinColumn(name = "id_usuario")
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idMovimentacao == null) ? 0 : idMovimentacao.hashCode());
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
        Movimentacao other = (Movimentacao) obj;
        if (idMovimentacao == null) {
            if (other.idMovimentacao != null)
                return false;
        } else if (!idMovimentacao.equals(other.idMovimentacao))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Movimentacao [idMovimentacao=" + idMovimentacao + ", tipoMovimentacao=" + tipoMovimentacao + ", dtMovimentacao=" + dtMovimentacao + ", nmNotas=" + nmNotas + "]";
    }
}
