package resources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createevent(Event ev) {

		es.AddEvent(ev);
		return Response.status(Status.CREATED).build();

	}

	@GET
	@Path(value = "showall")
	@Produces(MediaType.TEXT_PLAIN)
	public Response showevents() {

		return Response.status(200).entity(es.getEvents()).build();
		// return Response.status(Status.ACCEPTED);

	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response geteventbyid(@PathParam(value = "id") int id) {
		Event r = es.ShowEvent(id);
		if (r != null)
			return Response.ok(r).build();
		else
			return Response.status(404).build();

	}

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam(value = "id") int id) {
		es.DeletEvent(es.ShowEvent(id));

		return Response.status(200).build();

	}

	@Path("/{id}")
	@PUT
	public Response updateeventById(@PathParam(value = "id") int id, Event r) {
		r.setName("edit");
		es.EditEvent(r);
		return Response.ok().build();
	}
}
