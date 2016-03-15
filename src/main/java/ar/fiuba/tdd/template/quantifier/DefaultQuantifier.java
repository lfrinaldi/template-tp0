package ar.fiuba.tdd.template.quantifier;

/**
 * Created by leandro on 14/03/16.
 */
public class DefaultQuantifier implements Quantifier {

    private static String VALUE = "";
    private static int DEFAULT = 1;

    @Override
    public Integer getRepetitions() {
        return DEFAULT;
    }

    @Override
    public String toString() {
        return VALUE;
    }
}
