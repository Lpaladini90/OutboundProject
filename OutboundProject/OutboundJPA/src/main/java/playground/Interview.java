package playground;

import java.util.ArrayList;

public class Interview {

	public static void main(String[] args) {

		String s = "bad creedit";

		String a = "debit cards";

		Interview in = new Interview();

		System.out.println(in.isAnagram(s, a));

	}

	public boolean isAnagram(String s, String a) {

		boolean result = false;

		if (s.length() == a.length()) {
			
			ArrayList<Character> list = new ArrayList<>();
			
			for (int j = 0; j < a.length(); j++) {
				list.add(a.charAt(j));
				
			}

			for (int i = 0; i < s.length(); i++) {

				
				if (!list.contains(s.charAt(i))) {
					return result;

				}


				
				list.remove(list.indexOf(s.charAt(i)));

			}
		} 
		
		else {
			return false;
		}

		result = true;
		return result;

	}

}
