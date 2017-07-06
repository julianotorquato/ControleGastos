package com.julianotorquato07.gastos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.julianotorquato07.gastos.model.Movimentacao;
import com.julianotorquato07.gastos.model.TipoMovimentacao;

public interface TipoMovimentacaoRepository extends JpaRepository<TipoMovimentacao, Long> { }