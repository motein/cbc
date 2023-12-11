package editors.rmb.parser.entity;

import editors.rmb.parser.ast.Dumper;
import editors.rmb.parser.ast.ExprNode;
import editors.rmb.parser.ast.TypeNode;
import editors.rmb.parser.type.Type;

public class DefinedVariable extends Variable {

	protected ExprNode initializer;
	protected long sequence;
	
	public DefinedVariable(boolean priv, TypeNode type, String name) {
		super(priv, type, name);
		initializer = null;
        sequence = -1;
	}
	
	public DefinedVariable(boolean priv, TypeNode type, String name, ExprNode init) {
		super(priv, type, name);
		initializer = init;
        sequence = -1;
	}
	
    static private long tmpSeq = 0;

    static public DefinedVariable tmp(Type t) {
        return new DefinedVariable(false,
                new TypeNode(t), "@tmp" + tmpSeq++, null);
    }

	@Override
	public boolean isDefined() {
		return true;
	}
	
    public void setSequence(long seq) {
        this.sequence = seq;
    }
    
    public String symbolString() {
        return (sequence < 0) ? name : (name + "." + sequence);
    }
	
    private boolean hasInitializer() {
        return (initializer != null);
    }

	@Override
	public boolean isInitialized() {
		return hasInitializer();
	}

	@Override
	public <T> T accept(EntityVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	protected void _dump(Dumper d) {
		d.printMember("name", name);
        d.printMember("isPrivate", isPrivate);
        d.printMember("typeNode", typeNode);
        d.printMember("initializer", initializer);
	}

	
}
