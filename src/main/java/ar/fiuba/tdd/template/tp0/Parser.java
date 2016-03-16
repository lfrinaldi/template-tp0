package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leandro on 15/03/16.
 */
public class Parser {
    private static ArrayList<String> quantifiers = new ArrayList<>(Arrays.asList(Constants.PLUS, Constants
            .INTERROGATION, Constants.ASTERISK));

    public List<Expression> parse(String regex) {
        ArrayList<Expression> expressions = new ArrayList<>();
        boolean shouldEscape = false;

        for (int i = 0; i < regex.length(); i++) {
            String character = String.valueOf(regex.charAt(i));
            if (shouldEscape || (!character.equals(Constants.OPEN_SQUARE_BRACKET))
                    && (!character.equals(Constants.ESCAPE))) {
                String possibleLiteral;
                if (i < regex.length() - 1) {
                    possibleLiteral = regex.substring(i, i + Constants.SIZE_LITERAL_WITH_QUANTIFIER);
                } else {
                    possibleLiteral = character;
                }
                i += parseLiteral(possibleLiteral, expressions);
                shouldEscape = false;
            } else {
                shouldEscape = character.equals(Constants.ESCAPE);
                if (!shouldEscape) {
                    String set = firstSet(regex.substring(i));
                    i += parseSet(set, expressions);
                }
            }
        }
        return expressions;
    }

    private boolean isQuantifier(String character) {
        return quantifiers.contains(character);
    }

    private int parseLiteral(String literal, List<Expression> expressions) {
        String possibleLiteral = String.valueOf(literal.charAt(0));
        String possibleQuantifier;
        Expression expression;
        possibleQuantifier = getQuantifier(literal);
        expression = new Expression(possibleLiteral, new Quantifier(possibleQuantifier));
        expressions.add(expression);
        return expression.getExpression().length() - 1;
    }

    private int parseSet(String set, List<Expression> expressions) {
        return 0;
    }

    private String firstSet(String expression) {
        int end = expression.indexOf(Constants.CLOSE_SQUARE_BRACKET);
        return expression.substring(0, end);
    }

    private String getQuantifier(String expression) {
        String quantifier;
        if (expression.length() >= 2) {
            quantifier = String.valueOf(expression.charAt(1));
            if (!isQuantifier(quantifier)) {
                quantifier = Constants.EMPTY_STRING;
            }
        } else {
            quantifier = Constants.EMPTY_STRING;
        }
        return quantifier;
    }


}
