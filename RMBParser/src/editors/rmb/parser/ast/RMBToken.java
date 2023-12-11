package editors.rmb.parser.ast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import editors.rmb.parser.RMBParserConstants;
import editors.rmb.parser.Token;
import editors.rmb.parser.utils.TextUtils;

public class RMBToken implements Iterable<RMBToken> {
    protected Token token;
    protected boolean isSpecial;

    public RMBToken(Token token) {
        this(token, false);
    }

    public RMBToken(Token token, boolean isSpecial) {
        this.token = token;
        this.isSpecial = isSpecial;
    }

    public String toString() {
       return token.image;
    }

    public boolean isSpecial() {
        return this.isSpecial;
    }

    public int kindID() {
        return token.kind;
    }

    public String kindName() {
        return RMBParserConstants.tokenImage[token.kind];
    }

    public int lineno() {
        return token.beginLine;
    }

    public int column() {
        return token.beginColumn;
    }

    public String image() {
        return token.image;
    }

    public String dumpedImage() {
        return TextUtils.dumpString(token.image);
    }

    public Iterator<RMBToken> iterator() {
        return buildTokenList(token, false).iterator();
    }

    protected List<RMBToken> tokensWithoutFirstSpecials() {
        return buildTokenList(token, true);
    }

    protected List<RMBToken> buildTokenList(Token first, boolean rejectFirstSpecials) {
        List<RMBToken> result = new ArrayList<RMBToken>();
        boolean rejectSpecials = rejectFirstSpecials;
        for (Token t = first; t != null; t = t.next) {
            if (t.specialToken != null && !rejectSpecials) {
                Token s = specialTokenHead(t.specialToken);
                for (; s != null; s = s.next) {
                    result.add(new RMBToken(s));
                }
            }
            result.add(new RMBToken(t));
            rejectSpecials = false;
        }
        return result;
    }

    protected Token specialTokenHead(Token firstSpecial) {
        Token s = firstSpecial;
        while (s.specialToken != null) {
            s = s.specialToken;
        }
        return s;
    }

    public String includedLine() {
        StringBuffer buf = new StringBuffer();
        for (RMBToken t : tokensWithoutFirstSpecials()) {
            int idx = t.image().indexOf("\n");
            if (idx >= 0) {
                buf.append(t.image().substring(0, idx));
                break;
            }
            buf.append(t.image());
        }
        return buf.toString();
    }
}
