package codekata;

import java.util.LinkedHashMap;

public class TestingLinkedHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, String> lhm = new LinkedHashMap<String, String>(
				10, .75f, true);
		lhm.put("One", "1");
		lhm.put("Two", "2");
		lhm.get("One");
		printIterator(lhm);
	}

	public static void printIterator(LinkedHashMap<String, String> lhm) {
		for (String str : lhm.keySet())
			System.out.println(str);
	}

}
