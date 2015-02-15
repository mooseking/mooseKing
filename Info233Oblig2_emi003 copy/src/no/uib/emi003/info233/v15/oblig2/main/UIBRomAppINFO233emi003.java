package no.uib.emi003.info233.v15.oblig2.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.jsoup.nodes.Node;

import no.uib.emi003.info233.v15.oblig2.gui.UiBRomAppGui;
import no.uib.emi003.info233.v15.oblig2.io.ParserInterface;
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
	 */
	

	public UIBRomAppINFO233emi003() {
//		UiBRomAppGui appWindow = new UiBRomAppGui();		
	}
	/**
	 * Main method
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		UIBRomAppINFO233emi003 mainUIBRomApp = new UIBRomAppINFO233emi003();
		
		ParserRomAppUib test = new ParserRomAppUib();
//		test.docToDoList();
		test.docToLists();//("http://rom.app.uib.no/ukesoversikt/?entry=byggrom");
//		Node node2 = new Node("<html>", );
//		List<Node> nodeList = test.nodesToList(node, parent, nodeList)
		test.getNodeList();
	}


}
