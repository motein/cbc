package editors.rmb.parser.type;

import java.util.ArrayList;
import java.util.List;

import editors.rmb.parser.ast.Location;
import editors.rmb.parser.entity.ParamSlots;

public class ParamTypeRefs extends ParamSlots<TypeRef> {
    public ParamTypeRefs(List<TypeRef> paramDescs) {
        super(paramDescs);
    }

    public ParamTypeRefs(Location loc, List<TypeRef> paramDescs, boolean vararg) {
        super(loc, paramDescs, vararg);
    }

    public List<TypeRef> typerefs() {
        return paramDescriptors;
    }

    public ParamTypes internTypes(TypeTable table) {
        List<Type> types = new ArrayList<Type>();
        for (TypeRef ref : paramDescriptors) {
            types.add(table.getParamType(ref));
        }
        
        return new ParamTypes(location, types, vararg);
    }

    public boolean equals(Object other) {
        return (other instanceof ParamTypeRefs)
                && equals((ParamTypeRefs)other);
    }

    public boolean equals(ParamTypeRefs other) {
        return vararg == other.vararg
                && paramDescriptors.equals(other.paramDescriptors);
    }
}

