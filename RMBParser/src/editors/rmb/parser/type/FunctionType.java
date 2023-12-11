package editors.rmb.parser.type;

public class FunctionType extends Type {

    protected Type returnType;
    protected ParamTypes paramTypes;
    
    public FunctionType(Type ret, ParamTypes partypes) {
        returnType = ret;
        paramTypes = partypes;
    }
    
	@Override
	public long size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSameType(Type other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCompatible(Type other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCastableTo(Type target) {
		// TODO Auto-generated method stub
		return false;
	}
	
    public Type returnType() {
        return returnType;
    }

}
