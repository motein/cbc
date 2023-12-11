package editors.rmb.parser.ast;

public interface DeclarationVisitor<T> {
    public T visit(TypedefNode typedef);
}
