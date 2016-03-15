package ar.fiuba.tdd.template.quantifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Created by leandro on 14/03/16.
 */
public class QuantifierFactory {
    static Map<String, Function<String, Quantifier>> map = new HashMap<>();

    static {
        map.put("?", value -> new InterrogationQuantifier());
        map.put("+", value -> new PlusQuantifier());
        map.put("*", value -> new AsteriskQuantifier());
        map.put("", value -> new DefaultQuantifier());

    }

    public static Quantifier createQuantifier(String quantifier) {
        return map.get(quantifier).apply(quantifier);
    }


}
