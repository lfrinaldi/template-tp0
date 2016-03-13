package ar.fiuba.tdd.template.expression;

import ar.fiuba.tdd.template.quantifier.Quantifier;

/**
 * Created by leandro on 13/03/16.
 */
public class ComplexExpression implements Expression {
    private Quantifier quantifier;

    public ComplexExpression(Quantifier quantifier) {
        this.quantifier = quantifier;
    }

    @Override
    public String generate() {
        return null;
    }
}
