package de.alpharogroup.bundle.management.springconfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import de.alpharogroup.db.resource.bundles.service.api.BundleApplicationsService;

public class LoadJPASpringConfig {

   
   public static void main(String[] args) {
	   ApplicationContext ctx = new AnnotationConfigApplicationContext(PersistenceJPAConfig.class);
	   BundleApplicationsService bundleApplicationsService = ctx.getBean(BundleApplicationsService.class);
	   bundleApplicationsService.findAll();

	}
}