package main;

import java.util.List;

import parser.LanguageWithNewLineParser;
import parser.ParseException;
import parser.Token;

public class CallMain {

	public static void main(String[] args) {
        try {
//            System.out.println(LanguageWithNewLineParser.evaluateAdd("2+4"));
//            List<List<Token>> tokenList = LanguageWithNewLineParser.evaluateLines("c!fdfdsfas\na,b,c!dfadfa\ncccc");
//            for (List<Token> tl : tokenList) {
//            	for (Token t : tl) {
//            		System.out.println(t.image);
//            	}
//            }
            
            List<String> stmtList = LanguageWithNewLineParser.evaluateStmts("c!fdfdsfas\na$,b,c$!dfadfa\ncccc");
            for (String t2 : stmtList) {
            	System.out.println(t2);
            }
        }
        catch (ParseException ex) {
            System.err.println(ex.getMessage());
        }
	}

}
