package editors.rmb.parser.type;

import editors.rmb.parser.ast.Location;

public class IntegerTypeRef extends TypeRef {
	
    protected String name;

    public IntegerTypeRef(String name) {
        this(name, null);
    }
    
    public IntegerTypeRef(String name, Location loc) {
        super(loc);
        this.name = name;
    }
    
    public String name() {
        return name;
    }
    
    public boolean equals(Object other) {
        if (! (other instanceof IntegerTypeRef)) return false;
        IntegerTypeRef ref = (IntegerTypeRef)other;
        return name.equals(ref.name);
    }

    public String toString() {
        return name;
    }
	
    static public IntegerTypeRef intRef(Location loc) {
        return new IntegerTypeRef("int", loc);
    }
    
    static public IntegerTypeRef intRef() {
        return new IntegerTypeRef("int");
    }

}
