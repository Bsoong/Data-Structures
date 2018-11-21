package hw6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Anagrams {
	final Integer[] primes = new Integer[] {2, 3 , 5 , 7, 11 , 13 , 17 , 19 , 23 , 29 , 31 , 37 , 41 , 43 , 47 , 53 , 59 , 61 ,67 , 71 , 73 , 79 , 83 , 89 , 97 , 101}; ;
	Map<Character,Integer> letterTable = new Hashtable<Character, Integer>();
	Map<Long,ArrayList<String>> anagramTable = new Hashtable<Long, ArrayList<String>>();
	
	public Anagrams(){
		this.buildLetterTable();
		anagramTable =  new Hashtable<Long, ArrayList<String>>();
	}
	public void processFile(String s) throws IOException {
		FileInputStream fstream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while((strLine = br.readLine()) != null ) {
				this.addWord(strLine);
			}
		br.close();
		}
	public void buildLetterTable() {
		int i;
		char curr;
			for(i = 0, curr = 'a'; curr <= 'z'; curr++, i++) {
				letterTable.put(curr, primes[i]);
			}
	}
	public Long myHashCode(String s) {
		if(s == null || s == "") {
			throw new NullPointerException();
		} else {
			Long value = (long) 1;
			for(int i = 0; i < s.length(); i++) {
				Integer temp = letterTable.get(s.charAt(i));
				value = value*temp;
			}
			return value;
		}
	}
	public void addWord(String s) {
		Long temp = myHashCode(s);
		ArrayList<String> list = anagramTable.get(temp);
		if(anagramTable.containsKey(temp)) {
			list.add(s);
			anagramTable.put(temp, list);
		} else {
			ArrayList<String> temp3  = new ArrayList<String>();
			temp3.add(s);
			anagramTable.put(temp, temp3);
		}
	
	}
	public ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {
		int maxval = 0;
		ArrayList<Map.Entry<Long, ArrayList<String>>> maxKeys = new ArrayList<Map.Entry<Long, ArrayList<String>>>();
		Set<Long> keys = anagramTable.keySet();
		for(Long key: keys) {
			ArrayList<String> list = anagramTable.get(key);
			int comp = list.size();
			if(comp > maxval) {
				maxval = comp;
				maxKeys.clear();
				maxKeys.add(new AbstractMap.SimpleEntry<Long, ArrayList<String>>(key, list));
			}
		}
		return maxKeys;
	}

	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		final long startTime = System.nanoTime();
		try {
		a. processFile ("words_alpha.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		ArrayList <Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
		final long estimatedTime = System.nanoTime()-startTime;
		final double seconds = ((double) estimatedTime /1000000000);
		System.out.println (" Time: "+ seconds );
		System.out.println(" Max Key: " + maxEntries.get(0).getKey());
		System.out.println (" List of max anagrams: "+ maxEntries.get(0).getValue());
		System.out.println(" Length of list of Max Anagrams: " + maxEntries.get(0).getValue().size());
		
		}
	}
	
		