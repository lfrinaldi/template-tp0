package ar.fiuba.tdd.template.expression;

import ar.fiuba.tdd.template.quantifier.Quantifier;

/**
 * Created by leandro on 13/03/16.
 */
public class SimpleExpression implements Expression {

    //private Quantifier quantifier;
    private String expression;

    public SimpleExpression(String expression /*, Quantifier quantifier*/) {
        //this.quantifier = quantifier;
        this.expression = expression;
    }

    @Override
    public String generate() {
        return null;
    }
}
