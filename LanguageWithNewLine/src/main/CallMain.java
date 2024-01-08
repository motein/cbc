package main;

import parser.LanguageWithNewLineParser;
import parser.ParseException;

public class CallMain {

	public static void main(String[] args) {
        try {
            System.out.println(LanguageWithNewLineParser.evaluateAdd("2+4"));
        }
        catch (ParseException ex) {
            System.err.println(ex.getMessage());
        }
	}

}
