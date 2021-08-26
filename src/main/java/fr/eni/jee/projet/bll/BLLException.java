package fr.eni.jee.projet.bll;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception {
	
	// essai de listing des différentes erreurs de l'utilisateur
	private List<String> messages = new ArrayList<>();
	   public BLLException(String message) {
	        super(message);
	        messages.add(message);
	    }
	   
	   public List<String> getMessages() {
		   return messages;
	   }
	   
	   public boolean IsEmpty() {
		   
		return messages.size() == 0;
	   }
}


