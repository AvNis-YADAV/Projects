package org.cdac.miniproject;

import java.util.List;
import java.util.Scanner;

public class Test {

	public int menuList() {

		Scanner sc = new Scanner(System.in);
		System.out.println("0.Exit");
		System.out.println("1.Add employee details");
		System.out.println("2.Update Employee details");
		System.out.println("3.Find best employee");
		System.out.println("4.Remove employee details");
		System.out.println("5.View employee details");

		System.out.println("Enter Choice");
		return sc.nextInt();

	}

}
