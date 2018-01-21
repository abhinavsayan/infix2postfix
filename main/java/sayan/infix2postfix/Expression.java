package sayan.infix2postfix;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Expression {

	/**
	 * Make sure the tokens do not have any trailing spaces
	 * 
	 * @param infixtokens
	 * @return
	 */
	public static List<String> eval(String exp) {

		List<String> infixtokens = ExpressionTokenizer.tokenize(exp);
		List<String> postfixExp = new ArrayList<String>();
		Stack<String> stak = new Stack<String>();
		stak.push("(");
		infixtokens.add(")");

		for (int i = 0; i < infixtokens.size(); i++) {
			String token = infixtokens.get(i);
			if (isOperator(token)) {
				String x = stak.pop();
				while (isOperator(x) && precedence(x) >= precedence(token)) {
					postfixExp.add(x);
					x = stak.pop();
				}
				stak.push(x);
				stak.push(token);
			} else if (isOpenParentheses(token)) {
				stak.push(token);
			} else if (isCloseParentheses(token)) {
				String x = stak.pop();
				while (!x.equals("(")) {
					postfixExp.add(x);
					x = stak.pop();
				}
			} else {
				// must be an operand or function
				if (infixtokens.get(i + 1).equals("(")) {
					// opens with the (, must be a function
					postfixExp.add("|");
					int t = i + 2;
					while(!infixtokens.get(t).equals(")")){
						if(!infixtokens.get(t).equals(","))
							postfixExp.add(infixtokens.get(t));
						t++;
					}
					postfixExp.add(token + "()");
					i = t;
				} else {
					postfixExp.add(token);
				}
			}
		}
		return postfixExp;
	}

	private static boolean isOperator(String symbol) {
		if (symbol.equals("^") || symbol.equals("*") || symbol.equals("/") || symbol.equals("+")
				|| symbol.equals("-")) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isOpenParentheses(String symbol) {
		if (symbol.equals("("))
			return true;
		return false;
	}

	private static boolean isCloseParentheses(String symbol) {
		if (symbol.equals(")"))
			return true;
		return false;
	}

	private static int precedence(String symbol) {
		if (symbol.equals("^"))
			return 3;
		else if (symbol.equals("*") || symbol.equals("/"))
			return 2;
		else if (symbol.equals("+") || symbol.equals("-"))
			return 1;
		else
			return 0;

	}

}
