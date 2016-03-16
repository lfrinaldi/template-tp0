package ar.fiuba.tdd.template.tp0;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leandro on 15/03/16.
 */
public class ExpressionTest {

    @Test
    public void createExpressionTest() {
        String regex = "a";
        Expression expression = new Expression(regex, new Quantifier(Constants.EMPTY_STRING));
        Assert.assertTrue(expression.getExpression().equals(regex));
    }
}
