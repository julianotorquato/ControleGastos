package com.julianotorquato07.gastos.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.julianotorquato07.gastos.common.navegation.NavegationView;
import com.julianotorquato07.gastos.common.properties.PropertiesKey;
import com.julianotorquato07.gastos.common.properties.PropertiesUtils;
import com.julianotorquato07.gastos.model.TipoMovimentacao;
import com.julianotorquato07.gastos.service.MovimentacaoService;

@Controller
@RequestMapping("/tipo")
public class TipoMovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;
    private TipoMovimentacao tipo;
    
    @PostConstruct
    private void init(){
        tipo = new TipoMovimentacao();
    }
    
    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = getViewPadrao();
        return mv;
    }

    private ModelAndView getViewPadrao() {
        List<TipoMovimentacao> tipoMovimentacoes = movimentacaoService.getTipoMovimentacoes();
        ModelAndView mv = new ModelAndView(NavegationView.Movimentacao.CADASTRO_TIPO_GASTO);
        mv.addObject("tipoMovimentacoes", tipoMovimentacoes);
        mv.addObject(tipo);
        return mv;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(@Validated TipoMovimentacao tipoMovimentacao, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return getViewPadrao();
        }
        
        try {
            movimentacaoService.salvarTipoMovimentacao(tipoMovimentacao);
            attributes.addFlashAttribute("mensagem", PropertiesUtils.getString(PropertiesKey.GASTO_SALVO_SUCESSO));
            ModelAndView viewPadrao = getViewPadrao();
            viewPadrao.addObject(new TipoMovimentacao());
            return viewPadrao;
        } catch (Exception e) {
            return  new ModelAndView();
        }
    }
    
    @RequestMapping
    public ModelAndView pesquisar() {
        List<TipoMovimentacao> tipoMovimentacoes = movimentacaoService.getTipoMovimentacoes();
        ModelAndView mv = new ModelAndView();
        mv.addObject("tipoMovimentacoes", tipoMovimentacoes);
        return mv;
    }
    
    @RequestMapping(value="{codigo}", method = RequestMethod.PUT)
    public ModelAndView inativar(@PathVariable Long codigo, RedirectAttributes attributes) {
        movimentacaoService.inativarTipoMovimentacao(codigo);
        attributes.addFlashAttribute("mensagem", PropertiesUtils.getString(PropertiesKey.TIPO_GASTO_INATIVADO_SUCESSO));
        return getViewPadrao();
    }
    
}
