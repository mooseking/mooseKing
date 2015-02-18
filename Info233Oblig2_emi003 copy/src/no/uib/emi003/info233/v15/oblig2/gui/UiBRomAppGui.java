package no.uib.emi003.info233.v15.oblig2.gui;



import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.google.common.collect.ArrayListMultimap;

import no.uib.emi003.info233.v15.oblig2.io.ParserRomAppUib;
import no.uib.emi003.info233.v15.oblig2.main.UIBRomAppINFO233emi003;

public class UiBRomAppGui extends JFrame implements ActionListener, ListSelectionListener{
	

	/**
	 * UiBRomAppGui - GUIClass for application
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> categoryListModel;
	private ParserRomAppUib mainParser;
	private JList<String> categoryList;
	private ArrayListMultimap<String,String> mainList;
	private List<String> linkOfRooms;
	private JMenuBar menuBar;
	private JMenu menu, submenu;
	private JMenuItem menuItem;
	private JFrame frame;
	private JMenu startMenu;
	private JMenu aboutMenu;
	private JMenu listBuildingAndRoom;
	private JMenuItem generateDBMenuItem;
	private JMenuItem aboutMenuItem;
	private JMenuItem closeButton;
	private JMenuItem buildingButton;
	private JTable jTable;
	private ScrollPane scrollPane;
	
	
	

	public UiBRomAppGui() throws IOException {
		frame = new JFrame("GUrI");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		frame.setLocation(200,200);
		
		scrollPane = new ScrollPane();
		
		addGUImenu();
		addTable();
				
		frame.add(scrollPane);
		frame.setVisible(true);
		scrollPane.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void addGUImenu(){
		menuBar = new JMenuBar();
		
		
		startMenu = new JMenu("Start");
		generateDBMenuItem = new JMenuItem("Generate Link DB");
		generateDBMenuItem.addActionListener(this);
		closeButton = new JMenuItem("Close");
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UIBRomAppINFO233emi003.exitOperation();
				
			}
		});
		
		startMenu.getAccessibleContext().setAccessibleDescription("Start");
		startMenu.add(generateDBMenuItem);
		startMenu.addSeparator();
		startMenu.add(closeButton);
		
		listBuildingAndRoom = new JMenu("List Buildings");
		buildingButton = new JMenuItem("List Buildings");
		buildingButton.addActionListener(this);
		listBuildingAndRoom.add(buildingButton);
		
		aboutMenu = new JMenu("About");
		aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(this);
		aboutMenu.add(aboutMenuItem);
		
		menuBar.add(startMenu);
		menuBar.add(listBuildingAndRoom);
		menuBar.add(aboutMenu);
		
		frame.setJMenuBar(menuBar);
		
		
	
	}
	private void addTable(){
		//jTable = new JTable(9,6);
		String[] rowNames = {"Monday","Tuesday","Wensday","Thursday","Friday"};
		String[] colomnNames ={"8 o'clock","9 o'clock","10 o'clock","11 o'clock","12 o'clock","13 o'clock","14 o'clock","15 o'clock"};
		
		Object[][] inData ={{"no data","no data","no data","no data","no data"},
				{"no data","no data","no data","no data","no data"},
				{"no data","no data","no data","no data","no data"},
				{"no data","no data","no data","no data","no data"},
				{"no data","no data","no data","no data","no data"},
				{"no data","no data","no data","no data","no data"},
				{"no data","no data","no data","no data","no data"},
				{"no data","no data","no data","no data","no data"}};
		
		jTable = new JTable(inData,rowNames);
		jTable.setPreferredScrollableViewportSize(new Dimension(900,600));
		jTable.setFillsViewportHeight(false);
		add(scrollPane);
		
		scrollPane.add(jTable, frame);
		
	}

}
