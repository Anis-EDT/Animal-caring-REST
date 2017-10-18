package iservices;

import java.util.Collection;

import javax.ejb.Local;

import entites.Announcement;

@Local
public interface IAnnouncementService {

	public  Collection<Announcement> getAnnouncements() ;
	public  Collection<Announcement> getAnnouncementsNotConfirmed() ;
	public void AddAnnouncement (Announcement a) ;
	public void EditAnnouncement(Announcement a);
	public Announcement ShowAnnouncement(int id);
	public void DeleteAnnouncement(Announcement a);
}
