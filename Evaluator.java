/**
 * This class implements postfix evaluator
 * @author Clary Nguyen
 * @version 4/5/2022
 */
import java.util.Scanner;
public class Evaluator {
    private StackLL<Integer> stack;
    private String expression;
    //this var is to check if the expression is in wrong order, 
    //has too many operators, or not enough operators
    private boolean flag = true;
    //this var is to check if the expression contains only an integer 
    //and nothing else
    private boolean oneOperatorExpression = true;

    //Constructor gets the parameter as the parameter
    public Evaluator(String expression){
        //initiate a new StackLL object
        this.stack = new StackLL<Integer>();
        this.expression = expression;
    }
    /**
     * This method reads individual numbers and operators from 
     * the expression and evaluates the expression if possible
     */
    public void readExpression(){
        String token;
        Scanner parser = new Scanner(expression);
        //read each token and evaluate if possible until the end of the expression
        while(parser.hasNext()){
            token = parser.next();
            //if the token is an integer
            if(!this.operators(token.charAt(0))){
                //push the token to the stack
                stack.push(Integer.parseInt(token));
            //otherwise, it is an operator
            }else{
                //if possible, evaluate the operands in the stack using the operator
                if(flag){
                    this.operation(token);
                //else, stop traversing through the expression
                }else{
                    break;
                }
            }
        }
        //close the Scanner object
        parser.close();
    }
    /**
     * Return the result of the stack or a warning message if the
     * expressions cannot be evaluated
     * @return the result or a warning message
     */
    public String getStack(){
        //if the expression can be evaluated, return it
        if(flag && !twoElements(stack) && !oneOperatorExpression){
            oneOperatorExpression = true;
            return this.stack.toString();
        }
        flag = true;
        //otherwise, return a warning message
        return "Bad input!";
    }
    /**
     * This method check if the tokens are operators
     * @param operator passed-in token
     * @return true if it is an operator, false otherwise
     */
    public boolean operators(char operator){
        //only check +, -, *, and /
        char[] operatorsArr = {'+', '-', '*', '/'};
        //check if the token is an operator
        for(char o: operatorsArr){
            if(operator == o){
                return true;
            }
        }return false;
    }
    /**
     * This method multiply the operands
     * @param first first passed-in integer
     * @param second second passed-in integer
     * @return the product
     */
    public int multiply(int first, int second){
        return first * second;
    }
    /**
     * This method add the 2 passed-in integers
     * @param first the first integer
     * @param second the second integer
     * @return the sum
     */
    public int add(int first, int second){
        return first + second;
    }
    /**
     * This method subtract the first integer from the second integer
     * @param first the first integer
     * @param second the second integer
     * @return the subtraction
     */
    public int subtract(int first, int second){
        return second - first;
    }
    /**
     * This method divide the second by the first integer
     * @param first the divisor
     * @param second the dividend
     * @return the result
     */
    public int divide(int first, int second){
        return second / first;
    }
    /**
     * This method checks if the stack of integers has at least 2 values
     * @param stack the stack of integers (operands)
     * @return true if the stack has at least 2 values, false otherwise
     */
    public boolean twoElements(StackLL<Integer> stack){
        int temp = 0;
        for(int i = 0; i < 2; i ++){
            //if i gets to 1, then the stack must have at least 2 values
            if(i == 1){
                stack.push(temp);
                break;
            }
            temp = stack.pop();
            //stop the loop because the stack is now empty - return false,
            //the stack only has 1 value
            if(stack.isEmpty()){
                stack.push(temp);
                return false;
            }
        }
        return true;
    }
    /**
     * This method executes the evaluation
     * @param operator operator for evaluation
     */
    public void operation(String operator){
        //if the stack is not empty and has at least 2 values
        if(!stack.isEmpty() && twoElements(stack)){
            //depending on the operators, execute appropriate operation:
            //addition
            if(operator.equals("+")){
                int result = this.add(stack.pop(), stack.pop());
                stack.push(result);
            //subtraction
            }else if(operator.equals("-")){
                int result = this.subtract(stack.pop(), stack.pop());
                stack.push(result);
            //multiplication
            }else if(operator.equals("*")){
                int result = this.multiply(stack.pop(), stack.pop());
                stack.push(result);
            //division
            }else{
                int result = this.divide(stack.pop(), stack.pop());
                stack.push(result);
            }
            oneOperatorExpression = false;
        } else{
            flag = false;
        }
    }
}
