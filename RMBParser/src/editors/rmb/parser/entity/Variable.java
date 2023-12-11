package editors.rmb.parser.entity;

import editors.rmb.parser.ast.TypeNode;

public abstract class Variable extends Entity {

	public Variable(boolean priv, TypeNode type, String name) {
        super(priv, type, name);
    }

}
