package editors.rmb.parser.ast;

import java.util.ArrayList;
import java.util.List;

import editors.rmb.parser.entity.DefinedFunction;
import editors.rmb.parser.entity.DefinedVariable;
import editors.rmb.parser.entity.Entity;

public class AST extends Node {

    protected Location source;
    protected Declarations declarations;
    
    public AST(Location source, Declarations declarations) {
        super();
        this.source = source;
        this.declarations = declarations;
    }
    
	@Override
	public Location location() {
		return source;
	}
	
    public List<TypeDefinition> types() {
        List<TypeDefinition> result = new ArrayList<TypeDefinition>();
        result.addAll(declarations.typedefs());
        return result;
    }
    
    public List<Entity> entities() {
        List<Entity> result = new ArrayList<Entity>();
        result.addAll(declarations.funcdecls);
        result.addAll(declarations.vardecls);
        result.addAll(declarations.defvars);
        result.addAll(declarations.defuns);
        return result;
    }
    
    public List<Entity> declarations() {
        List<Entity> result = new ArrayList<Entity>();
        result.addAll(declarations.funcdecls);
        result.addAll(declarations.vardecls);
        return result;
    }
    
    public List<Entity> definitions() {
        List<Entity> result = new ArrayList<Entity>();
        result.addAll(declarations.defvars);
        result.addAll(declarations.defuns);
        return result;
    }
    
    public List<DefinedVariable> definedVariables() {
        return declarations.defvars();
    }
    
    public List<StmtNode> stmts() {
        return declarations.stmts();
    }

    public List<DefinedFunction> definedFunctions() {
        return declarations.defuns();
    }

	@Override
	protected void _dump(Dumper d) {
		d.printNodeList("variables", definedVariables());
		d.printNodeList("stmts", stmts());
        d.printNodeList("functions", definedFunctions());
	}

}
