package editors.rmb.parser.entity;

import java.util.List;

import editors.rmb.parser.ast.BlockNode;
import editors.rmb.parser.ast.Dumper;

public class DefinedSubprogram extends Function {
	
	protected Params params;
    protected BlockNode body;
    protected LocalScope scope;

	public DefinedSubprogram(boolean priv, String name, Params params, BlockNode body) {
		super(priv, null, name);
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
        d.printMember("name", name);
        d.printMember("isPrivate", isPrivate);
        d.printMember("params", params);
        d.printMember("body", body);
    }

    public <T> T accept(EntityVisitor<T> visitor) {
    	return visitor.visit(this);
    }
  
}

