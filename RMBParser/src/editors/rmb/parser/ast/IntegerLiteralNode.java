package editors.rmb.parser.ast;

import editors.rmb.parser.type.TypeRef;

public class IntegerLiteralNode extends LiteralNode {

	protected long value;

    public IntegerLiteralNode(Location loc, TypeRef ref, long value) {
        super(loc, ref);
        this.value = value;
    }

    public long value() {
        return value;
    }

	@Override
	protected void _dump(Dumper d) {
		d.printMember("typeNode", typeNode);
        d.printMember("value", value);
	}

	@Override
    public <S,E> E accept(ASTVisitor<S,E> visitor) {
        return visitor.visit(this);
    }

}
