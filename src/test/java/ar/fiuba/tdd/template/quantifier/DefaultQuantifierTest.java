package ar.fiuba.tdd.template.quantifier;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leandro on 14/03/16.
 */
public class DefaultQuantifierTest {

    @Test
    public void createDefaultQuantifier() {
        Quantifier quantifier = new DefaultQuantifier();
        Assert.assertTrue(quantifier.getRepetitions() == 1);
        Assert.assertTrue(quantifier.toString().equals(""));
    }
}
