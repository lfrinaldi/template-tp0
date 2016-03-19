package ar.fiuba.tdd.template.tp0;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leandro on 15/03/16.
 */
public class ExpressionTest {

    private static int MAX = 10;

    @Test
    public void createExpressionTest() {
        String regex = "a";
        Expression expression = new Expression(regex, new Quantifier(Constants.EMPTY_STRING));
        Assert.assertTrue(expression.getExpression().equals(regex));
    }

    @Test
    public void generateLiteralStringTest() {
        String regex = "a";
        Expression expression = new Expression(regex, new Quantifier(Constants.EMPTY_STRING));
        Assert.assertTrue(expression.generate(MAX).equals(regex));
    }

    @Test
    public void generateDotStringTest() {
        String regex = ".";
        Expression expression = new Expression(regex, new Quantifier(Constants.EMPTY_STRING));
        String generatedString = expression.generate(MAX);
        Assert.assertTrue(generatedString.length() == 1);
    }
}
