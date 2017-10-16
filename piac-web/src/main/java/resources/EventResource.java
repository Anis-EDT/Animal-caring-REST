package resources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import entites.Event;
import iservices.IEventService;
import service.EventService;

@RequestScoped
@Path(value = "event")
public class EventResource {
	@Inject
	IEventService es = new EventService(); 
	
	
	
	
	 @POST
	 @Consumes(MediaType.APPLICATION_XML)
	 public Response createRdv(Event ev){
		 
		es.AddEvent(ev);
		return Response.status(Status.CREATED).build();
		
		
	  
 }
	
	
@GET
@Path(value = "showall")
@Produces(MediaType.TEXT_PLAIN)
public String showevent(){
		/*if (es.ShowEvent(1)!=null)
			return Response.status(404).build();
		else
	 return Response.status(200).entity(es.ShowEvent(1)).build();
	*/    //return Response.status(Status.ACCEPTED);
return es.ShowEvent(1).toString();
	
}
@Path("/{id}")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getRDVById(@PathParam(value="id") int id){
	 Event r = es.ShowEvent(id);
	 if(r!=null)
		 return Response.ok(r).build();
	 else return Response.status(404).build();
	 
}

@Path("/{id}")
@DELETE
@Produces(MediaType.APPLICATION_JSON)
public Response deleteById(@PathParam(value="id") int id){
	 es.DeletEvent(es.ShowEvent(id));
	 
	
 return Response.status(200).build();
	 
}
@Path("/{id}/{name}")
@GET
@Produces(MediaType.APPLICATION_JSON)
public Response ajouttest(@PathParam(value="id") int id , @PathParam(value="name") String name){
	Event ev = new Event(id,name);
	es.AddEvent(ev);
	 return Response.status(200).build();
}
}
