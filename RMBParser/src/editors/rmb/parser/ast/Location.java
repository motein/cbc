package editors.rmb.parser.ast;

import editors.rmb.parser.Token;

public class Location {

	protected String sourceName;
    protected RMBToken token;

    public Location(String sourceName, Token token) {
        this(sourceName, new RMBToken(token));
    }

    public Location(String sourceName, RMBToken token) {
        this.sourceName = sourceName;
        this.token = token;
    }

    public String sourceName() {
        return sourceName;
    }

    public RMBToken token() {
        return token;
    }

    /** line number */
    public int lineno() {
        return token.lineno();
    }

    public int column() {
        return token.column();
    }

    public String line() {
        return token.includedLine();
    }

    public String numberedLine() {
        return "line " + token.lineno() + ": " + line();
    }

    public String toString() {
        return sourceName + ":" + token.lineno();
    }
}
