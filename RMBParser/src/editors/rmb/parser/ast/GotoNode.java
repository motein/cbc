package editors.rmb.parser.ast;

public class GotoNode extends StmtNode {
    protected String target;
    private boolean isLabel;

    public GotoNode(Location loc, String target, boolean isLabel) {
        super(loc);
        this.target = target;
        this.isLabel = isLabel;
    }

    public String target() {
        return target;
    }
    
    public boolean isLabel() {
        return isLabel;
    }

    protected void _dump(Dumper d) {
        d.printMember("target", target);
        d.printMember("isLabel", isLabel);
    }

    public <S,E> S accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
