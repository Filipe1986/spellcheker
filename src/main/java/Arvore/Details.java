package Arvore;

import java.util.TreeMap;

import br.unirio.pm.Tree.Node;

public class Details {

	public static void main(String args[]) {

		/* This is how to declare TreeMap */
		TreeMap<Node, Double> tmap = new TreeMap<Node, Double>();

		/* Adding elements to TreeMap */
		tmap.put(new Node("pé"), (double) 1);
		tmap.put(new Node("paa"), (double) 1);

		System.out.println(tmap.size());

		/*
		 * tmap.put(23, "Data2"); tmap.put(70, "Data3"); tmap.put(4, "Data4");
		 * tmap.put(2, "Data5");
		 */

		/*
		 * Display content using Iterator Set set = tmap.entrySet(); Iterator
		 * iterator = set.iterator(); while (iterator.hasNext()) { Map.Entry
		 * mentry = (Map.Entry) iterator.next(); System.out.print("key is: " +
		 * mentry.getKey() + " & Value is: ");
		 * System.out.println(mentry.getValue()); }
		 */

	}
}