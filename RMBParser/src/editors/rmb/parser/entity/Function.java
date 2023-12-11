package editors.rmb.parser.entity;

import java.util.List;

import editors.rmb.parser.ast.Dumper;
import editors.rmb.parser.ast.TypeNode;
import editors.rmb.parser.type.Type;

public abstract class Function extends Entity {
    
    public Function(boolean priv, TypeNode t, String name) {
        super(priv, t, name);
    }
    
    abstract public boolean isDefined();
    abstract public List<Parameter> parameters();
    
    public Type returnType() {
        return type().getFunctionType().returnType();
    }

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T accept(EntityVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void _dump(Dumper d) {
		// TODO Auto-generated method stub

	}

}
