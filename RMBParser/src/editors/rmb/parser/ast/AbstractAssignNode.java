package editors.rmb.parser.ast;

import editors.rmb.parser.type.Type;

public abstract class AbstractAssignNode extends ExprNode {

	ExprNode lhs, rhs;
	
    public AbstractAssignNode(ExprNode lhs, ExprNode rhs) {
        super();
        this.lhs = lhs;
        this.rhs = rhs;
    }
	
	@Override
	public Type type() {
		return lhs.type();
	}
	
    public ExprNode lhs() {
        return lhs;
    }

    public ExprNode rhs() {
        return rhs;
    }

    public void setRHS(ExprNode expr) {
        this.rhs = expr;
    }
    
	@Override
	public Location location() {
		return lhs.location();
	}
	
	@Override
	protected void _dump(Dumper d) {
		d.printMember("lhs", lhs);
        d.printMember("rhs", rhs);
	}

}
