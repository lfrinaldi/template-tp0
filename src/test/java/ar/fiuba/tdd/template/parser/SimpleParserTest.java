package ar.fiuba.tdd.template.parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by leandro on 14/03/16.
 */
public class SimpleParserTest {
    private Parser parser;

    @Before
    public void setUp() {
        this.parser = new SimpleParser();
    }

    @Test
    public void parseEmptyRegexTest() {
        Assert.assertTrue(parser.parse("").size() == 0);
    }

    @Test
    public void parseRegexTest() {
        Assert.assertTrue(parser.parse("a").size() == 1);
    }
}
