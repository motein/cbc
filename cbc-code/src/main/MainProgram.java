package main;

import java.io.File;
import java.util.List;

import net.loveruby.cflat.ast.AST;
import net.loveruby.cflat.entity.DefinedFunction;
import net.loveruby.cflat.entity.DefinedVariable;
import net.loveruby.cflat.exception.FileException;
import net.loveruby.cflat.exception.SyntaxException;
import net.loveruby.cflat.parser.LibraryLoader;
import net.loveruby.cflat.parser.Parser;
import net.loveruby.cflat.utils.ErrorHandler;

public class MainProgram {

	private final static ErrorHandler errorHandler = new ErrorHandler("MainProgram ");
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		
		String path = String.format("%s\\%s", System.getProperty("user.dir"), "src\\main\\test\\add.cb");
		System.out.println(path);
		try {
			AST ast = Parser.parseFile(new File(path), new LibraryLoader(), errorHandler, false);
			ast.dump();
			
			List<DefinedVariable> varList = ast.definedVariables();
			System.out.println("Defined Var Size: " + varList.size());
			
			List<DefinedFunction> funcList = ast.definedFunctions();
			System.out.println("Defined Func Size: " + funcList.size());
			
			// Semantic Analyzer; like type check.
		} catch (SyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
