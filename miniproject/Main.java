package org.cdac.miniproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<>();
		Utils ut = new Utils();
		
		// to add data into employee list
		ut.emps(employeeList);

		Test ts = new Test();
		PaySlip ps=new PaySlip();
		ps.setSal(employeeList);
		
		int choice;
		while ((choice = ts.menuList()) != 0) {
			switch (choice) {
			case 1:
				Utils.addEmployee(employeeList);
				break;
			case 2:
				Utils.updateEmployee( employeeList);
				break;
			case 3:
				ut.bestEmployee(employeeList);
				break;
	
			case 4:
				ut.removeEmployee(employeeList);
				break;


			case 5:
				System.out.println(
						"********************************************************** Employee Details ***************************************************************************************");
				 System.out.println("EmpId \tEmp_Name     D.O.B     \t  D.O.J \t Department\tDesignation\t   Email_ID \t\t Bl.Gr \t Address \t Attd.\tNOP \t Salary");
				 System.out.println(
							"************************************************************************************************************************************************************");
				 printRecord(employeeList);
				 System.out.println(
							"************************************************************************************************************************************************************");
				break;
			}
		
		}
	}

	public static void printRecord(List<Employee> employeeList) {
		for (Employee employee : employeeList) {
			System.out.println(employee.toString());
		}
	}
}
