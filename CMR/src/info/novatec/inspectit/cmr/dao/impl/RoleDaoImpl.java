package info.novatec.inspectit.cmr.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import info.novatec.inspectit.cmr.dao.RoleDao;
import info.novatec.inspectit.communication.data.cmr.Role;

/**
 * The default implementation of the {@link RoleDao} interface by using the
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
public class RoleDaoImpl extends AbstractJpaDao<Role> implements RoleDao {
	/**
	 * Default constructor.
	 */
	public RoleDaoImpl() {
		super(Role.class);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(Role role) {
		super.delete(role);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteAll(List<Role> roles) {
		for (Role role : roles) {
			delete(role);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Role> loadAll() {
		return getEntityManager().createNamedQuery(Role.FIND_ALL, Role.class).getResultList();
	}

	/**
	 * {@inheritDoc}
	 */
	public Role findByTitle(String title) {
		TypedQuery<Role> query = getEntityManager().createNamedQuery(Role.FIND_BY_TITLE, Role.class);		
		query.setParameter("title", title);		
		List<Role> results = query.getResultList();		
		return results.get(0);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Role findByID(long id) {
		TypedQuery<Role> query = getEntityManager().createNamedQuery(Role.FIND_BY_ID, Role.class);		
		query.setParameter("id", id);		
		List<Role> results = query.getResultList();		
		return results.get(0);
	}

	/**
	 * {@inheritDoc}
	 */
	public void saveOrUpdate(Role role) {
		if (role.getId() == null) {
			super.create(role);
		} else {
			super.update(role);
		}
	}
}
