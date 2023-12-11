package editors.rmb.parser.ast;

public interface ASTVisitor<S, E> {
	
	// Statements
	public S visit(BlockNode node);
	public S visit(ExprStmtNode node);
	public S visit(IfNode node);
    public S visit(SwitchNode node);
    public S visit(CaseNode node);
	public S visit(WhileNode node);
	public S visit(LoopNode node);
	public S visit(RepeatNode node);
	public S visit(ForNode node);
	public S visit(GotoNode node);
	public S visit(GoSubNode node);
	public S visit(LabelNode node);
	public S visit(OptionBaseNode node);
	public S visit(ReturnNode node);

	// Expressions
	public E visit(AssignNode node);
	public E visit(OpAssignNode node);
	public E visit(BinaryOpNode node);
	public E visit(UnaryOpNode node);
	public E visit(ArefNode node);
	public E visit(FuncallNode node);
	public E visit(VariableNode node);
	public E visit(IntegerLiteralNode node);
	public E visit(RealLiteralNode node);
	public E visit(StringLiteralNode node);
}
