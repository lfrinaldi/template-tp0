package ar.fiuba.tdd.template.tp0;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leandro on 15/03/16.
 */
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
        final String generatedString = expression.replace(Constants.DOT, createRandomString());
        final int limit;
        int repetitions = quantifier.getRepetitions();
        if ((repetitions * expression.length()) > maxLength) {
            limit = maxLength / repetitions;
        } else {
            limit = quantifier.getRepetitions();
        }
        return Stream.generate(() -> generatedString).limit(limit)
                .collect(Collectors.joining());
    }

    private String createRandomString() {
        Random random = new Random();
        int randomInt = random.nextInt(256);
        return String.valueOf((char) randomInt);
    }
}
