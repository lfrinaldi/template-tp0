package ar.fiuba.tdd.template.parser;

import ar.fiuba.tdd.template.expression.Expression;

import java.util.List;

/**
 * Created by leandro on 13/03/16.
 */
public interface Parser {
    List<Expression> parse(String regex);
}
