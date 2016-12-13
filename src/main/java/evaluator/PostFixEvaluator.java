package evaluator;

import java.security.spec.PSSParameterSpec;
import java.util.Stack;

public class PostFixEvaluator {
  
  public final String expression;
  
  public PostFixEvaluator(String expression) {
    this.expression = expression;
  }
  
  Stack<Double> pfStack = new Stack<Double>();
  
  public Double evaluate(){
    String [] exprArray = expression.split("\\s+");
    for ( String elem : exprArray){
      if ( isOperator(elem)){
          Double operand2 = pfStack.pop();
          Double operand1 = pfStack.pop();
          switch (elem) {
          case "*":
            pfStack.push(operand1 * operand2);
            break;
          case "+":
            pfStack.push(operand1 + operand2);
            break;
          case "-":
            pfStack.push(operand1 - operand2);
            break;
          case "/":
            pfStack.push(operand1 / operand2);
            break;
          case "^":
            pfStack.push(Math.pow(operand1, operand2));
            break;
          default:
            throw new RuntimeException("Unsupported operator");
        }
      }else{
        pfStack.push(Double.parseDouble(elem));
      }
    }
    
    if ( pfStack.isEmpty()){
      throw new RuntimeException("Stack is empty, no result found");
    }
    return pfStack.pop();
  }
  
  private boolean isOperator(String element){
    switch (element) {
    case "+":
    case "-":
    case "/":
    case "*":
    case "^":
      return true;
    default:
      return false;
    }
  }
  
}
