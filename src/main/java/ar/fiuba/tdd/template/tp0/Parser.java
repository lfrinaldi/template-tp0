package ar.fiuba.tdd.template.tp0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by leandro on 15/03/16.
 */
public class Parser {
    private static ArrayList<String> quantifiers = new ArrayList<>(Arrays.asList(Constants.PLUS, Constants
            .INTERROGATION, Constants.ASTERISK));

    public List<Expression> parse(String regex) {
        validateRegex(regex);
        ArrayList<Expression> expressions = new ArrayList<>();
        return parseString(regex, expressions);
    }

    private List<Expression> parseString(String regex, List<Expression> expressions) {
        boolean shouldEscape = false;
        for (int i = 0; i < regex.length(); i++) {
            String character = String.valueOf(regex.charAt(i));
            if (shouldEscape || (!character.equals(Constants.OPEN_SQUARE_BRACKET))
                    && (!character.equals(Constants.ESCAPE))) {
                String possibleLiteral = getPossibleLiteral(i, regex);
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

    private String getPossibleLiteral(int currentOffset, String regex) {
        String possibleLiteral;
        String character = String.valueOf(regex.charAt(currentOffset));
        if (currentOffset < regex.length() - 1) {
            possibleLiteral = regex.substring(currentOffset, currentOffset + Constants.SIZE_LITERAL_WITH_QUANTIFIER);
        } else {
            possibleLiteral = character;
        }
        return possibleLiteral;
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
        String character = String.valueOf(set.charAt(set.length() - 1));
        int end = set.length() - 1;
        if (isQuantifier(character)) {
            end--;
        } else {
            character = Constants.EMPTY_STRING;
        }
        String expression = set.substring(1, end);
        expressions.add(new Expression(expression, new Quantifier(character)));

        return end;
    }

    private String firstSet(String expression) {
        int end = expression.indexOf(Constants.CLOSE_SQUARE_BRACKET) + 1;
        if ((expression.length() - 1) > end) {
            String quantifier = String.valueOf(expression.charAt(end + 1));
            if (!isQuantifier(quantifier)) {
                end++;
            }
        }
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

    private void validateRegex(String regex) throws PatternSyntaxException {
        Pattern.compile(regex);
    }


}
