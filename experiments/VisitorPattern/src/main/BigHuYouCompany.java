package main;

import java.util.ArrayList;
import java.util.List;

import people.CorporateSlave;
import people.HumanResource;
import people.Programmer;
import people.Tester;
import visitor.CorporateSlaveVisitor;

public class BigHuYouCompany {

	private List<CorporateSlave> employee= new ArrayList<>();

	public BigHuYouCompany() {
        employee.add(new Programmer("John"));
        employee.add(new HumanResource("Lucy"));
        employee.add(new Tester("BigBang"));
    }

    public void startProject(CorporateSlaveVisitor visitor){
        for (CorporateSlave slave : employee) {
            slave.accept(visitor);
        }
    }
}
