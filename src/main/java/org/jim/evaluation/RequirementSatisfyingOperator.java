package org.jim.evaluation;

public class RequirementSatisfyingOperator extends UnaryOperator implements Operator {


  private String opName;

  public RequirementSatisfyingOperator(String opName) {
    setOpName(opName);
  }

  @Override
  public ExpressionResult eval(EvaluationContext context) {
    return new ExpressionResult();
  }
}
