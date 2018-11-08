package com.hereisalexius.everything_ok;

import java.io.IOException;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import com.hereisalexius.everything_ok.utils.JsoupShortcuts;

public class MakeEverythingOkFinder implements ButtonFindable {

	public static final String BUTTON_ID = "make-everything-ok-button";

	private SimpleAttributeCriteria sc = new SimpleAttributeCriteria(1);
	private SimpleAttributeCriteria cc = new SimpleAttributeCriteria(5, "class");
	private SimpleAttributeCriteria hc = new SimpleAttributeCriteria(3, "href");
	private SimpleAttributeCriteria tc = new SimpleAttributeCriteria(2 ,"title");

	public String findButton(String originalFilePath, String customFilePath) {
		String result = "";
		try {
			Document originalDoc = JsoupShortcuts.getDocument(originalFilePath);
			Document customDoc = JsoupShortcuts.getDocument(customFilePath);


			Element vanilaBtn = originalDoc.getElementById(BUTTON_ID);

			Element candidate = null;
			int highestMark = 0;

			for (Attribute attr : vanilaBtn.attributes()) {
				String key = attr.getKey();
				int mark = 0;
				for (Element other : customDoc.getElementsByAttribute(attr.getKey())) {

					SimpleAttributeCriteria curCrit = sc;
					int valueToInc = 0;
					switch (key) {
					case "class":
						curCrit = cc;
						break;
					case "href":
						curCrit = hc;
						break;
					case "title":
						curCrit = tc;
						break;
					}

					mark += curCrit.check(attr, other).getMark();
					if (mark > highestMark) {
						highestMark = mark;
						candidate = other;
					}
				}
			}

			result = candidate.cssSelector();
		} catch (IOException e) {
			result = "Error reading [{}] file";
		} finally {
			return result;
		}

	}

}
