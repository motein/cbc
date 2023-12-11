package editors.rmb.parser.type;

public class ArrayType extends Type {

    protected Type baseType;
    protected long pointerSize;
    static final protected long undefined = -1;
    
    public ArrayType(Type baseType, long pointerSize) {
        this.baseType = baseType;
        this.pointerSize = pointerSize;
    }
    
    public boolean isArray() { return true; }
    
    public boolean isAllocatedArray() {
        return !baseType.isArray() || baseType.isAllocatedArray();
    }
    
    public boolean isIncompleteArray() {
        if (! baseType.isArray()) return false;
        return !baseType.isAllocatedArray();
    }
    
    public Type baseType() {
        return baseType;
    }
    
	@Override
	public long size() {
		return pointerSize;
	}

	@Override
	public boolean isSameType(Type other) {
        return baseType.isSameType(other.baseType());
	}

	@Override
	public boolean isCompatible(Type target) {
        return baseType.isCompatible(target.baseType())
                && baseType.size() == target.baseType().size();
	}

	@Override
	public boolean isCastableTo(Type target) {
		return target.isArray();
	}

}
