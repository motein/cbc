package editors.rmb.parser.type;

import editors.rmb.parser.ast.Location;

public class ComplexTypeRef extends TypeRef {
    protected String name;

    public ComplexTypeRef(String name) {
        this(name, null);
    }
    
    public ComplexTypeRef(String name, Location loc) {
        super(loc);
        this.name = name;
    }
    
    public String name() {
        return name;
    }
    
    public boolean equals(Object other) {
        if (! (other instanceof ComplexTypeRef)) return false;
        ComplexTypeRef ref = (ComplexTypeRef)other;
        return name.equals(ref.name);
    }

    public String toString() {
        return name;
    }
	
    static public ComplexTypeRef complexRef(Location loc) {
        return new ComplexTypeRef("complex", loc);
    }

}
