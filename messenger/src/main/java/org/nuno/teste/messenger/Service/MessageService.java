package org.nuno.teste.messenger.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.nuno.teste.messenger.database.DatabaseClass;
import org.nuno.teste.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService(){
		
		messages.put(1L, new Message(1,"mensagem 1","Nuno"));
		messages.put(2L, new Message(2,"mensagem 2","Nuno"));
	}
	
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());	
	}
	
	public List<Message> getAllMessagesForYear(int year){
		
		List<Message> messageForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message  message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				messageForYear.add(message);	
			}			
		}
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size){
		
		ArrayList<Message> lista = new ArrayList<Message>(messages.values());
		if(start+size > lista.size()) return new ArrayList<Message>();
		return lista.subList(start, start+size);				
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(),message);
		return message;	
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0) {return null;}
		messages.put(message.getId(),message);
		return message;
	}

	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
	
}
