package visitor;

import people.HumanResource;
import people.Programmer;
import people.Tester;

public interface CorporateSlaveVisitor {
	
	void visit(Programmer programmer);

    void visit(HumanResource humanSource);

    void visit(Tester tester);
}
