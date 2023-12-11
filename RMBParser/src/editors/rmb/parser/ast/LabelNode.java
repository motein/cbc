package editors.rmb.parser.ast;

public class LabelNode extends StmtNode {
	
	protected String name;
    protected StmtNode stmt;

    public LabelNode(Location loc, String name, StmtNode stmt) {
        super(loc);
        this.name = name;
        this.stmt = stmt;
    }

    public String name() {
        return name;
    }

    public StmtNode stmt() {
        return stmt;
    }
	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor) {
		return visitor.visit(this);
	}

	@Override
	protected void _dump(Dumper d) {
		d.printMember("name", name);
        d.printMember("stmt", stmt);
	}

}
