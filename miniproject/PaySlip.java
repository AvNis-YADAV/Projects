package org.cdac.miniproject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import org.cdac.miniproject.Hierarchy.Designation;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaySlip {

	private double basicPay;
	private double hra;
	private double da;
	private double incomeTax;
	private double professionTax;
	private double providendFund;
	private double grossSalary;
	private double totalDeductions;
	private double netPay;
	private Employee emp;
	
	public PaySlip(Employee emp) {
		this.emp = emp;
		//System.out.println(getEmp().getExp().toString() + "    " + getEmp().getDept());

	}
	
	public void setSal(List<Employee> empolyeeList) {
		for(Employee employee:empolyeeList) {
			
			Experience exp = new Experience(employee);
			exp.calculateExp();
			employee.setExp(exp);
			
			
		}
	}
	
	public void calcNetSalary() {
		double expFactor = ((getEmp().getExp().getYears() * 12 + getEmp().getExp().getMonths()) * 0.1) + 1;
		double daRate = 0, hraRate = 0;

		if (getEmp().getDesignation() == Designation.ASSOCIATE || getEmp().getDesignation() == Designation.EXECUTIVE
				|| getEmp().getDesignation() == Designation.SENIOREXEC) {
			hraRate = 0.15;
			daRate = 0.4;
		}
		if (getEmp().getDesignation() == Designation.LEAD || getEmp().getDesignation() == Designation.MANAGER) {
			hraRate = 0.1;
			daRate = 0.35;
		}

		switch (getEmp().getDept()) {

		case HUMANRESOURCE:
			switch (getEmp().getDesignation()) {
			case ASSOCIATE:
				this.setBasicPay(0.1 * 100000 * expFactor);
				break;
			case EXECUTIVE:
				setBasicPay(0.25 * 100000 * expFactor);
				break;
			case SENIOREXEC:
				setBasicPay(0.4 * 100000 * expFactor);
				break;
			case LEAD:
				setBasicPay(0.7 * 100000 * expFactor);
				break;
			case MANAGER:
				setBasicPay(100000 * expFactor);
				break;
			default:
				break;
			}
			break;

		case DEVELOPMENT:

			switch (getEmp().getDesignation()) {
			case ASSOCIATE:
				this.setBasicPay(0.15 * 200000 * expFactor);
				break;
			case EXECUTIVE:
				this.setBasicPay(0.25 * 200000 * expFactor);
				break;
			case SENIOREXEC:
				this.setBasicPay(0.4 * 200000 * expFactor);
				break;
			case LEAD:
				this.setBasicPay(0.6 * 200000 * expFactor);
				break;
			case MANAGER:
				this.setBasicPay(200000 * expFactor);
				break;
			default:
				break;
			}
			break;

		case DEPLOYMENT:
			switch (getEmp().getDesignation()) {
			case ASSOCIATE:
				this.setBasicPay(0.15 * 175000 * expFactor);
				break;
			case EXECUTIVE:
				this.setBasicPay(0.25 * 175000 * expFactor);
				break;
			case SENIOREXEC:
				this.setBasicPay(0.4 * 175000 * expFactor);
				break;
			case LEAD:
				this.setBasicPay(0.6 * 175000 * expFactor);
				break;
			case MANAGER:
				this.setBasicPay(175000 * expFactor);
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}

		this.setDa(this.getBasicPay() * daRate);
		this.setHra(this.getBasicPay() * hraRate);
		this.setGrossSalary(this.getBasicPay() + this.getHra() + this.getDa());
		this.setIncomeTax(calcTax(emp.getSalary()));
		this.setTotalDeductions((this.getIncomeTax() / 12) + this.getProfessionTax() + this.getProvidendFund());
		this.setNetPay(this.grossSalary - this.totalDeductions);
	}

	private double calcTax(double d) {

		double tax = 0;
		switch ((int) (d * 12) / 30000) {
		case 0:
			tax = 0;
		case 1:
			tax = ((d - 30000) * 0.05);
		case 2:
			tax = (15000 + ((d - 60000) * 0.1));
		case 3:
			tax = (45000 + ((d - 90000) * 0.15));
		case 4:
			tax = (90000 + ((d - 120000) * 0.2));
		case 5:
			tax = (150000 + ((d - 150000) * 0.3));
		}
		return tax;
	}

	@Override
	public String toString() {
		return String.format("BASIC PAY : %1.2f \n%1.2f \n%1.2f \n%1.2f \n%1.2f \n%1.2f \n%1.2f \n%1.2f \n%1.2f \n",this.basicPay,this.hra,this.da,this.incomeTax,this.professionTax,this.providendFund,this.grossSalary,this.totalDeductions,this.netPay);
	}

}
