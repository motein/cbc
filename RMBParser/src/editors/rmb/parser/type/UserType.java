package editors.rmb.parser.type;

import editors.rmb.parser.ast.Location;
import editors.rmb.parser.ast.TypeNode;

public class UserType extends NamedType {

	protected TypeNode real;
	
	public UserType(String name, TypeNode real, Location loc) {
		super(name, loc);
		this.real = real;
	}
	
    public Type realType() {
        return real.type();
    }

    public String toString() {
        return name;
    }

	@Override
	public long size() {
		return realType().size();
	}

	@Override
	public boolean isSameType(Type other) {
		return realType().isSameType(other);
	}

	@Override
	public boolean isCompatible(Type other) {
		return realType().isCompatible(other);
	}

	@Override
	public boolean isCastableTo(Type target) {
		return realType().isCastableTo(target);
	}

}
