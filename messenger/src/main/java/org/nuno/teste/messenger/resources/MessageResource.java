package org.nuno.teste.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.nuno.teste.messenger.Service.MessageService;
import org.nuno.teste.messenger.model.Message;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();
	
	@GET
	public List<Message> getMessages(@QueryParam("year")int year,
									 @QueryParam("start")int start,
									 @QueryParam("size")int size){		
		if(year > 0){
			return	messageService.getAllMessagesForYear(year);
			}
		if(start >= 0 && size >= 0){
			return	messageService.getAllMessagesPaginated(start, size);
			}
		
		return messageService.getAllMessages();
	}
	
	@POST
	public Message addMessages(Message message){		
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	
	@DELETE
	@Path("/{messageId}")
	public void updateMessage(@PathParam("messageId")long id){	
	 messageService.removeMessage(id);
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long messageId){	
		return messageService.getMessage(messageId);
	}
}
