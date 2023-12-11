package main;

import java.util.Arrays;
import java.util.ListIterator;

import editors.rmb.parser.LibraryLoader;
import editors.rmb.parser.exception.OptionParseError;

public class Options {

    static Options parse(String[] args) {
        Options opts = new Options();
        opts.parseArgs(args);
        return opts;
    }
    
    private LibraryLoader loader = new LibraryLoader();
    private boolean debugParser = false;
    
    void parseArgs(String[] origArgs) {
    	ListIterator<String> args = Arrays.asList(origArgs).listIterator();
    	while (args.hasNext()) {
    		String arg = args.next();
    		
    		if (arg.equals("--debug-parser")) {
                debugParser = true;
            } else if (arg.startsWith("-I")) {
            	loader.addLoadPath(getOptArg(arg, args));
            }
    	}
    }
    
    private String getOptArg(String opt, ListIterator<String> args) {
        String path = opt.substring(2);
        if (path.length() != 0) {       // -Ipath
            return path;
        }
        else {                          // -I path
            return nextArg(opt, args);
        }
    }
    
    private String nextArg(String opt, ListIterator<String> args) {
        if (! args.hasNext()) {
            parseError("missing argument for " + opt);
        }
        return args.next();
    }
    
    private void parseError(String msg) {
        throw new OptionParseError(msg);
    }
    
    LibraryLoader loader() {
        return this.loader;
    }
    
    boolean doesDebugParser() {
        return this.debugParser;
    }
    
}
