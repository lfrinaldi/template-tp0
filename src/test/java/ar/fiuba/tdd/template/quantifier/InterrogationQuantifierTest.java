package ar.fiuba.tdd.template.quantifier;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leandro on 13/03/16.
 */
public class InterrogationQuantifierTest {

    @Test
    public void createInterrogationQuantifierTest() {
        Quantifier quantifier = new InterrogationQuantifier();
        Assert.assertTrue(quantifier.getValue() >= 0);
    }
}
