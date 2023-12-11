package editors.rmb.parser.type;

import editors.rmb.parser.ast.Location;

public class VoidTypeRef extends TypeRef {
	protected String name;
	
    public VoidTypeRef() {
        super(null);
        name = "void";
        
    }

    public VoidTypeRef(Location loc) {
        super(loc);
        name = "void";
    }

    public boolean isVoid() {
        return true;
    }

    public boolean equals(Object other) {
        return (other instanceof VoidTypeRef);
    }

    public String toString() {
        return name;
    }
    
    static public VoidTypeRef voidRef(Location loc) {
        return new VoidTypeRef(loc);
    }
    
    static public VoidTypeRef voidRef() {
        return new VoidTypeRef();
    }
}
