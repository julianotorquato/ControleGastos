package com.julianotorquato07.gastos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.julianotorquato07.gastos.model.TipoMovimentacao;

public interface TipoMovimentacaoRepository extends JpaRepository<TipoMovimentacao, Long> {
    
    @Query("FROM TipoMovimentacao AS t WHERE t.ativo = true")
    public List<TipoMovimentacao> findAllByAtivo();
    
}