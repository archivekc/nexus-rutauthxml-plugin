package fr.keyconsulting.nexus.rutauthxml;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.inject.Typed;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.shiro.authc.credential.PasswordService;
import org.sonatype.configuration.validation.InvalidConfigurationException;
import org.sonatype.inject.Description;
import org.sonatype.nexus.rutauth.internal.RutAuthRealm;
import org.sonatype.security.SecuritySystem;
import org.sonatype.security.realms.tools.ConfigurationManager;
import org.sonatype.security.usermanagement.RoleIdentifier;
import org.sonatype.security.usermanagement.User;
import org.sonatype.security.usermanagement.UserManager;
import org.sonatype.security.usermanagement.UserNotFoundException;
import org.sonatype.security.usermanagement.UserSearchCriteria;
import org.sonatype.security.usermanagement.xml.SecurityXmlUserManager;

/**
 * User manager for RUT users, backed by SecurityXMLUserManager _only_ on read.
 * 
 * @author Sylvain Veyrié - Key Consulting
 * 
 */
@Singleton
@Named(RutAuthXMLUserManager.ID)
@Typed(UserManager.class)
@Description("RUT Auth XML User Manager")
public class RutAuthXMLUserManager extends SecurityXmlUserManager {

	public static final String ID = "rutauth-realm-xml";

	@Inject
	public RutAuthXMLUserManager(ConfigurationManager configuration,
			SecuritySystem securitySystem, PasswordService passwordService) {
		super(configuration, securitySystem, passwordService);
	}

	@Override
	public String getSource() {
		return ID;
	}

	@Override
	public User getUser(String userId) {
		try {
			return super.getUser(userId);
		} catch (UserNotFoundException e) {
			return new RutAuthUser(userId);
		}
	}

	@Override
	public Set<RoleIdentifier> getUsersRoles(final String userId,
			final String source) {
		try {
			return super.getUsersRoles(userId, source);
		} catch (UserNotFoundException e) {
			return new HashSet<>();
		}
	}

	@Override
	public Set<User> searchUsers(final UserSearchCriteria criteria) {
		final Set<User> users = super.searchUsers(criteria);
		if (users.size() == 0 && criteria.getUserId() != null) {
			users.add(new RutAuthUser(criteria.getUserId()));
		}
		return users;
	}

	@Override
	public User updateUser(final User user)
			throws InvalidConfigurationException {

		// do nothing, managed by real SecurityXmlUserManager
		return user;
	}

	@Override
	public void deleteUser(final String userId) {
		// do nothing, managed by real SecurityXmlUserManager
	}

	@Override
	public void setUsersRoles(final String userId, final String userSource,
			final Set<RoleIdentifier> roleIdentifiers) {
		// do nothing, managed by real SecurityXmlUserManager
	}

	@Override
	public String getAuthenticationRealmName() {
		return RutAuthRealm.ID;
	}

}
