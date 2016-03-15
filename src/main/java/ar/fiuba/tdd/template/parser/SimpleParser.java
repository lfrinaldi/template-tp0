package ar.fiuba.tdd.template.parser;

import ar.fiuba.tdd.template.expression.Expression;
import ar.fiuba.tdd.template.expression.SimpleExpression;
import ar.fiuba.tdd.template.quantifier.Quantifier;
import ar.fiuba.tdd.template.quantifier.QuantifierFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leandro on 13/03/16.
 */
public class SimpleParser implements Parser {

    private static ArrayList<String> quantifiers = new ArrayList<String>(Arrays.asList("+", "?", "*"));
    private static int SIZE_EXPRESSION_WITH_QUANTIFIER = 2;
    private static String EMPTY_STRING = "";

    @Override
    public List<Expression> parse(String regex) {
        ArrayList<Expression> expressions = new ArrayList<>();
        String stringToParse = regex;
        while (stringToParse.length() > 0) {
            Expression expression = getNextLiteralExpression(stringToParse);
            expressions.add(expression);
            stringToParse = stringToParse.substring(expression.getStringExpression().length());
        }
        return expressions;
    }

    private boolean hasQuantifier(String expression) {
        final String expressionToSearch = expression;
        return quantifiers.stream().anyMatch(
                quantifier -> expressionToSearch.contains(quantifier)
                        && !expressionToSearch.contains("\\" + quantifier)
        );
    }

    private Expression getNextLiteralExpression(String regex) {
        Expression expression;
        if (hasQuantifier(regex)) {
            expression = createExpressionWithQuantifier(regex);
        } else {
            expression = createExpressionWithoutQuantifier(regex);
        }
        return expression;
    }

    private Expression createExpressionWithQuantifier(String regex) {
        int firstQuantifier = getIndexFirstQuantifier(regex);
        String literal;
        String quantifier;
        if (regex.length() < SIZE_EXPRESSION_WITH_QUANTIFIER) {
            literal = EMPTY_STRING;
            quantifier = EMPTY_STRING;
        } else if (regex.length() == SIZE_EXPRESSION_WITH_QUANTIFIER) {
            literal = regex.substring(0, firstQuantifier);
            quantifier = regex.substring(regex.length() - 1);
        } else {
            literal = regex.substring(0, firstQuantifier - SIZE_EXPRESSION_WITH_QUANTIFIER);
            quantifier = EMPTY_STRING;
        }
        return new SimpleExpression(literal, QuantifierFactory.createQuantifier(quantifier));
    }

    private Expression createExpressionWithoutQuantifier(String literal) {
        return new SimpleExpression(literal, QuantifierFactory.createQuantifier(""));
    }

    private int getIndexFirstQuantifier(String expression) {
        int indexMin = expression.length();
        for (String quantifier : quantifiers) {
            int index = expression.indexOf(quantifier);
            if (index < indexMin && index > 0) {
                indexMin = index;
            }
        }
        return indexMin;
    }
}
