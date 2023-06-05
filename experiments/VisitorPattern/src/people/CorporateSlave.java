package people;

import visitor.CorporateSlaveVisitor;

public interface CorporateSlave {

	void accept(CorporateSlaveVisitor visitor);
}
