package com.glearning.dsaLab3Q1;

import java.util.Scanner;

public class Client1 {

	public static void main(String[] args) {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println(
					"\nEnter any combination of brackets e.g [{{}}] etc to find if brackets entered are balanced i.e each opening has a closing bracket or press q to quit: ");

			String input = sc.next();
			if (input.equals("q")) {
				flag = false;
				continue;
			}

			boolean result = BalancedBracket.isBalanced(input);
			System.out.println("Is the input balanced, true or false? " + result);

		}
		sc.close();
	}

}
