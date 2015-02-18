package no.uib.emi003.info233.v15.oblig2.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import no.uib.emi003.info233.v15.oblig2.gui.UiBRomAppGui;
import no.uib.emi003.info233.v15.oblig2.io.ParserRomAppUib;
import no.uib.emi003.info233.v15.oblig2.models.Activity;
/**
 * Main Class
 * @author plauge
 *
 */

public class UIBRomAppINFO233emi003 {
	/**
	 * Main Constructor
	 * @throws IOException 
	 */
	

	public UIBRomAppINFO233emi003() throws IOException {
		@SuppressWarnings("unused")
		UiBRomAppGui appWindow = new UiBRomAppGui();		
	}
	public static void exitOperation(){
		System.exit(0);
	}
	/**
	 * Main method
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("unused")
		UIBRomAppINFO233emi003 mainUIBRomApp = new UIBRomAppINFO233emi003();
		
		ParserRomAppUib test = new ParserRomAppUib();
//		
		//test.docToLists(4);//("http://rom.app.uib.no/ukesoversikt/?entry=byggrom");
//		
		List<Activity> activityList = test.getActivityList(88);
		System.out.println(activityList.get(0).toString());
//			Syste/m.out.println(activityList.size());
//			Syst/em.out.println(activityList.get(7));
	
//		System.out.println(activityList.size());
//		System.out.println(activityList.get(0));
//		System.out.println(activityList.get(1));
//		System.out.println(activityList.get(2));

//		System.out.println(activityList.hashCode());
		
	}


}
