package org.jim.evaluation;

public class NaryOperator implements Operator {

  private String opName = "nop";

  @Override
  public String getOpName() {
    return opName;
  }

  @Override
  public void setOpName(String opName) {
    this.opName = opName;
  }

  @Override
  public ExpressionResult eval(EvaluationContext context) {
    return null;
  }

}
