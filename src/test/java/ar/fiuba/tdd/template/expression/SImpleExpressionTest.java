package ar.fiuba.tdd.template.expression;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leandro on 13/03/16.
 */
public class SImpleExpressionTest {

    @Test
    public void generateSimpleExpression() {
        Expression expression = new SimpleExpression("");
        Assert.assertTrue(expression.generate() == null);
    }

    @Test
    public void getSimpleExpressionString() {
        Expression expression = new SimpleExpression("");
        Assert.assertTrue(expression.getStringExpression() == "");
    }
}
