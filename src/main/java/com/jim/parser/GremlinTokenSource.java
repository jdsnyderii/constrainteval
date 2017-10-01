package com.jim.parser;

import org.antlr.v4.runtime.ListTokenSource;
import org.antlr.v4.runtime.Token;

import java.util.List;

public class GremlinTokenSource extends ListTokenSource {

  public GremlinTokenSource(List<Token> tokens) {
    super(tokens, "ArrayList");
  }


}
