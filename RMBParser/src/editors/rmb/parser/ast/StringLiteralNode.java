package editors.rmb.parser.ast;

import editors.rmb.parser.type.TypeRef;

public class StringLiteralNode extends LiteralNode {

	protected String value;

    public StringLiteralNode(Location loc, TypeRef ref, String value) {
        super(loc, ref);
        this.value = value;
    }
    
    public String value() {
        return value;
    }

	@Override
	protected void _dump(Dumper d) {
		d.printMember("value", value);
	}
	
	@Override
	public <S, E> E accept(ASTVisitor<S, E> visitor) {
		return visitor.visit(this);
	}

}
