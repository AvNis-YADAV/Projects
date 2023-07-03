package org.cdac.miniproject;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.cdac.miniproject.Employee;
import org.cdac.miniproject.Experience;
import org.cdac.miniproject.PaySlip;
import org.cdac.miniproject.Hierarchy.BelongingDept;
import org.cdac.miniproject.Hierarchy.Designation;

public class Utils {

	private static Scanner sc = new Scanner(System.in);
	public static void addEmployee(List<Employee> employeeList) {
		// Take inputs below
		while(true) {
		sc.nextLine();
		System.out.println("Enter employee Name:");
		String name = sc.nextLine();
		if (!InputValidator.nameValidator(name)) {
			System.out.println("Please enter valid name....");
		} else {
		LocalDate dob= null;
		try {
			System.out.println("Enter employee Date of birth :");
			String temp = sc.nextLine();
			dob = LocalDate.parse(temp);
		} catch (Exception e) {
			System.out.println("Enter Date of Birth in 'YYYY-MM-DD' ");
			e.printStackTrace();
		}
		
		System.out.println("Enter employee Phone Number :");
		String number = sc.nextLine();
		
		if (!InputValidator.PhoneValidator(number)) {
			System.out.println("Please enter valid Number....");
		} else {
		System.out.println("Enter employee id :");
		int empid = sc.nextInt();
		
		System.out.println("Enter employee Base Pay :");
		double basePay = sc.nextDouble();
		sc.nextLine();
		System.out.println("Enter employee Blood Group :");
		String bloodGroup = sc.nextLine();

		System.out.println("Enter employee Email_Id :");
		String emailId = sc.nextLine();

		System.out.println("Enter employee Project Assigned :");
		String projectAssigned = sc.nextLine();

		System.out.println("Enter employee Address :");
		String address = sc.nextLine();

		System.out.println("Enter employee Attendance :");
		int attendance = sc.nextInt();

		System.out.println("Enter employee Join Date :");
		sc.nextLine();
		String jd = sc.nextLine();
		LocalDate joinDate = LocalDate.parse(jd);
		
		System.out.println("Enter employee Number of Project Done :");
		int noOfProject = sc.nextInt();
		
		int choice;
		System.out.println("Enter  Department");
		Hierarchy.BelongingDept dept = null;
		// ASSOCIATE, EXECUTIVE, SENIOREXEC, LEAD, MANAGER
		while ((choice = Utils.printdepartment()) != 0) {
			switch (choice) {
			case 1:
				dept = Hierarchy.BelongingDept.HUMANRESOURCE;
				break;
			case 2:
				dept = Hierarchy.BelongingDept.DEPLOYMENT;
				break;
			case 3:
				dept = Hierarchy.BelongingDept.DEVELOPMENT;
				break;

			}
			break;
		}
		System.out.println("Enter Designation");
		Hierarchy.Designation designation = null;
		while ((choice = Utils.printdesignation()) != 0) {
			switch (choice) {
			case 1:
				designation = Designation.ASSOCIATE;
				break;
			case 2:
				designation = Designation.EXECUTIVE;
				break;
			case 3:
				designation = Designation.SENIOREXEC;
				break;
			case 4:
				designation = Designation.LEAD;
				break;
			case 5:
				designation = Designation.MANAGER;
				break;

			}
			break;
		}
		System.out.println("Enter Salary :");
		double salary =sc.nextDouble();
		Employee emp = new Employee(empid, name, number, dob, joinDate, dept, designation, emailId,
				bloodGroup, address, attendance, noOfProject, salary);
		
		Experience exp = new Experience(emp);
		exp.calculateExp();
		emp.setExp(exp);
		PaySlip individualSlip = new PaySlip(emp);
		individualSlip.calcNetSalary();
		emp.setIndividualSlip(individualSlip);

		employeeList.add(emp);

		System.out.println("Employee added successfully !!");

		break;
		}
	}
		}
	}
	private static int printdepartment() {
		System.out.println("1. HUMAN RESOURCE");
		System.out.println("2. DEPLOYMENT");
		System.out.println("3. DEVELOPMENT");
		return sc.nextInt();
	}
	// Create employee to send forward to Experience class to calculate experience
	// of employee

	public static int printdesignation() {

		System.out.println("1.ASSOSCIATE");
		System.out.println("2.EXECUTIVE");
		System.out.println("3.SENIOR EXECUTIVE");
		System.out.println("4.LEAD");
		System.out.println("5.MANAGER");
		return sc.nextInt();
	}

	public static void updateEmployee(List<Employee> employeeList) {
		boolean found= false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter empid :");
		int empid = sc.nextInt();

		Employee other = new Employee();
		other.setEmpid(empid);
		if (employeeList.contains(other)) {
			    found = true;
				Employee employee = employeeList.get(employeeList.indexOf(other));
				System.out.println("Enter new name:");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println("Enter new designation:");
				String designation = sc.nextLine();
				System.out.println("Enter new salary:");
				double salary = sc.nextDouble();
				int choice;
				employee.setName(name);
				while ((choice = Utils.printdepartment()) != 0) {
					switch (choice) {
					case 1:
						employee.setDept(Hierarchy.BelongingDept.HUMANRESOURCE);
						break;
					case 2:
						employee.setDept(Hierarchy.BelongingDept.DEPLOYMENT);
						break;
					case 3:
						employee.setDept(Hierarchy.BelongingDept.DEVELOPMENT);
						break;

					}
					break;
				}

				
				// ASSOCIATE, EXECUTIVE, SENIOREXEC, LEAD, MANAGER
				while ((choice = Utils.printdesignation()) != 0) {
					switch (choice) {
					case 1:

						employee.setDesignation(Designation.ASSOCIATE);
						break;
					case 2:
						employee.setDesignation(Designation.EXECUTIVE);
						break;
					case 3:
						employee.setDesignation(Designation.SENIOREXEC);
						break;
					case 4:
						employee.setDesignation(Designation.LEAD);
						break;
					case 5:
						employee.setDesignation(Designation.MANAGER);
						break;

					}
					employee.setSalary(salary);

					System.out.println("Employee updated successfully");
					break;
				}
			
	
			if (!found) {
				System.out.println("Employee not found");
			}
		}
	}

	public void bestEmployee(List<Employee> employeeList) {
		int maxProject = 0;

		for (Employee employee : employeeList) {
			if (employee.getAttendance() >= 95 && employee.getNoOfProject() > 3) {
				if (maxProject < employee.getNoOfProject()) {
					maxProject = employee.getNoOfProject();
				}

			}
		}
		for (Employee employee : employeeList) {
			if (maxProject == employee.getNoOfProject()) {
				System.out.println(employee.getName() + " is the Best Employee of the month !!!!");
			}
		}
	}

	public void bonus(List<Employee> employeeList) {

		for (Employee employee : employeeList) {
			if (employee.getAttendance() >= 95) {
				double attendanceBonus = 10000;
				double performanceBonus = 25000;
				// employee.salary+= attendanceBonus+performanceBonus;
			} else if (employee.getAttendance() >= 85 && employee.getAttendance() < 95) {
				double attendanceBonus = 8000;
				double performanceBonus = 22000;
				// employee.salary+= attendanceBonus+performanceBonus;
			} else {
				double attendanceBonus = 1000;
				double performanceBonus = 0;
				employee.getIndividualSlip().setGrossSalary(
						employee.getIndividualSlip().getGrossSalary() + (attendanceBonus + performanceBonus));
//				setSalary(employee.getSalary() + (attendanceBonus+performanceBonus));
			}
		}
		for (Employee employee : employeeList) {
			System.out.println(employee.getName() + " " + employee.getIndividualSlip().getNetPay());
		}
	}

	public void removeEmployee(List<Employee> employeeList) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter empid :");
		int empid = sc.nextInt();

		Employee other = new Employee();
		other.setEmpid(empid);
		if (employeeList.contains(other)) {
			employeeList.remove(other);
			System.out.println("Employee successfully Removed !!!");
		} else
			System.out.println("Employee not found !!");
	}

	// to add dummy data of employee into employee list
	public void emps(List<Employee> employeeList) {

		Employee emp1 = new Employee(121, "Shivani", "9876543217", LocalDate.parse("1996-06-12"),
				LocalDate.parse("2011-01-01"), BelongingDept.DEPLOYMENT, Designation.ASSOCIATE, "Shivani@gmail.com",
				"B-", "Chennai", 96, 2,30001.2);
		Experience exp = new Experience(emp1);
		exp.calculateExp();
		emp1.setExp(exp);
		employeeList.add(emp1);
		PaySlip ps=new PaySlip(emp1);
		ps.calcNetSalary();
		emp1.setIndividualSlip(ps);

		Employee emp2 = new Employee(132, "umesh", "9876543217", LocalDate.parse("1996-06-12"),
				LocalDate.parse("2011-01-01"), BelongingDept.DEVELOPMENT, Designation.ASSOCIATE, "umesh@gmail.com",
				"B-", "Chennai", 96, 2,24052.2);
		Experience exp1 = new Experience(emp2);
		exp1.calculateExp();
		emp2.setExp(exp1);
		employeeList.add(emp2);
		PaySlip ps1=new PaySlip(emp2);
		ps1.calcNetSalary();
		emp2.setIndividualSlip(ps1);
		
		Employee emp3 = new Employee(321, "Tushar", "9876541230", LocalDate.parse("1980-02-21"), LocalDate.parse("2005-08-01"), Hierarchy.BelongingDept.DEVELOPMENT, Hierarchy.Designation.SENIOREXEC, "tushar21@corscent.com",
				"B+", "Indore", 95, 25,152469.2);
		Experience exp2 = new Experience(emp3);
		exp2.calculateExp();
		emp3.setExp(exp2);
		employeeList.add(emp3);
		
		Employee emp4 = new Employee(322, "Ashish", "9876541231", LocalDate.parse("1985-03-15"), LocalDate.parse("2007-02-01"), Hierarchy.BelongingDept.DEPLOYMENT, Hierarchy.Designation.SENIOREXEC, "umesh15@corscent.com",
				"B-", "Pune", 96, 20,123245.2);
		Experience exp3 = new Experience(emp4);
		exp3.calculateExp();
		emp4.setExp(exp3);
		employeeList.add(emp4);
		
		Employee emp5 = new Employee(323, "Anita", "9876541232", LocalDate.parse("1990-04-11"), LocalDate.parse("2017-10-11"), Hierarchy.BelongingDept.HUMANRESOURCE, Hierarchy.Designation.EXECUTIVE, "anita11@corscent.com",
				"AB+", "Banglore", 92, 0,90456.2);
		Experience exp4 = new Experience(emp5);
		exp4.calculateExp();
		emp5.setExp(exp4);
		employeeList.add(emp5);
		
		Employee emp6 = new Employee(326, "Vishal", "9876541235", LocalDate.parse("1993-01-31"), LocalDate.parse("2017-08-01"), Hierarchy.BelongingDept.HUMANRESOURCE, Hierarchy.Designation.LEAD, "vishal31@corscent.com",
				"AB-", "Gandhi Nagar", 92, 0,145622.2);
		Experience exp5 = new Experience(emp6);
		exp5.calculateExp();
		emp6.setExp(exp5);
		employeeList.add(emp6);
		
		Employee emp7 = new Employee(324, "Sangita", "9876541233", LocalDate.parse("1991-02-01"), LocalDate.parse("2015-08-01"), Hierarchy.BelongingDept.DEVELOPMENT, Hierarchy.Designation.MANAGER, "sangita01@corscent.com",
				"O+", "Mumbai", 70, 15,235662.3);
		Experience exp6 = new Experience(emp7);
		exp6.calculateExp();
		emp7.setExp(exp6);
		employeeList.add(emp7);
		
		Employee emp8 = new Employee(325, "Aditya", "9876541234", LocalDate.parse("1992-08-23"), LocalDate.parse("2016-08-01"), Hierarchy.BelongingDept.DEVELOPMENT, Hierarchy.Designation.ASSOCIATE, "aditya23@corscent.com",
				"O-", "Goa", 96, 11,36585.2);
		Experience exp7 = new Experience(emp8);
		exp7.calculateExp();
		emp8.setExp(exp7);
		employeeList.add(emp8);
		
		Employee emp9 = new Employee(327, "Mayank", "9876541236", LocalDate.parse("1987-08-21"), LocalDate.parse("2009-08-01"), Hierarchy.BelongingDept.DEPLOYMENT, Hierarchy.Designation.MANAGER, "mayank21@corscent.com",
				"B+", "Amravati", 75, 2,235269.2);	
		Experience exp8 = new Experience(emp9);
		exp8.calculateExp();
		emp9.setExp(exp8);
		employeeList.add(emp9);
		
		Employee emp10 = new Employee(328, "Sonal", "9876541237", LocalDate.parse("1996-02-21"), LocalDate.parse("2020-08-01"), Hierarchy.BelongingDept.DEVELOPMENT, Hierarchy.Designation.LEAD, "sonal21@corscent.com",
				"A+", "Ujjan", 89, 3,121568.5);
		Experience exp9 = new Experience(emp10);
		exp9.calculateExp();
		emp10.setExp(exp9);
		employeeList.add(emp10);
		
		
		
	}

}
