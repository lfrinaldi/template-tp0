package ar.fiuba.tdd.template.expression;

import ar.fiuba.tdd.template.quantifier.DefaultQuantifier;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leandro on 13/03/16.
 */
public class SimpleExpressionTest {


    @Test
    public void generateSimpleExpression() {
        Expression expression = new SimpleExpression("", new DefaultQuantifier());
        Assert.assertTrue(expression.generate().equals(""));
    }

    @Test
    public void getSimpleExpressionString() {
        Expression expression = new SimpleExpression("", new DefaultQuantifier());
        Assert.assertTrue(expression.getStringExpression().equals(""));
    }
}
