/*
 * CS211 Chapter 14 - Converter.java
 * Jason Sy, 11/13/2021, Fall 2021
 *
 * Converts infix notation to postfix notation.
 */

// CS 211 HW 6
//   Converter can convert from infix notation to postfix notation
//
//   for exmaple, the infix is:
//   3 + 2
//
//   the converted postfix is:
//   3 2 +
//
import java.io.*;
import java.util.*;

public class Converter {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO: change path to match where your input file is located
        File f = new File("/expressions.txt");
        Scanner s = new Scanner(f);

        while(s.hasNextLine()) {
            Converter c = new Converter(s.nextLine());
            System.out.println("infix:   " + c.getInfix());
            System.out.println("postfix: " + c.getPostfix());

            Evaluator e = new Evaluator(c.getPostfix());
            System.out.println(" result: " + e.evaluate());
            System.out.println("---");
        }
    }

    String infix;
    public Converter(String infix) {
        this.infix = infix;
    }

    public String getInfix() {
        return infix;
    }

    public String getPostfix() {
        // TODO: implement
        String postfix = "";
        // leverage Tokenizer.java
        Tokenizer t = new Tokenizer(infix);
        Stack<String> s = new Stack<>();
        while (t.hasNextToken()) {
            String token = t.nextToken();
            // case for left parenthesis
            if(token.equals("(")) {
                s.push(token);
            }
            // case for right parenthesis
            else if(token.equals(")")) {
                while(!s.peek().equals("(")) {
                    postfix += " " + s.pop();
                }
                s.pop();
            }
            // case for operators
            else if((token.equals("+")) || (token.equals("-")) || (token.equals("*")) || (token.equals("/"))) {
                s.push(token);
            }
            else {
                postfix += " " + token;
            }
        }
        while(!s.isEmpty()) {
            postfix += " " + s.pop();
        }
        return postfix;
    }


}


