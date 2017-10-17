package resources;

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
import javax.ws.rs.core.Response.Status;

import entites.Event;
import entites.EventParticipation;
import iservices.IEventService;
import iservices.IParticipationservice;
import service.EventService;
import service.ParticipationService;

@RequestScoped
@Path(value = "participation")
public class EventParticipationResource {
	@Inject
	IParticipationservice ep = new ParticipationService();
	@Inject
	IEventService es = new EventService();
	Event e;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createevent(EventParticipation ev) {

		if (ep.checkparticipation(ev.getUser(), ev.getEvent())
				&&
		(es.ShowEvent(ev.getEvent().getIdEvent()).getNbParticipation())>
		(es.ShowEvent(ev.getEvent().getIdEvent()).getNbParticipated())
				
				
				
				) {
			e = new Event();
			e=es.ShowEvent(ev.getEvent().getIdEvent());
			e.setNbParticipated(es.ShowEvent(ev.getEvent().getIdEvent()).getNbParticipated()+1);
			ev.setEvent(e);
			//ev.getEvent().setNbParticipated(es.ShowEvent(ev.getEvent().getIdEvent()).getNbParticipated() + 1);
			es.EditEvent(e);
			ep.AddParticipation(ev);

			return Response.status(Status.CREATED).build();
		} else
			return Response.status(400).build();

	}

	@GET
	@Path(value = "showall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response showparticipation() {

		return Response.status(200).entity(ep.getParticipation()).build();
		// return Response.status(Status.ACCEPTED);

	}

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteParticipation(@PathParam(value = "id") int id) {
		ep.DeletParticipation(ep.ShowParticipation(id));

		return Response.status(200).build();

	}

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getparticipationbyid(@PathParam(value = "id") int id) {
		EventParticipation r = ep.ShowParticipation(id);
		if (r != null)
			return Response.ok(r).build();
		else
			return Response.status(404).build();

	}

}
