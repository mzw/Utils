package jp.mzw.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class StringUtils {
	
	/**
	 * Gets a URL from given path using given base URL
	 * @param base Given base URL
	 * @param href Given path
	 * @return A URL of given path
	 * @throws MalformedURLException Cannot create URL instances
	 */
	public static String getUrlByHref(String base, String href) throws MalformedURLException {
		URL _base = new URL(base);
		URL _href = new URL(_base, href);
		return _href.toString();
	}
	
	/**
	 * Gets a filename from given URL
	 * @param url Given URL
	 * @return A filename
	 */
	public static String getFilename(String url) {
		File _url = new File(url);
		return _url.getName();
	}
	
	/**
	 * Gets a host from given URL
	 * @param url Given URL
	 * @return a host name
	 * @throws URISyntaxException
	 */
	public static String getHostName(String url) throws URISyntaxException {
		URI uri = new URI(url);
		return uri.getHost();
	}

	public static String esc4xml(String str) {
		String escaped = str;
		if(escaped != null) {
			escaped = escaped.replaceAll("&lt;", "<");
			escaped = escaped.replaceAll("&gt;", ">");
			escaped = escaped.replaceAll("&quot;", "\"");
			escaped = escaped.replaceAll("&apos;", "'");
			escaped = escaped.replaceAll("&amp;", "&");
			
			escaped = escaped.replaceAll("&", "&amp;");
			escaped = escaped.replaceAll("<", "&lt;");
			escaped = escaped.replaceAll(">", "&gt;");
			escaped = escaped.replaceAll("\"", "&quot;");
			escaped = escaped.replaceAll("'", "&apos;");
		}
		return escaped;
	}
	public static String esc4dot(String str) {
		String ret = str;
		if(ret != null) {
			ret = ret.replaceAll("\\\\\"", "\"");			
			
			ret = ret.replaceAll("\"", "\\\\\"");
			ret = ret.replaceAll("\\.", "\\\\.");
			ret = ret.replaceAll("\n", " ");
		}
		return ret;
	}
	
	public static String removeQuote(String str) {
		String ret = str;
		if(str == null || "".equals(str) || str.length() < 2) {
			return "";
		}
		if(str.charAt(0) == '"' && str.charAt(str.length()-1) == '"') {
			ret = str.substring(1, str.length() - 1);
		}
		if(str.charAt(0) == '\'' && str.charAt(str.length()-1) == '\'') {
			ret = str.substring(1, str.length() - 1);
		}
		return ret;
	}
}