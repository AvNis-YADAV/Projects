package org.cdac.miniproject;

import java.time.LocalDate;
import java.util.Objects;

import org.cdac.miniproject.Experience;
import org.cdac.miniproject.PaySlip;
import org.cdac.miniproject.Hierarchy.BelongingDept;
import org.cdac.miniproject.Hierarchy.Designation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Employee {
	/* 
	 * Basic details of Employee :
	 */
	
	private String name;						
	private LocalDate dob;							
	private String number;						
	private int empid;							
	private String emailId;						
	private String bloodGroup;
	private String projectAssigned;
	private String address;
	private int attendance;						
	private LocalDate joinDate;					
	private int noOfProject;
	private Experience exp;
	private BelongingDept dept;
	private Designation designation;
	private PaySlip individualSlip;
	private double salary;
	
	
	
	public Employee(int empId) {
		this.empid = empId;
	}

	@Override
	public String toString() {
		return String.format("%-8d%-10s%-15s%-15s%-15s%-15s%-30s%-5s%-20s%-5d%-5d%-10.2f",this.empid,this.name,this.dob,this.joinDate,this.dept,this.designation,this.emailId,
				this.bloodGroup,this.address,this.attendance,this.noOfProject,this.salary );	
		}

	public Employee(int empid, String name, String number, LocalDate dob, LocalDate joinDate, BelongingDept dept, Designation designation,
			String emailId, String bloodGroup, String address, int attendance, int noOfProject,double salary) {
		
		this.empid=empid;
		this.name = name;
		this.number = number;
		this.dob =dob;
		this.joinDate = joinDate;
		this.dept =dept;
		this.designation = designation;
		this.emailId = emailId;
		this.bloodGroup = bloodGroup;
		this.address = address;
		this.attendance =attendance;
		this.noOfProject = noOfProject;
		this.salary = salary;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empid == other.empid;
	}


}

