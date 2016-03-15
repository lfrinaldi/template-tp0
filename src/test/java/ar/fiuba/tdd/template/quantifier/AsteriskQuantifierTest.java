package ar.fiuba.tdd.template.quantifier;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leandro on 13/03/16.
 */
public class AsteriskQuantifierTest {

    @Test
    public void createAsteriskQuantifier() {
        Quantifier quantifier = new AsteriskQuantifier();
        Assert.assertTrue(quantifier.getRepetitions() >= 0);
        Assert.assertTrue(quantifier.toString().equals("*"));
    }
}
