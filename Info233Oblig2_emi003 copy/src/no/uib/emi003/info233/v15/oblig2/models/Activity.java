package no.uib.emi003.info233.v15.oblig2.models;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import org.jsoup.nodes.Node;

public class Activity implements ActivityInterface, Serializable {
	private Node activityNode;
	private ArrayList<Node> roomActivityList;
	private static final long serialVersionUID = -4962193791986602328L;

	public Activity(ArrayList<Node> listOfRoomActivites) {
		roomActivityList = listOfRoomActivites;
		
	}

	@Override
	public Node getNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRoom() {
		return roomActivityList.get(0).childNode(1).childNode(0).childNode(0).attributes().toString().substring(6);
	}

	@Override
	public Calendar getBeginTime() {
		int uke;
		String ukeNr = roomActivityList.get(1).childNode(1).childNode(0).attributes().toString().substring(7, 9);
		uke = Integer.parseInt(ukeNr);
		int jao = Calendar.WEEK_OF_YEAR;
		System.out.println((uke)+"   hurra   "+jao);
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calendar getEndTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "fuck this";
	}

}
