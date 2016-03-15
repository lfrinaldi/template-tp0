package ar.fiuba.tdd.template.quantifier;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leandro on 13/03/16.
 */
public class PlusQuantifierTest {

    @Test
    public void createPlusQuantifierTest() {
        Quantifier quantifier = new PlusQuantifier();
        Assert.assertTrue(quantifier.getRepetitions() >= 1);
        Assert.assertTrue(quantifier.toString().equals("+"));
    }
}
