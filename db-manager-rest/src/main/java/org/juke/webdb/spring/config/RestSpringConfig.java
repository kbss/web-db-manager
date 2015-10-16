package org.juke.webdb.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Serhii Krivtsov
 */
@Configuration
@Import({ServiceSpringConfig.class})
@ComponentScan(basePackages = {"org.juke.webdb"}, scopeResolver = org.springframework.context.annotation.Jsr330ScopeMetadataResolver.class)
public class RestSpringConfig {
    // TODO: add configuration
}
