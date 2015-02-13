package no.uib.emi003.info233.v15.oblig2.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import no.uib.emi003.info233.v15.oblig2.models.Activity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class ParserRomAppUib implements ParserInterface{
	
private StringRefiner stringRefiner;

	public ParserRomAppUib() {
		StringRefiner stRe = new StringRefiner();
		stringRefiner = stRe;
	}
	
	/**
	 * Initializes the document for processing.
	 * @throws IOException 
	 */
	public void docToDoList() throws IOException{
		Document doc = Jsoup.parse(stringRefiner.urlToString("http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building=A55%3A&room=A55%3AG292"));
		Elements div = doc.select("select > activity");
		for(Element element : div){
			System.out.println(element);
		}
	}
	
	/**
	 * Generates list of url to be parsed.
	 * @throws IOException
	 */
	public void generateLinkDB(String inboundURL) throws IOException{
		Document urlTrace = Jsoup.parse(stringRefiner.urlToString(inboundURL));
		Elements urlListBuildings = urlTrace.getElementsByAttributeValueMatching("value",":" );
		ArrayList<String> linkList = new ArrayList<String>();
		int counter = 0;
		for(Element element : urlListBuildings){			
			Document urlTraceN2 = Jsoup.parse(stringRefiner.urlToString("http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building="+element.attr("value")));
			Elements urlListBuildingsN2 = urlTraceN2.getElementsByAttributeValueMatching("value", ":[A-Za-z0-9]");		// Kriteret her forutsetter at rom har en id til høyre for ":", noe bygninger ikke har. Dette eliminerer uaktuelle linker. Håper ingen rom kjører special chars i navnet sitt. 	
			
			for(Element element1 : urlListBuildingsN2){		
			System.out.println("http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building="+element.attr("value")+"&room="+element1.attr("value"));
			linkList.add("http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building="+element.attr("value")+"&room="+element1.attr("value"));
			counter++;			
			}
		}
		System.out.println(counter);
		System.out.println(linkList.size());
	}
	
	@Override
	public void docToLists() throws IOException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Node> nodesToList(Node node, Node parent, List<Node> nodeList) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Node> getNodeList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Activity> getActivityList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<String> getDateStringList() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
