package ar.fiuba.tdd.template.parser;

import ar.fiuba.tdd.template.expression.Expression;

/**
 * Created by leandro on 13/03/16.
 */
public interface Parser {
    Expression parse(String regex);
}
