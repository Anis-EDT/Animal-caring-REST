package service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entites.Event;
import entites.User;
import iservices.IEventService;
import iservices.IUserService;
@LocalBean
@Stateless
public class UserService implements IUserService {
	@PersistenceContext(name="piac-ejb")
	private EntityManager em ;


	@Override
	public boolean login(User u){
		System.out.println("Login from service : "+u);
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email = :email "
				+ "AND u.pwd = :password");
		query.setParameter("email", u.getEmail());
		query.setParameter("password", u.getPwd());
		int resultCount = query.getResultList().size();
		System.out.println("Found "+resultCount+" Result(s) ");
		if(resultCount != 1){
			return false;
		}
		return true;
		
	}

	@Override
	public void signup(User us) {
		em.persist(us);
		
	}

	@Override
	public void EditProfile(User us) {
		em.merge(us);		
		
	}

	@Override
	public User ShowProfile(int id) {
		return em.find(User.class, id);

	}
	@Override
	public User findUser(User user) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.email = :email OR u.phoneNumber = :phone");
		query.setParameter("email", user.getEmail());
		query.setParameter("phone", user.getPhoneNumber());
		User userFromDB = (User) query.getSingleResult();
		return userFromDB;
	}

}
