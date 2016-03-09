package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary a=new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	   String parola1=null;
    	   String parola2=null;
    	   String testo;
    	   testo=txtWord.getText();
    	   StringTokenizer st=new StringTokenizer(testo," ");
    	   parola1=st.nextToken().trim().toLowerCase();
    	   try{
    		   parola2=st.nextToken().trim().toLowerCase();
    	   } catch(Error r){
    		   
    	   }
    	   if(parola1!=null && parola2!=null){
    		   a.addWord(parola1, parola2);
    		   this.setTxtResult(parola1+" "+parola2);
    	   }
    	   if(parola1!=null && parola2==null){
    		   this.setTxtResult(a.translateWord(parola1));
    	   }
    		   
    }
    
    public void setTxtResult(String a){
    	 txtResult.setText(a);
    }
    
    @FXML
    void doReset(ActionEvent event) {

    }
    
}
