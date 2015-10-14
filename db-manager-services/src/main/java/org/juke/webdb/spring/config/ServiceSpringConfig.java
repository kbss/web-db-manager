package org.juke.webdb.spring.config;

import org.juke.webdb.configuration.StorageConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @author Serhii Krivtsov
 */
@Configuration
@Import({StorageConfiguration.class})
@ImportResource(value = {"classpath:spring-security.xml"})
public class ServiceSpringConfig {
    // TODO: add Configuration
}
