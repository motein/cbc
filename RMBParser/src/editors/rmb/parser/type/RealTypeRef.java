package editors.rmb.parser.type;

import editors.rmb.parser.ast.Location;

public class RealTypeRef extends TypeRef {
    protected String name;

    public RealTypeRef(String name) {
        this(name, null);
    }
    
    public RealTypeRef(String name, Location loc) {
        super(loc);
        this.name = name;
    }
    
    public String name() {
        return name;
    }
    
    public boolean equals(Object other) {
        if (! (other instanceof RealTypeRef)) return false;
        RealTypeRef ref = (RealTypeRef)other;
        return name.equals(ref.name);
    }

    public String toString() {
        return name;
    }
	
    static public RealTypeRef realRef(Location loc) {
        return new RealTypeRef("real", loc);
    }
    
    static public RealTypeRef realRef() {
        return new RealTypeRef("real");
    }

}
