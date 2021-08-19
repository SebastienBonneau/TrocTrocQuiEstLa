package fr.eni.jee.projet.bll;

import java.util.List;

public class BLLException extends Exception {

	private List<String> messages;
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


