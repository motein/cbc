package visitor;

import people.HumanResource;
import people.Programmer;
import people.Tester;

public class LiveApp implements CorporateSlaveVisitor {

	@Override
	public void visit(Programmer programmer) {
		System.out.println(String.format("%s: Please develop a mini app.", programmer.getName()));
	}

	@Override
	public void visit(HumanResource humanSource) {
		System.out.println(String.format("%s: Please recruit more people.", humanSource.getName()));
	}

	@Override
	public void visit(Tester tester) {
		System.out.println(String.format("%s: Live commerce is easy.", tester.getName()));
	}

}
