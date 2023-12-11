package editors.rmb.parser.ast;

import java.util.List;

public class RepeatNode extends StmtNode {
    protected List<StmtNode> body;
    protected ExprNode cond;

    public RepeatNode(Location loc, ExprNode cond, List<StmtNode> body) {
        super(loc);
        this.cond = cond;
        this.body = body;
    }

    public ExprNode cond() {
        return cond;
    }

    public List<StmtNode> body() {
        return body;
    }

    protected void _dump(Dumper d) {
        d.printMember("cond", cond);
        d.printNodeList("body", body);
    }

    public <S,E> S accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}