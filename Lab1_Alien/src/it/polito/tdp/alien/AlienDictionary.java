package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	private List<WordEnhanced> dizionario=new LinkedList<WordEnhanced>();
	
	public void addWord(String alienWord, String translation){
		String risultato;
		boolean flag=false;
		for(Word w: dizionario){
			risultato=w.compare(alienWord);
			if(risultato!=null){
				flag=true;
			}
			if(flag==true){
				/*dizionario.remove(w);
				dizionario.add(new Word(alienWord, translation));
				break;*/ //questo succedeva quando dovevo aggiornare la traduzione
				if(w.getAlienWord().compareTo(alienWord)==0) // senza questo controllo aggiungeva una traduzione per la parola rotto sia che esso fosse come alien word che come traduzione: es ROTTO SOTTO e MORTO ROTTO, se io volessi aggiungere una traduzione per rotto e quindi avessi scritto ROTTO BLU avrebbe aggiungo BLU anche ai significati di MORTO solo perche' morto ha nelle altre traduzioni rotto
				((WordEnhanced) w).addWord(translation);
			}
		}
		if(flag==false) {
			dizionario.add(new WordEnhanced(alienWord, translation));
		}
	}
	public String translateWord(String alienWord){
		String risultato;
		for(WordEnhanced w: dizionario){
			risultato=w.compare(alienWord);
			if(risultato!=null)
				return w.toString();
		}
		return null;
	}
	
	public String ricomponiAlienWord(String a, String b){
		String risultato="inizializzata";
		for(WordEnhanced w: dizionario){
			if(w.getAlienWord().contains(a) && w.getAlienWord().contains(b)){
				risultato=w.getAlienWord();
			}
		}
		return risultato;
	}
	 
    public boolean controllaPuntiInterrogativi(String a){
    	boolean b=true;
    	int indice;
    	if(a.contains("?")){
    		indice=a.indexOf('?');
    		String sottoParola=a.substring(indice+1); //devo metterlo il +1?
    		if(sottoParola.contains("?")){
    			b=false;
    		}
    	}
    	return b;
    }
	
	public String toString(){
		String tot="";
		for(Word w: dizionario){
			if(w instanceof WordEnhanced){
				tot+=w.getAlienWord()+" "+w.toString();
			} else {
			tot+=w.getAlienWord()+" "+w.getTranslation()+"\n";
			}
		}
		return tot;
	}
	
	public void reset(){
		dizionario.clear();
	}
}
