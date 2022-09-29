package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    private BigDecimal somarAtributos(Object objeto, Class anotacao) throws IllegalAccessException {
        BigDecimal soma = new BigDecimal(0);
        Field [] atributos = objeto.getClass().getDeclaredFields();
        for(Field atributo: atributos) {
            atributo.setAccessible(true);
            if(atributo.getType().toString().contains("BigDecimal") && atributo.getDeclaredAnnotation(anotacao) != null) {
                soma = soma.add((BigDecimal) atributo.get(objeto));
            }
        }
        return soma;
    }

    @Override
    public BigDecimal somar(Object objeto) throws IllegalAccessException {
        return somarAtributos(objeto, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object objeto) throws IllegalAccessException {
        return somarAtributos(objeto, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object objeto) throws IllegalAccessException {
        return somar(objeto).subtract(subtrair(objeto));
    }

}
