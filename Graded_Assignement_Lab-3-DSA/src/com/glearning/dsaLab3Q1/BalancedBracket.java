package com.glearning.dsaLab3Q1;

import java.util.Stack;

public class BalancedBracket {
	// String brackets= "([[{}]])";
	char c;
	// boolean b=isBalanced(brackets);

	public static boolean isBalanced(String input) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' || c == ']' || c == '}') {

				// check if stack is empty before popping
				if (stack.empty()) {
					return false;
				}
				// start popping elements from the stack
				// if no matching closing bracket, return false

				// return false;
				char top = stack.pop();
				if ((c == ')' && top != ')') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
					return false;
				}
			}
		}
		return stack.empty();
	}
}
