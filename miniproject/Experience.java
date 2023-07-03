package org.cdac.miniproject;

import java.time.LocalDate;
import java.time.Period;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Experience {
	int years;
	int months;
	Employee emp;
//LocalDate joinDate;

	public Experience(Employee emp) {
//	this.joinDate = emp.getJoinDate();
		this.emp = emp;
//	calculateExp();
	}

	public Experience(int i, int j) {
		// TODO Auto-generated constructor stub
		this.years = i;
		this.months = j;
	}

	public void calculateExp() {
		if (this.getEmp().getJoinDate() != null) {
			this.setYears(Period.between(this.getEmp().getJoinDate(), LocalDate.now()).getYears());
			this.setMonths(Period.between(getEmp().getJoinDate(), LocalDate.now()).getMonths() % 12);
		}

	}

	@Override
	public String toString() {
		return "Experience [years=" + years + ", months=" + months + "]";
	}

}
