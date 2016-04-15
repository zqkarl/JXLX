package me.qisama.jxlx.util;

public class Utils {

	/**
	 * 转义字符串
	 * @param a 需要处理的字符串
	 * @return
	 */
	public static String escape(String a) {
		a = a.replace("&", "&amp;");
		a = a.replace("<", "&lt;");
		a = a.replace(">", "&gt;");
		a = a.replace("\"", "&quot;");
		a = a.replace("'", "&#x27;");
		a = a.replace("/", "&#x2f;");
		return a;
	}
}
