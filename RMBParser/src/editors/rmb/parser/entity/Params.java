package editors.rmb.parser.entity;

import java.util.ArrayList;
import java.util.List;

import editors.rmb.parser.ast.Dumpable;
import editors.rmb.parser.ast.Dumper;
import editors.rmb.parser.ast.Location;
import editors.rmb.parser.type.ParamTypeRefs;
import editors.rmb.parser.type.TypeRef;

public class Params extends ParamSlots<Parameter> implements Dumpable {
	
	public Params(Location loc, List<Parameter> paramDescs) {
		super(loc, paramDescs, false);
	}

	public List<Parameter> parameters() {
		return paramDescriptors;
	}

	public ParamTypeRefs parametersTypeRef() {
		List<TypeRef> typerefs = new ArrayList<TypeRef>();
		for (Parameter param : paramDescriptors) {
			typerefs.add(param.typeNode().typeRef());
		}
		
		return new ParamTypeRefs(location, typerefs, vararg);
	}

	public boolean equals(Object other) {
		return (other instanceof Params) && equals((Params)other);
	}
	
	public boolean equals(Params other) {
		return other.vararg == vararg && other.paramDescriptors.equals(paramDescriptors);
	}
	
	public void dump(Dumper d) {
		d.printNodeList("parameters", parameters());
	}
}
