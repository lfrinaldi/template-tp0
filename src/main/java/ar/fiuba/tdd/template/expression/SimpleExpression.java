package ar.fiuba.tdd.template.expression;

import ar.fiuba.tdd.template.quantifier.Quantifier;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leandro on 13/03/16.
 */
public class SimpleExpression implements Expression {

    private static String DOT = ".";
    private Quantifier quantifier;
    private String expression;

    public SimpleExpression(String expression, Quantifier quantifier) {
        this.quantifier = quantifier;
        this.expression = expression;
    }

    @Override
    public String getStringExpression() {
        return expression + quantifier.toString();
    }

    @Override
    public String generate() {
        final String generatedString;
        if (expression.equals(DOT)) {
            generatedString = createRandomString();
        } else {
            generatedString = expression;
        }
        return Stream.generate(() -> generatedString).limit(quantifier.getRepetitions())
                .collect(Collectors.joining());
    }

    private String createRandomString() {
        Random random = new Random();
        int randomInt = random.nextInt(256);
        return String.valueOf((char) randomInt);
    }
}
