package com.julianotorquato07.gastos.service;

import java.util.List;
import com.julianotorquato07.gastos.model.Movimentacao;
import com.julianotorquato07.gastos.model.TipoMovimentacao;
import com.julianotorquato07.gastos.model.filter.MovimentacaoFilter;

public interface MovimentacaoService {
    
    public void salvar(Movimentacao movimentacao);
    
    public void excluir(Long idMovimentacao);

    public List<TipoMovimentacao> getTipoMovimentacoes();
    
    public List<TipoMovimentacao> getTipoMovimentaccaoAtivos();
    
    public List<Movimentacao> findAll();
    
    public List<Movimentacao> findAll(MovimentacaoFilter filtros);

    public void salvarTipoMovimentacao(TipoMovimentacao tipoMovimentacao);
    
    public void inativarTipoMovimentacao(Long _idTipoMovimentacao);
}
