nexus-rutauthxml-plugin
=======================

Nexus plugin adding security.xml backend to rutauth plugin

It allows to save user role mappings to security.xml, even if the user does not exist in this file.

It is simplistic: the user id, name and email are all derived from the remote token used by the rutauth plugin.
