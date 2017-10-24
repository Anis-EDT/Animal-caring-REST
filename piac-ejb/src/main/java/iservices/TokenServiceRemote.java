package iservices;

import javax.ejb.Local;

import entites.Token;
import entites.User;

@Local
public interface TokenServiceRemote {
	public void setToken(String tokenValue, User user);
	public User getUser(String tokenValue);
	public Token find(String tokenValue);
	public Token find(User u);
	public void save(Token token);
}
