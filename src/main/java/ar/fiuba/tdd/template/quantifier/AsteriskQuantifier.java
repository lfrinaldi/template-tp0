package ar.fiuba.tdd.template.quantifier;

import java.util.Random;

/**
 * Created by leandro on 13/03/16.
 */
public class AsteriskQuantifier implements Quantifier {

    private static int HIGH = 2;
    private static int LOW = 0;


    @Override
    public Integer getValue() {
        Random random = new Random();
        return random.nextInt(HIGH - LOW) + LOW;
    }
}
