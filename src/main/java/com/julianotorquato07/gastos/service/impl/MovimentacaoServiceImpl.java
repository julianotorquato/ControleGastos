package com.julianotorquato07.gastos.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.julianotorquato07.gastos.model.Movimentacao;
import com.julianotorquato07.gastos.model.TipoMovimentacao;
import com.julianotorquato07.gastos.model.Usuario;
import com.julianotorquato07.gastos.model.filter.MovimentacaoFilter;
import com.julianotorquato07.gastos.repository.MovimentacaoRepository;
import com.julianotorquato07.gastos.repository.TipoMovimentacaoRepository;
import com.julianotorquato07.gastos.service.MovimentacaoService;
import com.julianotorquato07.gastos.util.ObjectUtils;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{

    @Autowired
    private MovimentacaoRepository repository;
    @Autowired
    private TipoMovimentacaoRepository tipoMovimentacaoRepository;
    
    public void salvar(Movimentacao movimentacao) {
        try {
            Usuario usuario = new Usuario();
            usuario.setIdUsuario(Usuario.ADMIN);
            movimentacao.setUsuario(usuario);
            repository.save(movimentacao);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Formato de data inválido");
        }
    }

    public void excluir(Long _idMovimentacao) {
        repository.delete(_idMovimentacao);
    }
    
    public List<TipoMovimentacao> getTipoMovimentacoes() {
        return tipoMovimentacaoRepository.findAll();
    }
    public List<Movimentacao> findAll(MovimentacaoFilter filtros) {
        if (ObjectUtils.isEmpty(filtros.getDtMovimentacao()) && ObjectUtils.isEmpty(filtros.getIdTipoMovimentacao())) {
            return repository.findAll();
        } else if (ObjectUtils.isEmpty(filtros.getDtMovimentacao()) && ObjectUtils.isNotEmpty(filtros.getIdTipoMovimentacao())) {
            return repository.findByTipo(filtros.getIdTipoMovimentacao());
        } else if (ObjectUtils.isNotEmpty(filtros.getDtMovimentacao()) && ObjectUtils.isEmpty(filtros.getIdTipoMovimentacao())) {
            return repository.findByData(filtros.getDtMovimentacao());
        }
        return repository.findBy(filtros.getIdTipoMovimentacao(), filtros.getDtMovimentacao());
    }

    @Override
    public List<Movimentacao> findAll() {
        return repository.findAll();
    }
    
}
