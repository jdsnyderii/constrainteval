package com.jim;

import com.jim.antlr4.parser.DegreePlanParser;
import com.jim.parser.ParserMain;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jim.antlr4.parser.DegreePlanParser.*;

/**
 * The basic pattern is to create an array of tokens that simulate pushing tokens onto a stack and then parsing them.
 */
public class ParserMainTest {

  @Test
  public void testSimpleAnd() {
    List<Token> tokens = new ArrayList<>();
    ParserMain parserMain = new ParserMain(tokens, new DegreePlanTestListener());

    int[] testTokens = {DEGREE_PLAN_T, AND_REQ_T, COURSELIST_REQ_T, COURSELIST_REQ_T, COURSELIST_REQ_T};
    factoryTokens(parserMain.getTokenFactory(), tokens, testTokens);
    parserMain.parse();
  }

  @Test
  public void testSimpleOr() {
    List<Token> tokens = new ArrayList<>();
    ParserMain parserMain = new ParserMain(tokens, new DegreePlanTestListener());

    int[] testTokens = {DEGREE_PLAN_T, OR_REQ_T, COURSELIST_REQ_T, AND_REQ_T, COURSELIST_REQ_T, COURSELIST_REQ_T};
    factoryTokens(parserMain.getTokenFactory(), tokens, testTokens);
    parserMain.parse();
  }


  private void factoryTokens(TokenFactory factory, List<Token> tokensList, int[] tokensToAdd) {
    Arrays.stream(tokensToAdd).forEachOrdered(
        tokenType -> tokensList.add(factory.create(tokenType, DegreePlanParser.VOCABULARY.getDisplayName(tokenType)))
    );
  }
}
