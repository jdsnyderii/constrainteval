package com.jim;

import com.jim.evaluation.Expression;
import com.jim.evaluation.ExpressionType;
import com.jim.evaluation.RequirementSatisfyingOperator;

public class Main {

  public static void main(String[] args) {

    RequirementSatisfyingOperator op1 = new RequirementSatisfyingOperator("op1");

    Expression expr = new Expression(op1, new ExpressionType());
  }

}
