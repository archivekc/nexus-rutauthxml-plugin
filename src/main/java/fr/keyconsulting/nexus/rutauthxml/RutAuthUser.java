package fr.keyconsulting.nexus.rutauthxml;

import java.util.HashSet;
import java.util.Set;

import org.sonatype.security.usermanagement.RoleIdentifier;
import org.sonatype.security.usermanagement.User;
import org.sonatype.security.usermanagement.UserStatus;

/**
 * Simple User for RUT auth
 * 
 * @author Sylvain Veyrié - Key Consulting
 * 
 */
public class RutAuthUser implements User {

	private String id;

	private String source = RutAuthXMLUserManager.ID;

	private UserStatus status = UserStatus.active;

	private Set<RoleIdentifier> roles = new HashSet<>();

	public RutAuthUser() {
		this(null);
	}

	public RutAuthUser(String id) {
		this.id = id;
	}

	@Override
	public String getUserId() {
		return id;
	}

	@Override
	public void setUserId(String userId) {
		this.id = userId;
	}

	@Override
	@Deprecated
	public String getName() {
		return id;
	}

	@Override
	@Deprecated
	public void setName(String name) {
		// do nothing

	}

	@Override
	public String getFirstName() {
		return "";
	}

	@Override
	public void setFirstName(String firstName) {
		// do noting
	}

	@Override
	public String getLastName() {
		return id;
	}

	@Override
	public void setLastName(String lastName) {
		// do noting

	}

	@Override
	public String getEmailAddress() {
		return id.contains("@") ? id : id + "@nodns.com";
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		// do nothing
	}

	@Override
	public String getSource() {
		return source;
	}

	@Override
	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public void addRole(RoleIdentifier roleIdentifier) {
		roles.add(roleIdentifier);
	}

	@Override
	public boolean removeRole(RoleIdentifier roleIdentifier) {
		roles.remove(roleIdentifier);
		return true;
	}

	@Override
	public void addAllRoles(Set<RoleIdentifier> roleIdentifiers) {
		roles.addAll(roleIdentifiers);
	}

	@Override
	public Set<RoleIdentifier> getRoles() {
		return roles;
	}

	@Override
	public void setRoles(Set<RoleIdentifier> roles) {
		this.roles = roles;
	}

	@Override
	public UserStatus getStatus() {
		return status;
	}

	@Override
	public void setStatus(UserStatus status) {
		this.status = status;
	}

	@Override
	@Deprecated
	public boolean isReadOnly() {
		return false;
	}

	@Override
	@Deprecated
	public void setReadOnly(boolean readOnly) {
		// do nothing
	}

}
