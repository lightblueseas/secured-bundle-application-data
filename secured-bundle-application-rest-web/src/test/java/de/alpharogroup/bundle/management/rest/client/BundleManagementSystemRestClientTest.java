/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *  *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *  *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.bundle.management.rest.client;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.testng.annotations.BeforeMethod;

import de.alpharogroup.cxf.rest.client.AbstractRestClient;
import de.alpharogroup.cxf.rest.client.WebClientExtensions;
import de.alpharogroup.file.search.PathFinder;
import de.alpharogroup.user.management.rest.api.AuthenticationsResource;
import de.alpharogroup.user.management.rest.api.UsersResource;
import de.alpharogroup.user.rest.api.PermissionsResource;
import de.alpharogroup.user.rest.api.RolesResource;

public class BundleManagementSystemRestClientTest
{

	private TLSClientParameters tlsClientParameters;

	private BundleManagementSystemRestClient restClient;

	private AuthenticationsResource authenticationsResource;

	private UsersResource usersResource;

	private PermissionsResource permissionsResource;

	private RolesResource rolesResource;

	@BeforeMethod
	public void setUpMethod() throws Exception
	{
		if (restClient == null)
		{
			restClient = new BundleManagementSystemRestClient(
				AbstractRestClient.DEFAULT_BASE_HTTPS_URL);
			tlsClientParameters = WebClientExtensions.newTLSClientParameters(
				PathFinder.getSrcTestResourcesDir(), "keystore.ks", "JKS", "wicket");
			authenticationsResource = restClient.getAuthenticationsResource();

			usersResource = restClient.getUsersResource();
			permissionsResource = restClient.getPermissionsResource();
			rolesResource = restClient.getRolesResource();
			// set client params with key and trust managers. The keystore is
			// the same as jetty
			WebClientExtensions.setTLSClientParameters(authenticationsResource,
				tlsClientParameters);
			WebClientExtensions.setTLSClientParameters(usersResource, tlsClientParameters);
			WebClientExtensions.setTLSClientParameters(permissionsResource, tlsClientParameters);
			WebClientExtensions.setTLSClientParameters(rolesResource, tlsClientParameters);
		}
	}
}
