package main;

import java.io.File;
import java.util.List;

import editors.rmb.parser.RMBParser;
import editors.rmb.parser.ast.AST;
import editors.rmb.parser.entity.DefinedFunction;
import editors.rmb.parser.entity.DefinedVariable;
import editors.rmb.parser.exception.FileException;
import editors.rmb.parser.exception.OptionParseError;
import editors.rmb.parser.exception.SyntaxException;
import editors.rmb.parser.utils.ErrorHandler;

public class MainProgram {

	private final static ErrorHandler errorHandler = new ErrorHandler("RMB MainProgram ");
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		String path = "./src/main/loop_test.asc";
		Options opts = parseOptions(args);
		try {
			AST ast = RMBParser.parseFile(new File(path), opts.loader(), errorHandler, opts.doesDebugParser());
			ast.dump();
			
			List<DefinedVariable> varList = ast.definedVariables();
			System.err.println("\nDefined Var Size: " + varList.size());
			
			List<DefinedFunction> funcList = ast.definedFunctions();
			System.err.println("Defined Func Size: " + funcList.size());
			
			// Semantic Analyzer; like type check.
		} catch (SyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    private static Options parseOptions(String[] args) {
        try {
            return Options.parse(args);
        }
        catch (OptionParseError err) {
            errorHandler.error(err.getMessage());
            System.exit(1);
            return null;   // never reach
        }
    }

}
