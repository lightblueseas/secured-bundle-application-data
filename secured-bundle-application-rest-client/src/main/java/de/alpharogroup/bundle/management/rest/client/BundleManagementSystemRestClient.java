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

import de.alpharogroup.address.book.rest.api.AddressesResource;
import de.alpharogroup.address.book.rest.api.CountriesResource;
import de.alpharogroup.address.book.rest.api.FederalstatesResource;
import de.alpharogroup.address.book.rest.api.ZipcodesResource;
import de.alpharogroup.cxf.rest.client.AbstractRestClient;
import de.alpharogroup.db.resource.bundles.rest.api.ResourcebundlesResource;
import de.alpharogroup.resource.system.rest.api.ResourcesResource;
import de.alpharogroup.user.management.rest.api.AuthenticationsResource;
import de.alpharogroup.user.management.rest.api.ContactmethodsResource;
import de.alpharogroup.user.management.rest.api.RecommendationsResource;
import de.alpharogroup.user.management.rest.api.RobinsonsResource;
import de.alpharogroup.user.management.rest.api.RuleViolationsResource;
import de.alpharogroup.user.management.rest.api.UserCreditsResource;
import de.alpharogroup.user.management.rest.api.UserDatasResource;
import de.alpharogroup.user.management.rest.api.UserManagementResource;
import de.alpharogroup.user.management.rest.api.UsersResource;
import de.alpharogroup.user.rest.api.PermissionsResource;
import de.alpharogroup.user.rest.api.RelationPermissionsResource;
import de.alpharogroup.user.rest.api.ResetPasswordsResource;
import de.alpharogroup.user.rest.api.RolesResource;
import lombok.Getter;

/**
 * The class {@link BundleManagementSystemRestClient} is a rest client for the
 * bundle-management-system that are persists in the database.
 */
@Getter
public class BundleManagementSystemRestClient extends AbstractRestClient
{

	/**
	 * The {@link AddressesResource}.
	 */
	private final AddressesResource addressesResource;

	/**
	 * The {@link CountriesResource}.
	 */
	private final CountriesResource countriesResource;

	/**
	 * The {@link FederalstatesResource}.
	 */
	private final FederalstatesResource federalstatesResource;

	/**
	 * The {@link ZipcodesResource}.
	 */
	private final ZipcodesResource zipcodesResource;

	/**
	 * The {@link ResourcesResource}.
	 */
	private final ResourcesResource resourcesResource;

	/**
	 * The {@link AuthenticationsResource}.
	 */
	private final AuthenticationsResource authenticationsResource;

	/**
	 * The {@link ContactmethodsResource}.
	 */
	private final ContactmethodsResource contactmethodsResource;

	/**
	 * The {@link PermissionsResource}.
	 */
	private final PermissionsResource permissionsResource;

	/**
	 * The {@link RecommendationsResource}.
	 */
	private final RecommendationsResource recommendationsResource;

	/**
	 * The {@link RelationPermissionsResource}.
	 */
	private final RelationPermissionsResource relationPermissionsResource;

	/**
	 * The {@link ResetPasswordsResource}.
	 */
	private final ResetPasswordsResource resetPasswordsResource;

	/**
	 * The {@link RobinsonsResource}.
	 */
	private final RobinsonsResource robinsonsResource;

	/**
	 * The {@link RolesResource}.
	 */
	private final RolesResource rolesResource;

	/**
	 * The {@link RuleViolationsResource}.
	 */
	private final RuleViolationsResource ruleViolationsResource;

	/**
	 * The {@link UserCreditsResource}.
	 */
	private final UserCreditsResource userCreditsResource;

	/**
	 * The {@link UserDatasResource}.
	 */
	private final UserDatasResource userDatasResource;

	/**
	 * The {@link UserDatasResource}.
	 */
	private final UserManagementResource userManagementResource;

	/**
	 * The {@link UsersResource}.
	 */
	private final UsersResource usersResource;

	/**
	 * The {@link ResourcebundlesResource}.
	 */
	private final ResourcebundlesResource resourcebundlesResource;

	/**
	 * Instantiates a new {@link BundleManagementSystemRestClient} with the default base url.
	 */
	public BundleManagementSystemRestClient()
	{
		this(DEFAULT_BASE_HTTP_URL);
	}

	/**
	 * Instantiates a new {@link BundleManagementSystemRestClient}.
	 *
	 * @param baseUrl
	 *            the base url
	 */
	public BundleManagementSystemRestClient(final String baseUrl)
	{
		super(baseUrl);
		authenticationsResource = newResource(AuthenticationsResource.class);
		contactmethodsResource = newResource(ContactmethodsResource.class);
		permissionsResource = newResource(PermissionsResource.class);
		recommendationsResource = newResource(RecommendationsResource.class);
		relationPermissionsResource = newResource(RelationPermissionsResource.class);
		resetPasswordsResource = newResource(ResetPasswordsResource.class);
		robinsonsResource = newResource(RobinsonsResource.class);
		rolesResource = newResource(RolesResource.class);
		ruleViolationsResource = newResource(RuleViolationsResource.class);
		userCreditsResource = newResource(UserCreditsResource.class);
		userDatasResource = newResource(UserDatasResource.class);
		userManagementResource = newResource(UserManagementResource.class);
		usersResource = newResource(UsersResource.class);

		addressesResource = newResource(AddressesResource.class);
		countriesResource = newResource(CountriesResource.class);
		federalstatesResource = newResource(FederalstatesResource.class);
		zipcodesResource = newResource(ZipcodesResource.class);

		resourcesResource = newResource(ResourcesResource.class);

		resourcebundlesResource = newResource(ResourcebundlesResource.class);
	}

}
