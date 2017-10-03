package com.jim.parser;

import com.jim.antlr4.parser.DegreePlanListener;
import com.jim.antlr4.parser.DegreePlanParser;
import org.antlr.v4.runtime.*;

import java.util.List;

/**
 * A convenience class to make setting up a parser easy and flexible.
 */
public class ParserMain {

  private TokenSource source;
  private DegreePlanListener listener;

  /**
   * Make a TokenSource that is based on an ArrayList. Mostly good for testing.
   *
   * @param tokens a token list to make into a {@link TokenSource}.
   */
  public ParserMain(List<Token> tokens) {
    this.source = new ListTokenSource(tokens);
  }

  /**
   * Make a TokenSource that is based on an ArrayList. Mostly good for testing.
   *
   * @param tokens a token list to make into a {@link TokenSource}.
   */
  public ParserMain(List<Token> tokens, DegreePlanListener listener) {
    this.source = new ListTokenSource(tokens);
    this.listener = listener;
  }

  public TokenFactory getTokenFactory() {
    return source.getTokenFactory();
  }

  /**
   * Parse using the Antlr {@link CommonTokenStream} over the given {@link TokenSource} and add an
   * optional {@link DegreePlanListener}
   * <p>
   *
   * It is also possible to add functionality like:
   * <p/>
   * <code>
   * ParseTree tree = parser.parse();
   * tree.accept(new DegreePlanBaseVisitor<Void>());
   * </code>
   */
  public void parse() {
    TokenStream s = new CommonTokenStream(source);
    DegreePlanParser parser = new DegreePlanParser(s);
    if (listener != null) {
      parser.addParseListener(listener);
    }

  }
}
