package de.alpharogroup.bundle.management.service.locator;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.alpharogroup.address.book.service.api.AddressesService;
import de.alpharogroup.address.book.service.api.CountriesService;
import de.alpharogroup.address.book.service.api.FederalstatesService;
import de.alpharogroup.address.book.service.api.ZipcodesService;
import de.alpharogroup.db.resource.bundles.service.api.BaseNamesService;
import de.alpharogroup.db.resource.bundles.service.api.BundleApplicationsService;
import de.alpharogroup.db.resource.bundles.service.api.BundleNamesService;
import de.alpharogroup.db.resource.bundles.service.api.LanguageLocalesService;
import de.alpharogroup.db.resource.bundles.service.api.LanguagesService;
import de.alpharogroup.db.resource.bundles.service.api.PropertiesKeysService;
import de.alpharogroup.db.resource.bundles.service.api.ResourcebundlesService;
import de.alpharogroup.resource.system.service.api.ResourcesService;
import de.alpharogroup.user.management.service.api.ContactmethodsService;
import de.alpharogroup.user.management.service.api.RecommendationsService;
import de.alpharogroup.user.management.service.api.RobinsonsService;
import de.alpharogroup.user.management.service.api.RuleViolationsService;
import de.alpharogroup.user.management.service.api.UserCreditsService;
import de.alpharogroup.user.management.service.api.UserDatasService;
import de.alpharogroup.user.management.service.api.UsersManagementService;
import de.alpharogroup.user.management.service.api.UsersService;
import de.alpharogroup.user.service.api.PermissionsService;
import de.alpharogroup.user.service.api.RelationPermissionsService;
import de.alpharogroup.user.service.api.ResetPasswordsService;
import de.alpharogroup.user.service.api.RolesService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The class {@link ServiceLocatorImpl}.
 *
 * @author Asterios Raptis
 */
@Getter
@Setter
@NoArgsConstructor
@Service("serviceLocator")
public class ServiceLocatorImpl implements Serializable, ServiceLocator
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The RecommendationsService service. */
	@Autowired
	private RecommendationsService recommendationsService;

	/** The addresses business service. */
	@Autowired
	private AddressesService addressesService;

	/** The RelationPermissions business service. */
	@Autowired
	private RelationPermissionsService relationPermissionsService;

	/** The contactmethods business service. */
	@Autowired
	private ContactmethodsService contactmethodsService;

	/** The countries business service. */
	@Autowired
	private CountriesService countriesService;

	/** The federalstates business service. */
	@Autowired
	private FederalstatesService federalstatesService;

	/** The images business service. */
	@Autowired
	private ResourcesService resourcesService;

	/** The permission business service. */
	@Autowired
	private PermissionsService permissionsService;

	/** The reset passwords business service. */
	@Autowired
	private ResetPasswordsService resetPasswordsService;

	/** The Resourcebundles business service. */
	@Autowired
	private ResourcebundlesService resourcebundlesService;

	/** The roles business service. */
	@Autowired
	private RolesService rolesService;

	/** The UserCredits business service. */
	@Autowired
	private UserCreditsService userCreditsService;

	/** The users data business service. */
	@Autowired
	private UserDatasService userDatasService;

	/** The user management business service. */
	@Autowired
	private UsersManagementService userManagementService;

	/** The users business service. */
	@Autowired
	private UsersService usersService;

	/** The zipcodes business service. */
	@Autowired
	private ZipcodesService zipcodesService;

	/** The RuleViolations business service. */
	@Autowired
	private RuleViolationsService ruleViolationsService;

	/** The Robinsons business service. */
	@Autowired
	private RobinsonsService robinsonsService;

	/** The base names service. */
	@Autowired
	private BaseNamesService baseNamesService;

	/** The bundle applications service. */
	@Autowired
	private BundleApplicationsService bundleApplicationsService;

	/** The language locales service. */
	@Autowired
	private LanguageLocalesService languageLocalesService;

	/** The languages service. */
	@Autowired
	private LanguagesService languagesService;

	/** The properties keys service. */
	@Autowired
	private PropertiesKeysService propertiesKeysService;

	/** The bundle names service. */
	@Autowired
	private BundleNamesService bundleNamesService;

}