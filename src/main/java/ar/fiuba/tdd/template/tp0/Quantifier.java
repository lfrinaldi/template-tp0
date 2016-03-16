package ar.fiuba.tdd.template.tp0;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

/**
 * Created by leandro on 15/03/16.
 */
public class Quantifier {

    private static Map<String, Function<String, Integer>> map = new HashMap<>();
    private static Random RANDOM = new Random();
    private String quantifier;

    static {
        map.put(Constants.INTERROGATION, value -> RANDOM.nextInt(2));
        map.put(Constants.PLUS, value -> (RANDOM.nextInt(Constants.MAX_REPETITIONS - 1) + 1));
        map.put(Constants.ASTERISK, value -> RANDOM.nextInt(Constants.MAX_REPETITIONS));
        map.put(Constants.EMPTY_STRING, value -> 1);

    }

    public Quantifier(String quantifier) {
        this.quantifier = quantifier;
    }

    public Integer getRepetitions() {
        return map.get(quantifier).apply(quantifier);
    }

    public String getQuantifier() {
        return quantifier;
    }


}
