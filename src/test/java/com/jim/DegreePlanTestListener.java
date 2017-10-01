package com.jim;

import com.jim.antlr4.parser.DegreePlanListener;
import com.jim.antlr4.parser.DegreePlanParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class DegreePlanTestListener implements DegreePlanListener {

  @Override
  public void enterParse(DegreePlanParser.ParseContext ctx) {
    logIndentedMessage("Starting DegreePlan", ctx);
  }

  @Override
  public void exitParse(DegreePlanParser.ParseContext ctx) {
    logIndentedMessage("--------------------", ctx);
  }

  @Override
  public void enterDegree_plan(DegreePlanParser.Degree_planContext ctx) {
    logIndentedMessage("enter Degree_plan", ctx);
  }

  @Override
  public void exitDegree_plan(DegreePlanParser.Degree_planContext ctx) {
    logIndentedMessage("exit Degree_plan", ctx);
  }

  @Override
  public void enterDegree_plan_req(DegreePlanParser.Degree_plan_reqContext ctx) {
    logIndentedMessage("enter Degree_plan_req", ctx);

  }

  @Override
  public void exitDegree_plan_req(DegreePlanParser.Degree_plan_reqContext ctx) {
    logIndentedMessage("exit Degree_plan_req", ctx);

  }

  @Override
  public void enterCourse_list_req(DegreePlanParser.Course_list_reqContext ctx) {
    logIndentedMessage("enter COURSE_REQ_LIST", ctx);
  }

  @Override
  public void exitCourse_list_req(DegreePlanParser.Course_list_reqContext ctx) {
    logIndentedMessage("exit COURSE_REQ_LIST", ctx);
  }

  @Override
  public void enterN_ary_boolean_req(DegreePlanParser.N_ary_boolean_reqContext ctx) {
    logIndentedMessage("enter Nary Boolean Requirement", ctx);
  }

  @Override
  public void exitN_ary_boolean_req(DegreePlanParser.N_ary_boolean_reqContext ctx) {
    logIndentedMessage("exit Nary Boolean Requirement", ctx);
  }

  @Override
  public void enterAnd_req(DegreePlanParser.And_reqContext ctx) {
    logIndentedMessage("enter And Boolean Requirement", ctx);
  }

  @Override
  public void exitAnd_req(DegreePlanParser.And_reqContext ctx) {
    logIndentedMessage("exit And Boolean Requirement", ctx);

  }

  @Override
  public void enterOr_req(DegreePlanParser.Or_reqContext ctx) {
    System.out.println("enter Or Boolean Requirement");
  }

  @Override
  public void exitOr_req(DegreePlanParser.Or_reqContext ctx) {
    System.out.println("exit Or Boolean Requirement");
  }

  @Override
  public void visitTerminal(TerminalNode node) {

  }

  @Override
  public void visitErrorNode(ErrorNode node) {

  }

  @Override
  public void enterEveryRule(ParserRuleContext ctx) {
  }

  @Override
  public void exitEveryRule(ParserRuleContext ctx) {

  }

  private void logIndentedMessage(String message, ParserRuleContext ctx) {
    int indent = (ctx.children != null) ? ctx.children.size() * 2 : 0;
    if (indent > 0) {
      String format = "%" + indent + "s";
      System.out.printf(format, " ");
    }
    System.out.printf("%s\n", message);
  }
}
