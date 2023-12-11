package editors.rmb.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import editors.rmb.parser.ast.Declarations;
import editors.rmb.parser.exception.CompileException;
import editors.rmb.parser.exception.FileException;
import editors.rmb.parser.exception.SemanticException;
import editors.rmb.parser.utils.ErrorHandler;

public class LibraryLoader {
    protected List<String> loadPath;
    protected LinkedList<String> loadingLibraries;
    protected Map<String, Declarations> loadedLibraries;

    static public List<String> defaultLoadPath() {
        List<String> pathes = new ArrayList<String>();
        pathes.add(".");
        return pathes;
    }

    public LibraryLoader() {
        this(defaultLoadPath());
    }

    public LibraryLoader(List<String> loadPath) {
        this.loadPath = loadPath;
        this.loadingLibraries = new LinkedList<String>();
        this.loadedLibraries = new HashMap<String, Declarations>();
    }

    public void addLoadPath(String path) {
        loadPath.add(path);
    }

    public Declarations loadLibrary(String libPath, ErrorHandler handler)
            throws CompileException {
        if (loadingLibraries.contains(libPath)) { 
            throw new SemanticException("recursive import from " + loadingLibraries.getLast() + ": " + libPath); // stop recursive import
        }
        loadingLibraries.addLast(libPath);   
        Declarations decls = loadedLibraries.get(libPath);
        if (decls != null) {
            // Already loaded import file.  Returns cached declarations.
            return decls;
        }
        decls = RMBParser.parseDeclFile(searchLibrary(libPath), this, handler);
        loadedLibraries.put(libPath, decls);
        loadingLibraries.removeLast();
        return decls;
    }

    public File searchLibrary(String libPath) throws FileException {
        try {
        	File file = new File(libPath); // Search the current path first.
            if (file.exists()) {
                return file;
            }
            
            for (String path : loadPath) { // Search in all loaded path.
                file = new File(path + "/" + libPath);
                if (file.exists()) {
                    return file;
                }
            }
            throw new FileException("no such library header file: " + libPath);
        }
        catch (SecurityException ex) {
            throw new FileException(ex.getMessage());
        }
    }
}
