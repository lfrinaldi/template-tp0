package ar.fiuba.tdd.template.tp0;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leandro on 15/03/16.
 */
public class QuantifierTest {

    @Test
    public void createDefaultQuantifierTest() {
        Quantifier quantifier = new Quantifier(Constants.EMPTY_STRING);
        Assert.assertTrue(quantifier.getRepetitions() == 1);
        Assert.assertTrue(quantifier.getQuantifier().equals(Constants.EMPTY_STRING));
    }

    @Test
    public void createAsteriskQuantifierTest() {
        Quantifier quantifier = new Quantifier(Constants.ASTERISK);
        Assert.assertTrue(quantifier.getRepetitions() >= 0);
        Assert.assertTrue(quantifier.getQuantifier().equals(Constants.ASTERISK));
    }

    @Test
    public void createInterrogationQuantifierTest() {
        Quantifier quantifier = new Quantifier(Constants.INTERROGATION);
        Assert.assertTrue(quantifier.getRepetitions() >= 0);
        Assert.assertTrue(quantifier.getQuantifier().equals(Constants.INTERROGATION));
    }


    @Test
    public void createPlusQuantifierTest() {
        Quantifier quantifier = new Quantifier(Constants.PLUS);
        Assert.assertTrue(quantifier.getRepetitions() >= 1);
        Assert.assertTrue(quantifier.getQuantifier().equals(Constants.PLUS));
    }
}
