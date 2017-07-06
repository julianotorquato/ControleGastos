package com.julianotorquato07.gastos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.julianotorquato07.gastos.common.navegation.NavegationView;
import com.julianotorquato07.gastos.common.properties.PropertiesKey;
import com.julianotorquato07.gastos.common.properties.PropertiesUtils;
import com.julianotorquato07.gastos.model.Movimentacao;
import com.julianotorquato07.gastos.model.TipoMovimentacao;
import com.julianotorquato07.gastos.model.filter.MovimentacaoFilter;
import com.julianotorquato07.gastos.service.MovimentacaoService;

@Controller
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoService movimentacaoService;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView(NavegationView.Movimentacao.CADASTRO_GASTO);
        mv.addObject(new Movimentacao());
        return mv;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Movimentacao movimentacao, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return NavegationView.Movimentacao.CADASTRO_GASTO;
        }
        
        try {
            movimentacaoService.salvar(movimentacao);
            attributes.addFlashAttribute("mensagem", PropertiesUtils.getString(PropertiesKey.GASTO_SALVO_SUCESSO));
            return "redirect:/movimentacoes/novo";
        } catch (IllegalArgumentException e) {
            errors.rejectValue("dataVencimento", null, e.getMessage());
            return NavegationView.Movimentacao.CADASTRO_GASTO;
        }
    }
    
    @RequestMapping
    public ModelAndView pesquisar(@ModelAttribute("filtro") MovimentacaoFilter filtro) {
        List<Movimentacao> movimentacoes = movimentacaoService.findAll(filtro);

        ModelAndView mv = new ModelAndView(NavegationView.Movimentacao.PESQUISA_GASTOS);
        mv.addObject("movimentacoes", movimentacoes);
        return mv;
    }
    
    @RequestMapping("{codigo}")
    public ModelAndView edicao(@PathVariable("codigo") Movimentacao movimentacao) {
        ModelAndView mv = new ModelAndView(NavegationView.Movimentacao.CADASTRO_GASTO); 
        mv.addObject(movimentacao);
        return mv;
    }
    
    @RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
        movimentacaoService.excluir(codigo);
        
        attributes.addFlashAttribute("mensagem", PropertiesUtils.getString(PropertiesKey.GASTO_EXCLUIDO_SUCESSO));
        return "redirect:/movimentacoes";
    }
    
    @ModelAttribute("tipoMovimentacoes")
    public List<TipoMovimentacao> getTipoMovimentacoes() {
        return movimentacaoService.getTipoMovimentacoes();
    }
	
}
