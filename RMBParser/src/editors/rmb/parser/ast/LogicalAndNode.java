package editors.rmb.parser.ast;

public class LogicalAndNode extends BinaryOpNode {
	
	public LogicalAndNode(ExprNode left, ExprNode right) {
        super(left, "AND", right);
    }

	@Override
    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
