package editors.rmb.parser.ast;

import editors.rmb.parser.type.Type;
import editors.rmb.parser.type.TypeRef;

public abstract class LiteralNode extends ExprNode {

    protected Location location;
    protected TypeNode typeNode;
    
    public LiteralNode(Location loc, TypeRef ref) {
        super();
        this.location = loc;
        this.typeNode = new TypeNode(ref);
    }
    
	@Override
	public Location location() {
		return location;
	}
    
	@Override
	public Type type() {
		return typeNode.type();
	}
	
    public TypeNode typeNode() {
        return typeNode;
    }
	
	@Override
    public boolean isConstant() {
        return true;
    }

}
