
package info.novatec.inspectit.cmr.usermanagement;





/**
 * Storage for a single permission.
 * @author Joshua Hartmann
 *  extends HibernateDaoSupport 
 */
public class Permission {

	/**
	 * The id of the permission, used to identify which functionality it covers, must be unique.
	 */
	private long id;
	/**
	 * A short title for the permission.
	 */
	private String title;
	/**
	 * A more detailed description for the functionality the permission covers.
	 */
	private String description;
	/**
	 * Default constructor for Permission.
	 */
	
	public Permission() {
		
	}
	
	/**
	 * The constructor for a permission.
	 * @param id The id of the permission.
	 * @param title The short title of the permission.
	 * @param description The more detailed description of the permission.
	 */
	public Permission(long id, String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.id = id;
	}
	/**
	 * Gets {@link #id}.
	 *   
	 * @return {@link #id}  
	 */
	public long getId() {
		return id;
	}
	/**
	 * Gets {@link #title}.
	 *   
	 * @return {@link #title}  
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * Gets {@link #description}.
	 *   
	 * @return {@link #description}  
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Permission [id=" + id + ", title=" + title + ", description=" + description + "]";
	}
	
	/**  
	 * Sets {@link #title}.  
	 *   
	 * @param title  
	 *            New value for {@link #title}  
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**  
	 * Sets {@link #id}.  
	 *   
	 * @param id  
	 *            New value for {@link #id}  
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**  
	 * Sets {@link #description}.  
	 *   
	 * @param description  
	 *            New value for {@link #description}  
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
