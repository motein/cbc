package main;

import visitor.LiveApp;
import visitor.SocialApp;

public class VisitorClient {

	public static void main(String[] args) {
		startProject();
	}
	
    public static void startProject(){
        BigHuYouCompany bigHuYou= new BigHuYouCompany();
        System.out.println("-----------------Start Social App project--------------------");
        bigHuYou.startProject(new SocialApp());
        System.out.println("-----------------Start Live App project--------------------");
        bigHuYou.startProject(new LiveApp());
    }

}
