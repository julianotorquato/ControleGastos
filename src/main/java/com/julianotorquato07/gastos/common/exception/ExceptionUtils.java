package com.julianotorquato07.gastos.common.exception;

import com.julianotorquato07.gastos.common.properties.PropertiesKey;
import com.julianotorquato07.gastos.common.properties.PropertiesUtils;

public class ExceptionUtils {
    
    public static void errorParametrosInvalidos()throws Exception{
        ExceptionUtils.lancarExcecao(PropertiesUtils.getString(PropertiesKey.MESSAGE_ERRO_PARAMETROS_ENTRADA_INVALIDOS));
    }
    
    public static void lancarExcecao(String msg)throws Exception{
        throw new NegocioException(msg);
    }
}
