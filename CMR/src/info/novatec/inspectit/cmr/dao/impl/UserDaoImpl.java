package info.novatec.inspectit.cmr.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import info.novatec.inspectit.cmr.dao.UserDao;
import info.novatec.inspectit.communication.data.cmr.User;

/**
 * The default implementation of the {@link UserDao} interface by using the
 * {@link HibernateDaoSupport} from Spring.
 * <p>
 * Delegates many calls to the {@link HibernateTemplate} returned by the {@link HibernateDaoSupport}
 * class.
 * 
 * @author Joshua Hartmann
 * @author Andreas Herzog
 * 
 */
@Repository
public class UserDaoImpl extends AbstractJpaDao<User> implements UserDao {	
	/**
	 * Default constructor.
	 */
	public UserDaoImpl() {
		super(User.class);
	}	
	
	/**
	 * {@inheritDoc}
	 */
	public void delete(User user) {
		super.delete(user);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteAll(List<User> users) {
		for (User user : users) {
			delete(user);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<User> loadAll() {
		return getEntityManager().createNamedQuery(User.FIND_ALL, User.class).getResultList();
	}
	
	/**
	 * {@inheritDoc}
	 */
	public User findByEmail(String email) {
		TypedQuery<User> query = getEntityManager().createNamedQuery(User.FIND_BY_EMAIL, User.class);		
		query.setParameter("email", email);		
		List<User> results = query.getResultList();		
		return results.get(0);
	}	
	
	/**
	 * {@inheritDoc}
	 */
	public void saveOrUpdate(User user) {
		if (user.getId() == null) {
			super.create(user);
		} else {
			super.update(user);
		}
	}	
	
	/**
	 * {@inheritDoc}
	 */
	public List<User> findByRole(long roleId) {
		TypedQuery<User> query = getEntityManager().createNamedQuery(User.FIND_BY_EMAIL, User.class);
		query.setParameter("roleId", roleId);
		List<User> results = query.getResultList();
		return results;
	}
}
