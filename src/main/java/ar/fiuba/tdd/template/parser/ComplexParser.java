package ar.fiuba.tdd.template.parser;

import ar.fiuba.tdd.template.expression.Expression;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leandro on 13/03/16.
 */
public class ComplexParser implements Parser {

    @Override
    public List<Expression> parse(String regex) {
        List<Expression> expressions = new ArrayList<>();
        return expressions;
    }
}
