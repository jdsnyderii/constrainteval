package com.jim.evaluation;

public interface Operator {
  void setOpName(String opName);
  String getOpName();

  ExpressionResult eval(EvaluationContext context);
}
