package editors.rmb.parser.exception;

public class SemanticError extends Error {

	private static final long serialVersionUID = 1L;

	public SemanticError(String msg) {
        super(msg);
    }
}