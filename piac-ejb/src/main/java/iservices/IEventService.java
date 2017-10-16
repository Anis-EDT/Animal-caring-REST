package iservices;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;

import entites.Event;

@Local
public interface IEventService {
public  List<Event> getEvents() ;
public void AddEvent (Event ev) ;
public void EditEvent(Event ev);
public Event ShowEvent(int id);
public void DeletEvent(Event ev);

}
