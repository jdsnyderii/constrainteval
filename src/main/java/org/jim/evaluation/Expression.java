package org.jim.evaluation;

public class Expression {

  private Operator operator;
  private ExpressionType resultType;
  private ExpressionResult result;

  public Operator getOperator() {
    return operator;
  }

  public ExpressionType getResultType() {
    return resultType;
  }

  public Expression(Operator operator, ExpressionType resultType) {
    this.resultType = resultType;
    this.operator = operator;
  }


  public ExpressionResult eval(EvaluationContext context) {
    result = operator.eval(context);
    return result;
  }
}
