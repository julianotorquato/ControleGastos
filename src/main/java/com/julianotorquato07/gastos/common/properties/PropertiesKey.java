package com.julianotorquato07.gastos.common.properties;

public enum PropertiesKey {
	
	MESSAGE_ERRO_IMPOSSIVEL_EXECUTAR_ACAO("message.erro.impossivelExecutar"),
    MESSAGE_ERRO_PARAMETROS_ENTRADA_INVALIDOS("message.erro.parametrosEntradaIncorretos"),
    GASTO_EXCLUIDO_SUCESSO("gasto.msg.excluido.sucesso"),
    GASTO_SALVO_SUCESSO("gasto.msg.salvo.sucesso"),
    GASTO_FORMATO_DATA_INVALIDO("gasto.msg.formato.data.invalido"),
    TIPO_GASTO_SALVO_SUCESSO("tipo.gasto.msg.salvo.sucesso"),
    TIPO_GASTO_INATIVADO_SUCESSO("tipo.gasto.msg.inativado.sucesso");

	private String descricao;

	private PropertiesKey(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

}