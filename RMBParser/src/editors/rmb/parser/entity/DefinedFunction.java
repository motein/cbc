package editors.rmb.parser.entity;

import java.util.List;

import editors.rmb.parser.ast.BlockNode;
import editors.rmb.parser.ast.Dumper;
import editors.rmb.parser.ast.TypeNode;

public class DefinedFunction extends Function {

	protected Params params;
    protected BlockNode body;
    protected LocalScope scope;
    protected String label; // SUB label
    
    public DefinedFunction(boolean priv, TypeNode type,
            String name, Params params, BlockNode body) {
        super(priv, type, name);
        this.label = null;
        this.params = params;
        this.body = body;
    }
    
    public DefinedFunction(boolean priv, String label, TypeNode type,
            String name, Params params, BlockNode body) {
        super(priv, type, name);
        this.label = label;
        this.params = params;
        this.body = body;
    }

	@Override
	public boolean isDefined() {
		return true;
	}

	@Override
	public List<Parameter> parameters() {
		return params.parameters();
	}
	
	public BlockNode body() {
        return body;
    }
	
    public void setScope(LocalScope scope) {
        this.scope = scope;
    }

    public LocalScope lvarScope() {
        return body().scope();
    }
	
    public List<DefinedVariable> localVariables() {
        return scope.allLocalVariables();
    }
	
	protected void _dump(Dumper d) {
		d.printMember("label", "" + label);
        d.printMember("name", name);
        d.printMember("isPrivate", isPrivate);
        d.printMember("params", params);
        d.printMember("body", body);
    }

    public <T> T accept(EntityVisitor<T> visitor) {
        return visitor.visit(this);
    }
  
}

