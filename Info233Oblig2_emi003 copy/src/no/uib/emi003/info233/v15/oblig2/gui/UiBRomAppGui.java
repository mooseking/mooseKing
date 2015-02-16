package no.uib.emi003.info233.v15.oblig2.gui;



import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
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
	

	public UiBRomAppGui() {
		super();
		setBounds(new Rectangle(500,300));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		JPanel panel= new JPanel(new GridLayout(1,2));
//		JPanel buttonPanel = new JPanel();
		add(panel);

		mainParser = new ParserRomAppUib();
		
/*
		mainList = mainParser.generateLinkDB("http://rom.app.uib.no/ukesoversikt/?entry=byggrom");
		categoryListModel = new DefaultListModel<String>();
		categoryList = new JList<String>(categoryListModel);
//		addToList(mainList.);
		addToList(mainParser.generateLinkDB("http://rom.app.uib.no/ukesoversikt/?entry=byggrom"));

		svarOmraade = new JTextArea();
		svarOmraade.setLineWrap(true);
		svarOmraade.setWrapStyleWord(true);

		panel.add(categoryList);
		panel.add(buttonPanel);
		panel.add(svarOmraade);

		selectButton = new JButton("image");
		selectButton.setSize(100, 40);
		selectButton.addActionListener(this);
//		selectButton.setIcon(defaultIcon);
		categoryList.addListSelectionListener(this);

		buttonPanel.add(new JLabel("bilde"));
		buttonPanel.add(selectButton);

*/

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
