package editors.rmb.parser.ast;

import editors.rmb.parser.type.Type;

public class UnaryOpNode extends ExprNode {
    protected String operator;
    protected ExprNode expr;
    protected Type opType;
    
    public UnaryOpNode(String op, ExprNode expr) {
        this.operator = op;
        this.expr = expr;
    }
    
    public String operator() {
        return operator;
    }
    
	@Override
	public Type type() {
		return expr.type();
	}
	
	public void setOpType(Type t) {
        this.opType = t;
    }
	
	public Type opType() {
        return opType;
    }
	
	
    public void setExpr(ExprNode expr) {
        this.expr = expr;
    }
	
    public ExprNode expr() {
        return expr;
    }
    
	@Override
	public Location location() {
		return expr.location();
	}
	
	@Override
	protected void _dump(Dumper d) {
		d.printMember("operator", operator);
        d.printMember("expr", expr);
	}

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor) {
		return visitor.visit(this);
	}

}
