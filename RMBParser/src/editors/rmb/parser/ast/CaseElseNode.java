package editors.rmb.parser.ast;

import java.util.ArrayList;

public class CaseElseNode extends CaseNode {

	public CaseElseNode(Location loc, BlockNode body) {
		super(loc, new ArrayList<ExprNode>(), body);
	}
	
    protected void _dump(Dumper d) {
        d.printMember("body", body);
    }

}
