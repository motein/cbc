package editors.rmb.parser.ast;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import editors.rmb.parser.entity.DefinedFunction;
import editors.rmb.parser.entity.DefinedVariable;
import editors.rmb.parser.entity.ImportedLibrary;
import editors.rmb.parser.entity.UndefinedFunction;
import editors.rmb.parser.entity.UndefinedVariable;

public class Declarations {
	Set<ImportedLibrary> implibs = new LinkedHashSet<ImportedLibrary>();
    Set<DefinedVariable> defvars = new LinkedHashSet<DefinedVariable>();
    Set<UndefinedVariable> vardecls = new LinkedHashSet<UndefinedVariable>();
    Set<StmtNode> stmts = new LinkedHashSet<StmtNode>();
    Set<DefinedFunction> defuns = new LinkedHashSet<DefinedFunction>();
    Set<UndefinedFunction> funcdecls = new LinkedHashSet<UndefinedFunction>();
    Set<TypedefNode> typedefs = new LinkedHashSet<TypedefNode>();
    
    public void add(Declarations decls) {
    	implibs.addAll(decls.implibs);
        defvars.addAll(decls.defvars);
        vardecls.addAll(decls.vardecls);
        funcdecls.addAll(decls.funcdecls);
        typedefs.addAll(decls.typedefs);
    }
    
    // ImportedLibrary operation
    public void addImplib(ImportedLibrary lib) {
    	implibs.add(lib);
    }

    public void addImplibs(List<ImportedLibrary> libs) {
    	implibs.addAll(libs);
    }
    
    public List<ImportedLibrary> implibs() {
        return new ArrayList<ImportedLibrary>(implibs);
    }

    // DefinedVariable operation
    public void addDefvar(DefinedVariable var) {
        defvars.add(var);
    }

    public void addDefvars(List<DefinedVariable> vars) {
        defvars.addAll(vars);
    }

    public List<DefinedVariable> defvars() {
        return new ArrayList<DefinedVariable>(defvars);
    }

    // UndefinedVariable operation
    public void addVardecl(UndefinedVariable var) {
        vardecls.add(var);
    }

    public List<UndefinedVariable> vardecls() {
        return new ArrayList<UndefinedVariable>(vardecls);
    }
    
    // StmtNode operation
    public void addStmt(StmtNode stmt) {
    	stmts.add(stmt);
    }
    
    public List<StmtNode> stmts() {
        return new ArrayList<StmtNode>(stmts);
    }

    // DefinedFunction operation
    public void addDefun(DefinedFunction func) {
        defuns.add(func);
    }

    public List<DefinedFunction> defuns() {
        return new ArrayList<DefinedFunction>(defuns);
    }

    // UndefinedFunction operation
    public void addFuncdecl(UndefinedFunction func) {
        funcdecls.add(func);
    }

    public List<UndefinedFunction> funcdecls() {
        return new ArrayList<UndefinedFunction>(funcdecls);
    }

    // TypedefNode operation
    public void addTypedef(TypedefNode n) {
        typedefs.add(n);
    }

    public List<TypedefNode> typedefs() {
        return new ArrayList<TypedefNode>(typedefs);
    }
}
