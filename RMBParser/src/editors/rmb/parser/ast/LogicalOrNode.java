package editors.rmb.parser.ast;

public class LogicalOrNode extends BinaryOpNode {

	public LogicalOrNode(ExprNode left, ExprNode right) {
        super(left, "OR", right);
    }

	@Override
    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
