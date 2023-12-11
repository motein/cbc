package editors.rmb.parser.type;

import editors.rmb.parser.ast.Location;

public class StringTypeRef extends TypeRef {

    protected String name;

    public StringTypeRef(String name) {
        this(name, null);
    }
    
    public StringTypeRef(String name, Location loc) {
        super(loc);
        this.name = name;
    }
    
    public String name() {
        return name;
    }
    
    public boolean equals(Object other) {
        if (! (other instanceof StringTypeRef)) return false;
        StringTypeRef ref = (StringTypeRef)other;
        return name.equals(ref.name);
    }

    public String toString() {
        return name;
    }
	
    static public StringTypeRef stringRef(Location loc) {
        return new StringTypeRef("string", loc);
    }
    
    static public StringTypeRef stringRef() {
        return new StringTypeRef("string");
    }

}
