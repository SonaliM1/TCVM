package com.tcvm.serviceclass;

import java.util.Scanner;

public class InputScanner {
	final Scanner scanner;

	public InputScanner() {
		this.scanner = new Scanner(System.in);
	}

	public int nextInt() {
		return scanner.nextInt();
	}

}