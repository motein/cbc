package editors.rmb.parser.ast;

import java.util.List;

import editors.rmb.parser.exception.SemanticError;
import editors.rmb.parser.type.FunctionType;
import editors.rmb.parser.type.Type;

public class FuncallNode extends ExprNode {

    protected ExprNode expr;
    protected List<ExprNode> args;
    
    public FuncallNode(ExprNode expr, List<ExprNode> args) {
        this.expr = expr;
        this.args = args;
    }

    public ExprNode expr() {
        return expr;
    }
    
	@Override
	public Type type() {
		try {
            return functionType().returnType();
        }
        catch (ClassCastException err) {
            throw new SemanticError(err.getMessage());
        }
	}
	
    public FunctionType functionType() {
        return expr.type().baseType().getFunctionType();
    }

    public long numArgs() {
        return args.size();
    }

    public List<ExprNode> args() {
        return args;
    }
    
    public void replaceArgs(List<ExprNode> args) {
        this.args = args;
    }

	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Location location() {
		return expr.location();
	}

	@Override
	protected void _dump(Dumper d) {
		d.printMember("expr", expr);
        d.printNodeList("args", args);

	}

}
