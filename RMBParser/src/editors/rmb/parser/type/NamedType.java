package editors.rmb.parser.type;

import editors.rmb.parser.ast.Location;

public abstract class NamedType extends Type {

	protected String name;
    protected Location location;

    public NamedType(String name, Location loc) {
        this.name = name;
        this.location = loc;
    }

    public String name() {
        return name;
    }

    public Location location() {
        return location;
    }

}
