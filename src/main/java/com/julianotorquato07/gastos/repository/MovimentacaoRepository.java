package com.julianotorquato07.gastos.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.julianotorquato07.gastos.model.Movimentacao;
import com.julianotorquato07.gastos.model.TipoMovimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    @Query("FROM Movimentacao AS m WHERE m.tipoMovimentacao.idTipoMovimentacao= ?1")
    public List<Movimentacao> findByTipo(Long _idTipoMovimentacao);
    @Query("FROM Movimentacao AS m WHERE m.dtMovimentacao = ?1")
    public List<Movimentacao> findByData(Date _dtMovimentacao);
    @Query("FROM Movimentacao AS m WHERE m.tipoMovimentacao.idTipoMovimentacao= ?1 "
            + "and m.dtMovimentacao = ?2 ")
    public List<Movimentacao> findBy(Long _idTipoMovimentacao, Date _dtMovimentacao);
    
}
