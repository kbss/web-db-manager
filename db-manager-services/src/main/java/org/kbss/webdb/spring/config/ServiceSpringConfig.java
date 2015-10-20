package org.kbss.webdb.spring.config;

import org.kbss.webdb.configuration.StorageConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Serhii Krivtsov
 */
@Configuration
@Import({StorageConfiguration.class})
@ComponentScan(basePackages = {"org.kbss.webdb"}, scopeResolver = org.springframework.context.annotation.Jsr330ScopeMetadataResolver.class)
@ImportResource(value = {"classpath:spring-security.xml"})
public class ServiceSpringConfig {

}
