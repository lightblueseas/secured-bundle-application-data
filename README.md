# secured-bundle-application-data

The project holds backend data for simple user management.

## License

The source code comes under the liberal MIT License, making secured-bundle-application-data great for all types of applications with users or accounts.

# Build status
[![Build Status](https://travis-ci.org/lightblueseas/secured-bundle-application-data.svg?branch=master)](https://travis-ci.org/lightblueseas/secured-bundle-application-data)

## Maven Central

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/secured-bundle-application-data/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/secured-bundle-application-data)

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~secured-bundle-application-data~~~) for latest snapshots and releases.

Add the following maven dependencies to your project `pom.xml` if you want to import the core functionality:

You can first define the version properties:

	<properties>
			...
		<!-- secured-bundle-application-data version -->
		<secured-bundle-application-data.version>3.11.0</secured-bundle-application-data.version>
		<secured-bundle-application-init.version>${secured-bundle-application-data.version}</secured-bundle-application-init.version>
		<secured-bundle-application-rest-client.version>${secured-bundle-application-data.version}</secured-bundle-application-rest-client.version>
		<secured-bundle-application-rest-web.version>${secured-bundle-application-data.version}</secured-bundle-application-rest-web.version>
			...
	</properties>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of secured-bundle-application-init:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>secured-bundle-application-init</artifactId>
				<version>${secured-bundle-application-init.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of secured-bundle-application-rest-client:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>secured-bundle-application-rest-client</artifactId>
				<version>${secured-bundle-application-rest-client.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of secured-bundle-application-rest-web:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>secured-bundle-application-rest-web</artifactId>
				<version>${secured-bundle-application-rest-web.version}</version>
			</dependency>
			...
		</dependencies>

## Want to Help and improve it? ###

The source code for secured-bundle-application-data are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [lightblueseas/secured-bundle-application-data/fork](https://github.com/lightblueseas/secured-bundle-application-data/fork)

To share your changes, [submit a pull request](https://github.com/lightblueseas/secured-bundle-application-data/pull/new/master).

Don't forget to add new units tests on your changes.

## Contacting the Developer

Do not hesitate to contact the secured-bundle-application-data developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/lightblueseas/secured-bundle-application-data/issues).

## Note

No animals were harmed in the making of this library.

# Donate

If you like this library, please consider a donation through 
<a href="https://flattr.com/submit/auto?fid=r7vp62&url=https%3A%2F%2Fgithub.com%2Flightblueseas%2Fsecured-bundle-application-data" target="_blank">
<img src="http://button.flattr.com/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0">
</a>