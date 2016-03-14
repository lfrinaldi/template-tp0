package ar.fiuba.tdd.template.expression;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leandro on 13/03/16.
 */
public class ComplexExpressionTest {

    @Test
    public void createExpressionTest() {
        Expression expression = new ComplexExpression();
        Assert.assertTrue(expression.generate() == null);
    }
}
