package org.jim.evaluation;

public abstract class UnaryOperator implements Operator {

  private String opName = "unary nop";

  @Override
  public void setOpName(String opName) {
    this.opName = opName;
  }

  @Override
  public String getOpName() {
    return opName;
  }

}
