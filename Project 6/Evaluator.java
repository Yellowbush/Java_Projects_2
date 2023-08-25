/*
 * CS211 Chapter 14 - Evaluator.java
 * Jason Sy, 11/13/2021, Fall 2021
 *
 * Evaluates postfix expression.
 */

// CS 211 HW 6
//   Evaluator can evaluate the postfix expression
//
//   for exmaple, the postfix is:
//   3 2 +
//
//   the evaluation result should be 5.0
//
import java.util.*;

public class Evaluator {
    private String postfix;
    public Evaluator(String postfix) {
        this.postfix = postfix;
    }

    public double evaluate() {
        // TODO: implement
        // scanner to read postfix
        Scanner scan = new Scanner(postfix);
        Stack<Double> s = new Stack<>();
        String operators = "+-*/";

        while(scan.hasNext()) {
            // read each token
            String token = scan.next();
            // case for token is a number
            if(!operators.contains(token)) {
                double number = Double.parseDouble(token);
                s.push(number);
            }
            // case for operators
            else {
                double v2 = s.pop();
                double v1 = s.pop();
                // push result back into stack while utilizing calculate
                s.push(calculate(token, v1, v2));
            }

        }
        return s.pop();
    }

    private double calculate(String operator, double op1, double op2) {
        if (operator.equals("+")) {
            return op1 + op2;
        } else if (operator.equals("-")) {
            return op1 - op2;
        } else if (operator.equals("*")) {
            return op1 * op2;
        } else if (operator.equals("/")) {
            return op1 / op2;
        } else {
            // impossible
            return -9999.0;
        }
    }
}
