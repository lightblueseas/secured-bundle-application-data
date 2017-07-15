package de.alpharogroup.bundle.management.springconfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Deprecated
public class DataSourceBean
{
	public static DataSourceBeanBuilder DEFAULT_H2_BUILDER = DataSourceBean
		.builder()
		.driverClassName("org.h2.Driver")
		.username("sa")
		.password("")
		.build().toBuilder();

	private String driverClassName;

	private String url;

	private String username;

	private String password;
}
