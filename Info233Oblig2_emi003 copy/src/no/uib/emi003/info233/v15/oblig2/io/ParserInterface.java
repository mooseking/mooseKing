package no.uib.emi003.info233.v15.oblig2.io;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import no.uib.emi003.info233.v15.oblig2.models.Activity;

import org.jsoup.nodes.Node;

public interface ParserInterface {

	/**
	 * Initializes different classes, like builders and the document
	 * @throws MalformedURLException 
	 * @throws IOException 
	 */
	public abstract void docToLists() throws IOException;

	/**
	 * Recursive parser
	 *
	 * @param node
	 *            the root node of the part of the document to be parsed
	 * @param parent
	 *            the parent is needed to add the content in the node without
	 *            children
	 * @param nodeList
	 *            the nodeList to add the nodes to
	 */
	public abstract List<Node> nodesToList(Node node, Node parent,
			List<Node> nodeList);

	public abstract List<Node> getNodeList() throws IOException;

	public abstract List<Activity> getActivityList();

	public abstract List<String> getDateStringList();

}