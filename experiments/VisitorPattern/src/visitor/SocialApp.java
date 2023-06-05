package visitor;

import people.HumanResource;
import people.Programmer;
import people.Tester;

public class SocialApp implements CorporateSlaveVisitor {

	@Override
	public void visit(Programmer programmer) {
		System.out.println(String.format("%s: Please develop a Weixin app.", programmer.getName()));
	}

	@Override
	public void visit(HumanResource humanSource) {
		System.out.println(String.format("%s: Please write some documents.", humanSource.getName()));
	}

	@Override
	public void visit(Tester tester) {
		System.out.println(String.format("%s: Testing is the most important work.", tester.getName()));
	}

}
