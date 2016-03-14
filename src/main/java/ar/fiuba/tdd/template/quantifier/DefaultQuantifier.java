package ar.fiuba.tdd.template.quantifier;

/**
 * Created by leandro on 14/03/16.
 */
public class DefaultQuantifier implements Quantifier {

    private static int DEFAULT = 1;

    @Override
    public Integer getValue() {
        return DEFAULT;
    }
}
