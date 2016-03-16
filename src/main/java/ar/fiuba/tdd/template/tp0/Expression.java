package ar.fiuba.tdd.template.tp0;

/**
 * Created by leandro on 15/03/16.
 */
public class Expression {

    private String expression;
    private Quantifier quantifier;

    public Expression(String expression, Quantifier quantifier) {
        this.expression = expression;
        this.quantifier = quantifier;
    }

    public String getExpression() {
        return expression + quantifier.getQuantifier();
    }
}
