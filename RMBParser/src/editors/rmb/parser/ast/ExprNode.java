package editors.rmb.parser.ast;

import editors.rmb.parser.exception.SemanticError;
import editors.rmb.parser.type.Type;

public abstract class ExprNode extends Node {
    public ExprNode() {
        super();
    }

    abstract public Type type();
    protected Type origType() { return type(); }

    public long allocSize() { return type().allocSize(); }

    public boolean isConstant() { return false; }
    public boolean isParameter() { return false; }

    public boolean isLvalue() { return false; }
    public boolean isAssignable() { return false; }
    public boolean isLoadable() { return false; }

    public boolean isCallable() {
        try {
            return type().isCallable();
        }
        catch (SemanticError err) {
            return false;
        }
    }

    abstract public <S,E> E accept(ASTVisitor<S,E> visitor);
}

