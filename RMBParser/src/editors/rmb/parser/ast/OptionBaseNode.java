package editors.rmb.parser.ast;

public class OptionBaseNode extends StmtNode {
		
	protected String name = "OPTION BASE";
    protected long baseValue;

    public OptionBaseNode(Location loc, long baseValue) {
        super(loc);
        this.baseValue = baseValue;
    }

    public String name() {
        return name;
    }

    public long baseValue() {
        return baseValue;
    }
    
	@Override
	public <S, E> S accept(ASTVisitor<S, E> visitor) {
		return visitor.visit(this);
	}

	@Override
	protected void _dump(Dumper d) {
		d.printMember("name", name);
        d.printMember("baseValue", baseValue);
	}

}

