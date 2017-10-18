package service;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entites.Announcement;
import iservices.IAnnouncementService;

@LocalBean
@Stateless
public class AnnouncementService implements IAnnouncementService {
	@PersistenceContext(name="piac-ejb")
	private EntityManager em ;
	
	@Override
	public Collection<Announcement> getAnnouncements() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT a FROM Announcement a");
		return (Collection<Announcement>) query.getResultList();
	}

	@Override
	public void AddAnnouncement(Announcement a) {
		// TODO Auto-generated method stub
		em.persist(a);
	}

	@Override
	public void EditAnnouncement(Announcement a) {
		// TODO Auto-generated method stub
		em.merge(a);
	}

	@Override
	public Announcement ShowAnnouncement(int id) {
		// TODO Auto-generated method stub
		return em.find(Announcement.class, id);
	}

	@Override
	public void DeleteAnnouncement(Announcement a) {
		// TODO Auto-generated method stub
		em.remove(em.merge(a));
	}

	@Override
	public Collection<Announcement> getAnnouncementsNotConfirmed() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT a FROM Announcement a where confirmed=0");
		return (Collection<Announcement>) query.getResultList();
	}

}
