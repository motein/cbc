package editors.rmb.parser.ast;

import editors.rmb.parser.type.Type;
import editors.rmb.parser.type.TypeRef;
import editors.rmb.parser.type.UserType;
import editors.rmb.parser.type.UserTypeRef;

public class TypedefNode extends TypeDefinition {

	protected TypeNode real;
	
	public TypedefNode(Location loc, TypeRef real, String name) {
		super(loc, new UserTypeRef(name), name);
		this.real = new TypeNode(real);
	}
	
	public boolean isUserType() {
        return true;
    }

    public TypeNode realTypeNode() {
        return real;
    }

    public Type realType() {
        return real.type();
    }

    public TypeRef realTypeRef() {
        return real.typeRef();
    }

	@Override
	public Type definingType() {
		return new UserType(name(), realTypeNode(), location());
	}

	@Override
	public <T> T accept(DeclarationVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	protected void _dump(Dumper d) {
		d.printMember("name", name);
        d.printMember("typeNode", typeNode);
	}

}
