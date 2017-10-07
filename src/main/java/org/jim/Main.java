package org.jim;

import org.jim.evaluation.Expression;
import org.jim.evaluation.ExpressionType;
import org.jim.evaluation.RequirementSatisfyingOperator;

public class Main {

  public static void main(String[] args) {

    RequirementSatisfyingOperator op1 = new RequirementSatisfyingOperator("op1");

    Expression expr = new Expression(op1, new ExpressionType());
  }

}
