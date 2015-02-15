package no.uib.emi003.info233.v15.oblig2.io;

import org.jsoup.nodes.Node;

public class LinkedList {
	
	private int N;
	private Node first;

	public LinkedList() 
	{
		
	}
	private class Node
	{
		private final int id; 
		private String data;
		public Node(int i, String d)
		{
			this.id = i;
			this.data = d;
		}
	}
	
	public String get something(int a)
	{
		return a.data();
	}
	public void setNode()
	{
		 
		
	}
}
