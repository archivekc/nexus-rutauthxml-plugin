package fr.keyconsulting.nexus.rutauthxml;

import javax.inject.Inject;
import javax.inject.Named;

import org.sonatype.inject.EagerSingleton;
import org.sonatype.nexus.plugin.PluginIdentity;

import org.jetbrains.annotations.NonNls;

/**
 * Plugin to add XML user mapping to RUT users.
 * 
 * @since 2.7
 * @author Sylvain Veyrié - Key Consulting
 */
@Named
@EagerSingleton
public class RutAuthXMLPlugin extends PluginIdentity {
	/**
	 * Prefix for ID-like things.
	 */
	@NonNls
	public static final String ID_PREFIX = "rutauthxml";

	/**
	 * Expected groupId for plugin artifact.
	 */
	@NonNls
	public static final String GROUP_ID = "fr.keyconsulting.nexus";

	/**
	 * Expected artifactId for plugin artifact.
	 */
	@NonNls
	public static final String ARTIFACT_ID = "nexus-" + ID_PREFIX + "-plugin";

	@Inject
	public RutAuthXMLPlugin() throws Exception {
		super(GROUP_ID, ARTIFACT_ID);
	}

}