package editors.rmb.parser.ast;

import editors.rmb.parser.type.Type;

abstract public class LHSNode extends ExprNode {
	
	protected Type type, origType;

	@Override
	public Type type() {
		return type != null ? type : origType();
	}
	
    public void setType(Type t) {
        this.type = t;
    }

    abstract protected Type origType();

    public long allocSize() { return origType().allocSize(); }

    public boolean isLvalue() { return true; }
    public boolean isAssignable() { return isLoadable(); }

    public boolean isLoadable() {
        Type t = origType();
        return !t.isArray() && !t.isFunction();
    }

}
