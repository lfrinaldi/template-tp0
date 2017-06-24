package ar.fiuba.tdd.template.tp0;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Expression {

    private String expression;
    private Quantifier quantifier;

    public Expression(String expression, Quantifier quantifier) {
        this.expression = expression;
        this.quantifier = quantifier;
    }

    public String getExpression() {
        return expression + quantifier.getQuantifier();
    }

    public String generate(int maxLength) {
        final String generatedString = generateString();
        final int limit = calculateRepetitions(maxLength);
        return Stream.generate(() -> generatedString).limit(limit)
                .collect(Collectors.joining());
    }

    private String generateString() {
        String generatedString;
        if (expression.length() > 1) {
            Random random = new Random();
            int charPosition = random.nextInt(expression.length());
            generatedString = String.valueOf(expression.charAt(charPosition));
        } else {
            generatedString = replaceRandomChar(expression);
        }
        return generatedString;
    }

    private String replaceRandomChar(String expression) {
        return expression.replace(Constants.DOT, createRandomString());
    }

    private int calculateRepetitions(int maxLength) {
        int limit;
        int repetitions = quantifier.getRepetitions();
        if ((repetitions * expression.length()) > maxLength) {
            limit = maxLength / repetitions;
        } else {
            limit = quantifier.getRepetitions();
        }
        return limit;
    }

    private String createRandomString() {
        Random random = new Random();
        int randomInt = random.nextInt(256);
        return String.valueOf((char) randomInt);
    }
}
