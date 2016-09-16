package org.asraf.djava.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.asraf.djava.messenger.model.Message;
import org.asraf.djava.messenger.service.MessageService;

import com.asraf.djava.messenger.exception.DataNotFoundException;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService =new MessageService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessages() {
		return "Hello Asraf";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/msg")
	public List<Message> getMessage(){
		return messageService.getAllMessage();		
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/allMsg")
	public List<Message> getAllMsg(){
		return messageService.getInMemoryMsg();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/msg")
	public Message addMsg(Message message){
		
		return messageService.addMessage(message);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/singleMsg/{msgId}")
	public Message getSingleMessage(@PathParam("msgId") Long msgId){
		
		return  messageService.getSingleMsg(msgId);
	
	}
}
