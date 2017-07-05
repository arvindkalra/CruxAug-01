package Lecture23;

import Lecture18.LinkedList;

public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		HashMap<String, Integer> hm = new HashMap<>(3);

		hm.put("CHINA", 2000);
		hm.display();

		hm.put("INDIA", 1200);
		hm.display();

		hm.put("PAK", 800);
		hm.display();

		hm.put("USA", 200);
		hm.display();

		hm.put("UK", 150);
		hm.display();

		hm.put("UAE", 20);
		hm.display();

		hm.put("BRAZIL", 500);
		hm.display();

		hm.put("NIGERIA", 250);
		hm.display();

		hm.put("NIGERIA", 350);
		hm.display();

		hm.Remove("PAK");
		hm.display();
		System.out.println(hm.size());
		System.out.println(hm.Get("NIGERIA"));

	}

}
