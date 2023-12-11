package editors.rmb.parser.ast;

public abstract class StmtNode extends Node {
	
	protected Location location;

    public StmtNode(Location loc) {
        this.location = loc;
    }

	@Override
	public Location location() {
		return location;
	}

	abstract public <S,E> S accept(ASTVisitor<S,E> visitor);

}
