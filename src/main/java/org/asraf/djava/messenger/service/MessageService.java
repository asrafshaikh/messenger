package org.asraf.djava.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.asraf.djava.messenger.database.DatabaseClass;
import org.asraf.djava.messenger.model.Message;

import com.asraf.djava.messenger.exception.DataNotFoundException;

public class MessageService {

	private Map<Long, Message> messages = DatabaseClass.getMessage();

	public MessageService() {
		messages.put(1L, new Message(1L, "Hi I am learning jersy rest", "Asraf"));
		messages.put(2L, new Message(2L, "Hi i am new to jersy rest", "Asraf"));
	}

	public List<Message> getInMemoryMsg() {

		return new ArrayList<Message>(messages.values());
	}

	public Message getSingleMsg(Long id){
		Message msg= messages.get(id);
		

		if(msg==null){
			throw new DataNotFoundException("Message with id "+id+" not found");
		}
		return msg;
	}
	
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
	
	public List<Message> getAllMessage() {

		Message m1 = new Message(1L, "Hello World", "Asraf");
		Message m2 = new Message(1L, "Hello RestFull Service ", "Jersy");

		List<Message> messageList = new ArrayList<Message>();
		messageList.add(m1);
		messageList.add(m2);

		return messageList;
	}

}
