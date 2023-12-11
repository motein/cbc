package editors.rmb.parser.ast;

public class ExprStmtNode extends StmtNode {

	protected ExprNode expr;

    public ExprStmtNode(Location loc, ExprNode expr) {
        super(loc);
        this.expr = expr;
    }

    public ExprNode expr() {
        return expr;
    }

    public void setExpr(ExprNode expr) {
        this.expr = expr;
    }
    
	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor) {
		return visitor.visit(this);
	}

	@Override
	protected void _dump(Dumper d) {
		d.printMember("expr", expr);
	}

}
