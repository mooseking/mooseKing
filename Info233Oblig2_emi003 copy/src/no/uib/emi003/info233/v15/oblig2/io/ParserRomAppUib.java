package no.uib.emi003.info233.v15.oblig2.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import no.uib.emi003.info233.v15.oblig2.models.Activity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import no.uib.emi003.info233.v15.oblig2.io.UrlDBGenerator;
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
private List<Node> nodeList;
private UrlDBGenerator urlGen;
private Document doc;
private int numberOfTimesRecursiveMethodIsCalled;
private int numberOfTimesMethodFindsClass;
	public ParserRomAppUib() throws IOException 
	{
		numberOfTimesMethodFindsClass=0;
		numberOfTimesRecursiveMethodIsCalled=0;
		stringRefiner = new StringRefiner();
		urlGen = new UrlDBGenerator();
		baseURIDB = urlGen.generateLinkDB("http://rom.app.uib.no/ukesoversikt/?entry=byggrom");
		
	}
	
	/**
	 * Initializes the document for processing.
	 * @param  
	 * @throws IOException 
	 */
	@Override
	public void docToLists(int baseURIDBindex) throws IOException 
	{	
		nodeList = new LinkedList<Node>();
	
		Node curr = null;
		Document doc = Jsoup.parse(stringRefiner.urlToString(baseURIDB.get(baseURIDBindex)));
		System.out.println("yay");
		Node node = doc.childNode(0);
		System.out.println("echo nodes to lists");
		nodesToList(node,null,nodeList);
			
		
	

		System.out.println(nodeList.size());
		System.out.println(baseURIDB.get(baseURIDBindex));
	}
	
	@Override
	public List<Node> nodesToList(Node node, Node parent, List<Node> nodeList) 
	{
		numberOfTimesRecursiveMethodIsCalled++;
//		if(node.childNodes().size() == 0){
//			return nodeList;
//		}
//		
//		for(Node n : node.childNodes()){
//			nodesToList(n, node, nodeList);
//		}
		if(node.attr("class").equals("week-time") || node.attr("class").equals("markfree") || node.attr("class").equals("week-data") || node.attr("class").equals("activity") || node.attr("class").matches("uke") || node.attr("class").contains("rom")){
			nodeList.add(node);
		}
		
		//else if(node.hasAttr("class")){
		//	numberOfTimesMethodFindsClass++;	
		//}
		
		
		else if(node.childNodes().size() == 0){
			return nodeList;
		}
		else{/*
			//nodeList.add(node);
			int i = node.childNodeSize();
			int a = 0;
			for(a = 0; a <= i; a++){
				nodesToList(node.childNode(i-1), node, nodeList);
			}*/
			
			for(Node n : node.childNodes()){
				nodesToList(n, node, nodeList);
		}
			
		}

		return nodeList;
	}
	
	@Override
	public List<Node> getNodeList(int listURIDBindex) throws IOException 
	{	
		return nodeList;
	}
	
	@Override
	public List<Activity> getActivityList(int listURIDBindex) throws IOException 
	{
		docToLists(listURIDBindex);
		System.out.println("numberOfTimesRecursiveMethodIsCalled: "+numberOfTimesRecursiveMethodIsCalled);
		System.out.println("number of times class is fund: "+ numberOfTimesMethodFindsClass);
		List<Activity> activityObjectList = new ArrayList<Activity>();
		ArrayList<Node> listToBeAttachedToActivityObject = new ArrayList<Node>();
		for(Node n : nodeList){	
			if(n.attr("class").equals("week-data")){
				listToBeAttachedToActivityObject.add(nodeList.get(0));
				listToBeAttachedToActivityObject.add(nodeList.get(1));
				listToBeAttachedToActivityObject.add(n);
				listToBeAttachedToActivityObject.add(nodeList.indexOf(n));
			}
			
			//if(n.attr("class").equals("activity")){
			//	listToBeAttachedToActivityObject.add(n);
			//}
		}
		
		Activity newActivityObject = new Activity(listToBeAttachedToActivityObject);
		
		activityObjectList.add(newActivityObject);
//		
		System.out.println("Størrelsen på lista som blir lagt til i objekt: "+listToBeAttachedToActivityObject.size());
//		System.out.println("RomNr som blir hentet ut med activity metode"  :+activityObjectList.get(0).getDescription());
		for(Node e : listToBeAttachedToActivityObject){
		System.out.println(e);
		System.out.println("----------------");}
//		System.out.println(nodeList);
		System.out.println("RomNr som blir hentet ut med activity metode: "+activityObjectList.get(0).getRoom());
		System.out.println("UkeNr hentet ut med å kalle activity metode: "+activityObjectList.get(0).getBeginTime());
			
		
		
		return activityObjectList;
	}
	
	@Override
	public List<String> getDateStringList(int listURIDBindex) throws IOException 
	{
		docToLists(listURIDBindex);
		List<String> dateStringList = new ArrayList<String>();
//		Document doc = new Document(baseURIDB.get(dbIndex));
//		Elements e = doc.getElementsByAttribute("activity");
		
		
//		System.out.println(nodeList.get(3).childNode(1).childNode(0).nodeName());
		System.out.println(dateStringList.size()+"yolo");
		System.out.println(dateStringList.get(0));
//		System.out.println(list.get(200).length());
		return dateStringList;
	}
	
	/**
	 * getLinkDB() returns a list of available links.
	 * @param siteToHarvest String representation of url to mine
	 * @return ArrayList with links.
	 * @throws IOException just in case
	 */
	public ArrayList<String> getLinkDB(String siteToHarvest) throws IOException{
		return urlGen.generateLinkDB(siteToHarvest);
	}
		
	

}
