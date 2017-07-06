package com.julianotorquato07.gastos.common.properties;

public enum PropertiesKey {
	
	MESSAGE_ERRO_IMPOSSIVEL_EXECUTAR_ACAO("message.erro.impossivelExecutar"),
    MESSAGE_ERRO_PARAMETROS_ENTRADA_INVALIDOS("message.erro.parametrosEntradaIncorretos"),
    GASTO_EXCLUIDO_SUCESSO("gasto.msg.excluido.sucesso"),
    GASTO_SALVO_SUCESSO("gasto.msg.salvo.sucesso");

	private String descricao;

	private PropertiesKey(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

}