package ar.fiuba.tdd.template.tp0;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by leandro on 15/03/16.
 */
public class ParserTest {

    @Test
    public void parseEmptyString() {
        Parser parser = new Parser();
        Assert.assertTrue(parser.parse(Constants.EMPTY_STRING).size() == 0);
    }

    @Test
    public void parseLiteralWithQuantifierString() {
        Parser parser = new Parser();
        String expression = "a*";
        List<Expression> list = parser.parse(expression);
        Assert.assertTrue(list.size() == 1);
        Assert.assertTrue(list.get(0).getExpression().equals(expression));
        expression = "abc*";
        list = parser.parse(expression);
        Assert.assertTrue(list.size() == 3);
        expression = "abc\\*";
        list = parser.parse(expression);
        Assert.assertTrue(list.size() == 4);
    }

    @Test
    public void parseLiteralWithoutQuantifierString() {
        Parser parser = new Parser();
        String expression = "a";
        List<Expression> list = parser.parse(expression);
        Assert.assertTrue(list.size() == 1);
        Assert.assertTrue(list.get(0).getExpression().equals(expression));
        expression = "abc";
        list = parser.parse(expression);
        Assert.assertTrue(list.size() == 3);
        expression = "ab\\f";
        list = parser.parse(expression);
        Assert.assertTrue(list.size() == 3);
    }

    @Test
    public void parseSetWithoutQuantifiersString() {
        Parser parser = new Parser();
        String expression = "[aaa]";
        List<Expression> list = parser.parse(expression);
        Assert.assertTrue(list.size() == 1);
        Assert.assertTrue(list.get(0).getExpression().equals("aaa"));
        expression = "ab[aa]";
        list = parser.parse(expression);
        Assert.assertTrue(list.size() == 3);
        Assert.assertTrue(list.get(2).getExpression().equals("aa"));
    }
}
