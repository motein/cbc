package editors.rmb.parser.entity;

import editors.rmb.parser.ast.Dumpable;
import editors.rmb.parser.ast.Dumper;
import editors.rmb.parser.ast.ExprNode;
import editors.rmb.parser.ast.Location;
import editors.rmb.parser.ast.TypeNode;
import editors.rmb.parser.type.Type;

abstract public class Entity implements Dumpable {

	protected String name;
	protected boolean isPrivate; // if COM
	protected TypeNode typeNode;
	
    public Entity(boolean priv, TypeNode type, String name) {
        this.name = name;
        this.isPrivate = priv;
        this.typeNode = type;
    }
    
    public String name() {
        return name;
    }
    
    public String symbolString() {
        return name();
    }
    
    abstract public boolean isDefined();
    abstract public boolean isInitialized();
    
    public boolean isConstant() { return false; }
    
    public ExprNode value() {
        throw new Error("Entity#value");
    }
    
    public boolean isParameter() { return false; }

    public boolean isPrivate() {
        return isPrivate;
    }

    public TypeNode typeNode() {
        return typeNode;
    }

    public Type type() {
        return typeNode.type();
    }

    public long allocSize() {
        return type().allocSize();
    }

    public long alignment() {
        return type().alignment();
    }

    public Location location() {
        return typeNode.location();
    }

    abstract public <T> T accept(EntityVisitor<T> visitor);

    public void dump(Dumper d) {
        d.printClass(this, location());
        _dump(d);
    }

    abstract protected void _dump(Dumper d);
    
}
