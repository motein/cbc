package editors.rmb.parser.ast;

import editors.rmb.parser.type.TypeRef;

public class RealLiteralNode extends LiteralNode {

	protected double value;

    public RealLiteralNode(Location loc, TypeRef ref, double value) {
        super(loc, ref);
        this.value = value;
    }

    public double value() {
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
