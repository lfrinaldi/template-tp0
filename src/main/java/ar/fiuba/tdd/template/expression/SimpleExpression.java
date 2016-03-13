package ar.fiuba.tdd.template.expression;

import ar.fiuba.tdd.template.quantifier.Quantifier;

/**
 * Created by leandro on 13/03/16.
 */
public class SimpleExpression implements Expression {

    private String expression;
    private Quantifier quantifier;

    public SimpleExpression(String expression, Quantifier quantifier) {
        this.expression = expression;
        this.quantifier = quantifier;
    }

    @Override
    public String generate() {
        return null;
    }
}
