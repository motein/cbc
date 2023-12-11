package editors.rmb.parser.entity;

import java.util.List;

import editors.rmb.parser.ast.Dumper;
import editors.rmb.parser.ast.TypeNode;

public class UndefinedFunction extends Function {
	
	protected Params params;

    public UndefinedFunction(TypeNode t, String name, Params params) {
        super(false, t, name);
        this.params = params;
    }

    public List<Parameter> parameters() {
        return params.parameters();
    }

    public boolean isDefined() {
        return false;
    }

    protected void _dump(Dumper d) {
        d.printMember("name", name);
        d.printMember("isPrivate", isPrivate());
        d.printMember("typeNode", typeNode);
        d.printMember("params", params);
    }

    public <T> T accept(EntityVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
