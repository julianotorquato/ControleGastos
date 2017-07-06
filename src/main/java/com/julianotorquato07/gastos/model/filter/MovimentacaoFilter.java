package com.julianotorquato07.gastos.model.filter;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class MovimentacaoFilter {

    private Long idTipoMovimentacao;
    
    private Date dtMovimentacao;

    
    public Long getIdTipoMovimentacao() {
        return idTipoMovimentacao;
    }
    public void setIdTipoMovimentacao(Long idTipoMovimentacao) {
        this.idTipoMovimentacao = idTipoMovimentacao;
    }
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    public Date getDtMovimentacao() {
        return dtMovimentacao;
    }
    public void setDtMovimentacao(Date dtMovimentacao) {
        this.dtMovimentacao = dtMovimentacao;
    }
}
