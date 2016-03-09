package it.polito.tdp.alien;

public class Word {

	private String alienWord;
	private String translation;
	
	public Word(String alienWord2, String translation2) {
		// TODO Auto-generated constructor stub
		this.alienWord=alienWord2;
		this.setTranslation(translation2);
	}

	public String compare(String alienWord){
		if(this.alienWord.compareTo(alienWord)==0)
			return alienWord;
		return null;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
	
	public String getAlienWord() {
		return alienWord;
	}
}
