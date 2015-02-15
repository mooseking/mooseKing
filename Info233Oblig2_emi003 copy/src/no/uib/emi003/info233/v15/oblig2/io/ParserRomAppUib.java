package no.uib.emi003.info233.v15.oblig2.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.uib.emi003.info233.v15.oblig2.models.Activity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
/**
 * This class will handle the parsing methods. 
 * Constr. generates a new object of the class StringRefiner, 
 * witch is just a helper for the different parsing methods.
 * 
 * Methods: docToDoList, generateLinkDB, 
 * @author emi003
 * @version alpha
 *
 */

public class ParserRomAppUib implements ParserInterface
{
	
private StringRefiner stringRefiner;
private List<Document> documentList;
private ArrayList<String> baseURIDB;
private ArrayList<Node> nodeList;
	
	public ParserRomAppUib() 
	{
		stringRefiner = new StringRefiner();
	}
	
	/**
	 * Initializes the document for processing.
	 * @throws IOException 
	 */
/*	public void docToDoList() throws IOException
	{
		documentList = new ArrayList<Document>();
		ArrayList<String> array11 = generateLinkDB("http://rom.app.uib.no/ukesoversikt/?entry=byggrom");
		for(String E : array11)
		{
			Document doc = Jsoup.parse(stringRefiner.urlToString(E)); 
			documentList.add(doc);
			
		}
		System.out.println(documentList.size());
		System.out.println(documentList.get(0));
	}*/
	
	/**
	 * Generates list of url to be parsed.
	 * @return an ArrayList to docToDoList
	 * @throws IOException
	 */
	private ArrayList<String> generateLinkDB(String inboundURL) throws IOException
	{
		Document urlTrace = Jsoup.parse(stringRefiner.urlToString(inboundURL));
		Elements urlListBuildings = urlTrace.getElementsByAttributeValueMatching("value",":" );
		ArrayList<String> listOfLinksToParser = new ArrayList<String>();		
		for(Element element : urlListBuildings)
		{	
			Document urlTraceN2 = Jsoup.parse(stringRefiner.urlToString(inboundURL+"&building="+element.attr("value")));
			Elements urlListBuildingsN2 = urlTraceN2.getElementsByAttributeValueMatching("value", ":[A-Za-z0-9]");		// [A-Za-z0-9] Kriteret her forutsetter at rom har en id til høyre for ":", noe bygninger ikke har. Dette eliminerer uaktuelle linker. Håper ingen rom kjører special chars i navnet sitt. 	
			for(Element element1 : urlListBuildingsN2)
			{	
				listOfLinksToParser.add(inboundURL+"&building="+element.attr("value")+"&room="+element1.attr("value"));
			}
		}
		return listOfLinksToParser;
	}
	
	/**
	 * Initializes the document for processing.
	 * @throws IOException 
	 */
	@Override
	public void docToLists() throws IOException 
	{
		{
			documentList = new ArrayList<Document>();
			baseURIDB = generateLinkDB("http://rom.app.uib.no/ukesoversikt/?entry=byggrom");
			for(String E : baseURIDB)
			{
				Document doc = Jsoup.parse(stringRefiner.urlToString(E)); 
				documentList.add(doc);
				
			}
			System.out.println(documentList.size());
			System.out.println(baseURIDB.size());
		}
		
	}
	@Override
	public List<Node> nodesToList(Node node, Node parent, List<Node> nodeList) 
	{
		
		return null;
	}
	@Override
	public List<Node> getNodeList() throws IOException 
	{
		nodeList = new ArrayList<Node>();
		nodeList = Jsoup.parse(documentList.get(2), );
		//nodeList.add(Jsoup.parse(stringRefiner.urlToString(baseURIDB.get(1))).childNode(0));
		/*for(Node e : nodeList)
		{
			System.out.println(e);
		}*/
		System.out.println(nodeList.size());
		
		return null;
	}
	@Override
	public List<Activity> getActivityList() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<String> getDateStringList() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	

}
