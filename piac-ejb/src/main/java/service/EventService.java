package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entites.Event;
import iservices.IEventService;
@LocalBean
@Stateless
public class EventService implements IEventService {
	@PersistenceContext(name="piac-ejb")
	private EntityManager em ;
	@Override
	public List<Event> getEvents() {
		return em.createQuery("select e.name from Event where idEvent = 1 " ).getResultList();
	}
	@Override
	public void AddEvent(Event ev) {
	em.persist(ev);
	}
	@Override
	public void EditEvent(Event ev) {
		em.merge(ev);		
		
	}
	@Override
	public Event ShowEvent(int id) {
return em.find(Event.class, id);
	}
	@Override
	public void DeletEvent(Event ev) {
		em.merge(ev);
		em.remove(ev);		
	}

}
