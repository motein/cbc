package people;

import visitor.CorporateSlaveVisitor;

public class HumanResource implements CorporateSlave {
	
	private String name;
	
	public HumanResource(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public void accept(CorporateSlaveVisitor visitor) {
		visitor.visit(this);
	}

}
