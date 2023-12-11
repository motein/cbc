package editors.rmb.parser.ast;

import java.util.List;

public class LoopNode extends StmtNode {
    protected List<StmtNode> stmts;
    protected List<ExprNode> conds;

    public LoopNode(Location loc, List<ExprNode> conds, List<StmtNode> stmts) {
        super(loc);
        this.conds = conds;
        this.stmts = stmts;
    }

    public List<ExprNode> cond() {
        return conds;
    }

    public List<StmtNode> body() {
        return stmts;
    }

    protected void _dump(Dumper d) {
        d.printNodeList("conds", conds);
        d.printNodeList("stmts", stmts);
    }

    public <S,E> S accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }
}
