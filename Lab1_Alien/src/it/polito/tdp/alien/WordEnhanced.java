package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced extends Word {

	private List<String> translations=new LinkedList<String>();
	
	public WordEnhanced(String alienWord2, String translation2) {
		super(alienWord2, translation2);
		// TODO Auto-generated constructor stub
		translations.add(translation2);
	}

	public void addWord(String t){
		translations.add(t);
	}
	
	public String toString(){
		String tot="";
		for(String s: translations){
			tot+=s+"\n";
		}
		return tot;
	}
}
