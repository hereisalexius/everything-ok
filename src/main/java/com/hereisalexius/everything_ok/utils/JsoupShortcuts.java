package com.hereisalexius.everything_ok.utils;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupShortcuts {

	private static String CHARSET_NAME = "utf8";

	public static Document getDocument(String filePath) throws IOException {
		File htmlFile = new File(filePath);
		return Jsoup.parse(htmlFile, CHARSET_NAME, htmlFile.getAbsolutePath());
	}



}
