package editors.rmb.parser.entity;

import editors.rmb.parser.ast.Dumpable;
import editors.rmb.parser.ast.Dumper;
import editors.rmb.parser.ast.Location;
import editors.rmb.parser.ast.TypeNode;

public class ImportedLibrary implements Dumpable {

	private String path;
	private TypeNode typeNode;
	
	public ImportedLibrary(String path) {
		this.path = path;
		this.typeNode = null;
	}

	public ImportedLibrary(String path, TypeNode type) {
		this.path = path;
		this.typeNode = type;
	}
	
    public Location location() {
        return typeNode.location();
    }
	
	@Override
	public void dump(Dumper d) {
//		d.printClass(this, location());
		d.printMember("path", path);
	}

}
