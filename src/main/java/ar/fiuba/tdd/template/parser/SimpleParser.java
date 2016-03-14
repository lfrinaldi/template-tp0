package ar.fiuba.tdd.template.parser;

import ar.fiuba.tdd.template.expression.Expression;
import ar.fiuba.tdd.template.expression.SimpleExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leandro on 13/03/16.
 */
public class SimpleParser implements Parser {

    private static ArrayList<String> quantifiers = new ArrayList<String>(Arrays.asList("+", "?", "*"));

    @Override
    public List<Expression> parse(String regex) {
        ArrayList<Expression> expressions = new ArrayList<>();
        String stringToParse = regex;
        while (stringToParse.length() > 0) {
            Expression expression = searchNextLiteralExpression(stringToParse);
            expressions.add(expression);
            stringToParse = stringToParse.substring(expression.getStringExpression().length());
        }
        return expressions;
    }

    private Expression searchNextLiteralExpression(String regex) {
        int firstQuantifier = getIndexFirstQuantifier(regex);
        String literal;
        if (firstQuantifier == -1) {
            literal = regex;
        } else {
            literal = regex.substring(0, firstQuantifier);
        }
        return new SimpleExpression(literal);
    }

    private int getIndexFirstQuantifier(String expression) {
        int indexMin = 0;
        for (String quantifier : quantifiers) {
            int index = expression.indexOf(quantifier);
            if (index < indexMin) {
                indexMin = index;
            }
        }
        return indexMin;
    }
}
