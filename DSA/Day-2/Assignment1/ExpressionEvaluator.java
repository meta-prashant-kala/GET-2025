package Assignment1;
import java.util.ArrayList;
import java.util.List;

public class ExpressionEvaluator {

    /**
     * Method to evaluate operand1 and operand2 as per the input operator
     * 
     * @param operand1 should be of int type
     * @param operand2 should be of int type
     * @param operator should be of string type holding the operator
     * @return the operated value of operator on operand1 by operand2
     */
    public int evaluateValues(int operand1, int operand2, String operator) {
        int value = 0;
        switch (operator) {
            case "+":
                value = operand1 + operand2;
                break;
            case "-":
                value = operand1 - operand2;
                break;
            case "/":
                if(operand2==0){
                    throw new UnsupportedOperationException("Division by zero exception");
                }
                value = operand1 / operand2;
                break;
            case "*":
                value = operand1 * operand2;
                break;
            case ">":
                if (operand1 > operand2) {
                    return 1;
                }
                break;
            case "<":
                if (operand1 < operand2) {
                    return 1;
                }
                break;
            case "&&":
                if (operand1 > 0 && operand2 > 0) {
                    return 1;
                }
                break;
            case "||":
                if (operand1 > 0 || operand2 > 0) {
                    return 1;
                }
                break;
            case "==":
                if (operand1 == operand2) {
                    return 1;
                }
                break;
            case "!=":
                if (operand1 != operand2) {
                    return 1;
                }
                break;
            case ">=":
                System.out.println(operand1 + " " + operand2);
                if (operand1 >= operand2) {
                    return 1;
                }
                break;
            case "<=":
                if (operand1 <= operand2) {
                    return 1;
                }
                break;

            default:
                throw new IllegalArgumentException("Entered operator is not supported");
        }
        return value;
    }

    /**
     * Method to get the precedence of every operator
     * 
     * @param operator should be of String type holding the operator
     * @return precedence of input operator
     */
    public int getPrecedence(String operator) {
        if ("&&".equals(operator) || "||".equals(operator)) {
            return 0;
        }
        if ("<".equals(operator) || ">".equals(operator) ||
                "==".equals(operator) || "!=".equals(operator) ||
                "<=".equals(operator) || ">=".equals(operator)) {
            return 1;
        }
        if ("+".equals(operator) || "-".equals(operator)) {
            return 2;
        }
        if ("*".equals(operator) || "/".equals(operator)) {
            return 3;
        }
        return -1;
    }

    /**
     * Mehtod to the List of operand and operations from the expression seperated by
     * spaces
     * 
     * @param expression should be of String type holding the expression to evaluate
     * @return List of operand and operations
     */
    public List<String> getExpressionList(String expression) {
        List<String> expressionList = new ArrayList<String>();
        int i = 0;
        while (i < expression.length()) {
            String str = "";
            while (i < expression.length() && expression.charAt(i) == ' ') {
                i++;
            }
            while (i < expression.length() && expression.charAt(i) != ' ') {
                str += expression.charAt(i);
                i++;
            }
            if (!"".equals(str)) {
                expressionList.add(str);
            }
        }
        return expressionList;
    }

    /**
     * Method to check if a String holds a number or not
     * 
     * @param str should be of string type
     * @return true if the string holds a number, otherwise false
     */
    public boolean isNumber(String str) {
        try {
            @SuppressWarnings("unused")
            int num = Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method to get the postfix expression from the infix expression list
     * 
     * @param infixExpressionList should be of List type holding the infix
     *                            expression
     * @return postfix expression in the form String
     */
    public String getPostFixExpression(List<String> infixExpressionList) {
        String postfixExpression = "";
        Stack<String> customStack = new CustomStack<String>(infixExpressionList.size());
        for (String str : infixExpressionList) {
            if (this.isNumber(str)) {
                postfixExpression += str + " "; 
            } else if ("(".equals(str)) {
                customStack.push(str);
            } else if (")".equals(str)) {
                while (!customStack.isEmpty() && !customStack.peek().equals("(")) {
                    postfixExpression += customStack.pop() + " ";
                }
                customStack.pop();
            } else {
                while (!customStack.isEmpty() && this.getPrecedence(str) < this.getPrecedence(customStack.peek())) {

                    postfixExpression += customStack.pop() + " ";
                }
                customStack.push(str);

            }
        }

        while (!customStack.isEmpty()) {
            postfixExpression += customStack.pop() + " ";
        }
        return postfixExpression;
    }

    /**
     * Method to evaluate a infix expression by converting it to postfix and then
     * evaluating it.
     * 
     * @param expression should be of string type holding the infix expression
     * @return evaluated value of the inputed expression
     */
    public int evaluateExpression(String expression) {

        Integer evaluatedValue = null;

        List<String> expressionList = getExpressionList(expression);

        String postfixExpression = this.getPostFixExpression(expressionList);

        List<String> postFixExpList = getExpressionList(postfixExpression);

        Stack<String> customStack = new CustomStack<String>(postFixExpList.size());
        
        for (String str : postFixExpList) {
            if (isNumber(str)) {
                customStack.push(str);
            } else {
                if (customStack.isEmpty()) {
                    throw new IllegalArgumentException("Input expression is not valid");
                }
                int op2 = Integer.parseInt(customStack.pop());
                if (customStack.isEmpty()) {
                    throw new IllegalArgumentException("Input expression is not valid");
                }
                int op1 = Integer.parseInt(customStack.pop());
                String operator = str;
                String evaluatedVal = String.valueOf(evaluateValues(op1, op2, operator));
                customStack.push(evaluatedVal);
            }
        }

        if (customStack.isEmpty()) {
            throw new IllegalArgumentException("Input expression is not valid");
        }
        evaluatedValue = Integer.parseInt(customStack.pop());

        if (!customStack.isEmpty()) {
            throw new IllegalArgumentException("Input expression is not valid");
        }

        return evaluatedValue;
    }

}
