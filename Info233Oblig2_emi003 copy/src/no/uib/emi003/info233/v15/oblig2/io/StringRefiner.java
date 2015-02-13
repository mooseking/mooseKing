package no.uib.emi003.info233.v15.oblig2.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
/**
 * This class will take in the current input URL, 
 * strip out first url line and returns the rest as a string.
 * @author emi003
 * @version work in progress
 *
 */

public class StringRefiner {
	/**
	 * Constructor. Nothing to construct.
	 */
	public StringRefiner() {

	}
	/**
	 * Method will convert an URL, through InputStream and BufferedReader, and return a String
	 * @param htmlIn Input URL to be converted.
	 * @return Returns processed URL as a string.
	 * @throws IOException If something is not behaving as they should do.
	 */
	public String urlToString(String htmlIn) throws IOException{
		URL target = new URL(htmlIn);
		BufferedReader urlDokument = new BufferedReader(new InputStreamReader(target.openStream()));
		
		urlDokument.readLine(); // Remove problematic top html line
		StringBuilder htmlPrepared = new StringBuilder();
		
		String line;
//		try {
			while((line = urlDokument.readLine()) != null) {
				htmlPrepared.append(line);
				}

//		System.out.println(htmlPrepared);
//		System.out.println(htmlPrepared.length());
		urlDokument.close();
		return htmlPrepared.toString();
		
	}

}
