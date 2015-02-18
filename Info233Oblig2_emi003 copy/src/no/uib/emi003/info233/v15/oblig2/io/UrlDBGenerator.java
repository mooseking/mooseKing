package no.uib.emi003.info233.v15.oblig2.io;

import java.io.IOException;
/**
 * UrlDBGenerator
 * Generates an Arraylist database of input url.
 * 
 * contains only one method - generateLinkDB().
 * @author emi003
 * 
 */
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UrlDBGenerator {
	private StringRefiner stringRefiner;

	public UrlDBGenerator() {
		stringRefiner = new StringRefiner();
	}
	
	/**
	 * 
	 * @param inboundURL
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> generateLinkDB(String inboundURL) throws IOException {
		Document urlTrace = Jsoup.parse(stringRefiner.urlToString(inboundURL));
		Elements urlListBuildings = urlTrace.getElementsByAttributeValueMatching("value",":" );
		ArrayList<String> listOfLinksToParser = new ArrayList<String>();		
		for(Element element : urlListBuildings){	
			Document urlTraceN2 = Jsoup.parse(stringRefiner.urlToString(inboundURL+"&building="+element.attr("value")));
			Elements urlListBuildingsN2 = urlTraceN2.getElementsByAttributeValueMatching("value", ":[A-Za-z0-9]");		// [A-Za-z0-9] Kriteriet her forutsetter at rom har en id til høyre for ":", noe bygninger ikke har. Dette eliminerer uaktuelle linker. Håper ingen rom kjører special chars i navnet sitt. 	
			for(Element element1 : urlListBuildingsN2){	
				listOfLinksToParser.add(inboundURL+"&building="+element.attr("value")+"&room="+element1.attr("value"));
			}
		}
		return listOfLinksToParser;
	}
}
