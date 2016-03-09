package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	private List<Word> dizionario=new LinkedList<Word>();
	
	public void addWord(String alienWord, String translation){
		String risultato;
		String parola;
		String traduzione;
		boolean flag=false;
		for(Word w: dizionario){
			risultato=w.compare(alienWord);
			if(risultato!=null){
				flag=true;
			}
			if(flag==true){
				//aggiorno traduzione
				dizionario.remove(w);
				dizionario.add(new Word(alienWord, translation));
				break;
			}
		}
		if(flag==false) {
			dizionario.add(new Word(alienWord, translation));
		}
	}
	public String translateWord(String alienWord){
		String risultato;
		for(Word w: dizionario){
			risultato=w.compare(alienWord);
			if(risultato!=null)
				return w.getTranslation();
		}
		return null;
	}
}
