package no.uib.emi003.info233.v15.oblig2.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
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
private ArrayList<Document> documentList;
private ArrayList<String> baseURIDB;
private List<Node> nodeList2;
private List<List<Node>> nodeList;
private UrlDBGenerator urlGen;

	public ParserRomAppUib() 
	{
		stringRefiner = new StringRefiner();
		urlGen = new UrlDBGenerator();
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
	 
	private ArrayList<String> generateLinkDB(String inboundURL) throws IOException
	{
		Document urlTrace = Jsoup.parse(stringRefiner.urlToString(inboundURL));
		Elements urlListBuildings = urlTrace.getElementsByAttributeValueMatching("value",":" );
		ArrayList<String> listOfLinksToParser = new ArrayList<String>();		
		for(Element element : urlListBuildings)
		{	
			Document urlTraceN2 = Jsoup.parse(stringRefiner.urlToString(inboundURL+"&building="+element.attr("value")));
			Elements urlListBuildingsN2 = urlTraceN2.getElementsByAttributeValueMatching("value", ":[A-Za-z0-9]");		// [A-Za-z0-9] Kriteriet her forutsetter at rom har en id til høyre for ":", noe bygninger ikke har. Dette eliminerer uaktuelle linker. Håper ingen rom kjører special chars i navnet sitt. 	
			for(Element element1 : urlListBuildingsN2)
			{	
				listOfLinksToParser.add(inboundURL+"&building="+element.attr("value")+"&room="+element1.attr("value"));
			}
		}
		return listOfLinksToParser;
	}*/
	
	/**
	 * Initializes the document for processing.
	 * @throws IOException 
	 */
	@Override
	public void docToLists() throws IOException 
	{	nodeList = new ArrayList<List<Node>>();
		nodeList2 = new ArrayList<Node>();
		documentList = new ArrayList<Document>();
		baseURIDB = urlGen.generateLinkDB("http://rom.app.uib.no/ukesoversikt/?entry=byggrom");
		for(String E : baseURIDB) // outed to reduce load during dev.
		{
			Document doc = Jsoup.parse(stringRefiner.urlToString(E)); 
			documentList.add(doc);			
		}
	
		Document doc = Jsoup.parse(stringRefiner.urlToString("http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building=A55%3A&room=A55%3AG292"));
		Document doc1 = Jsoup.parse(stringRefiner.urlToString("http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building=A55%3A&room=A55%3AG316"));
		Document doc2 = Jsoup.parse(stringRefiner.urlToString("http://rom.app.uib.no/ukesoversikt/?entry=byggrom&building=A55%3A&room=A55%3AG366"));
		documentList.add(doc);
		documentList.add(doc1);
		documentList.add(doc2);
		System.out.println(documentList.size());
		Node node3 = documentList.get(0).getElementsByTag("td").get(2);//getElementsByAttributeValueMatching("emne", "[A-Z]").get(0);
		Node node4 = documentList.get(0).getElementsByTag("td").get(3);
		
		Node node = doc.getElementsByTag("option").get(3).nextSibling();
		Node node2 = doc.getElementsByTag("option").get(3);

		
		ArrayList<Node> nodeList3 = new ArrayList<Node>();
		ArrayList<String> documentList2 = new ArrayList<String>();
		
		for(Document d : documentList){
			
			Node node22 = d.childNode(0);
			nodeList3.add(node22);
			System.out.println(node22.nodeName());

		}
		nodesToList(node, null, nodeList3);
		nodeList2.add(node);
		nodeList2.add(node2);
		nodeList2.add(node3);
		nodeList2.add(node4);
		
		System.out.println(nodeList3.size());

	}
	@Override
	public List<Node> nodesToList(Node node, Node parent, List<Node> nodeList) 
	{
		nodeList.add(node);
		return null;
	}
	@Override
	public List<Node> getNodeList() throws IOException 
	{
		
		/*
		nodeList = new ArrayList<Node>();
//		nodeList = 
		Elements listUseInParseFragment = documentList.get(0).absUrl(null);
		System.out.println(Jsoup.parseFragment(stringRefiner.urlToString(baseURIDB.get(0)), , baseURIDB.get(0)));
		//nodeList.add(Jsoup.parse(stringRefiner.urlToString(baseURIDB.get(1))).childNode(0));
		/*for(Node e : nodeList)
		{
			System.out.println(e);
		}
		System.out.println(nodeList.size());*/
		
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
