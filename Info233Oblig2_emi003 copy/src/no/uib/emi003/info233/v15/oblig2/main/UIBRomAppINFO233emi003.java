package no.uib.emi003.info233.v15.oblig2.main;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Node;

import no.uib.emi003.info233.v15.oblig2.io.ParserInterface;
import no.uib.emi003.info233.v15.oblig2.io.ParserRomAppUib;
import no.uib.emi003.info233.v15.oblig2.models.Activity;

public class UIBRomAppINFO233emi003 {

	public UIBRomAppINFO233emi003() {
		
	}

	public static void main(String[] args) throws IOException {
		ParserRomAppUib test = new ParserRomAppUib();
		test.generateLinkDB("http://rom.app.uib.no/ukesoversikt/?entry=byggrom");
		test.docToDoList();
		

	}


}
