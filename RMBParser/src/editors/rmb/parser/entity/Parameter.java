package editors.rmb.parser.entity;

import editors.rmb.parser.ast.Dumper;
import editors.rmb.parser.ast.TypeNode;

public class Parameter extends DefinedVariable {

	private boolean isArray;
	public Parameter(TypeNode type, String name, boolean isArray) {
        super(false, type, name, null);
        this.isArray = isArray;
    }

    public boolean isParameter() {
        return true;
    }

    protected void _dump(Dumper d) {
        d.printMember("name", name);
        d.printMember("typeNode", typeNode);
        d.printMember("isArray", isArray);
    }
}
