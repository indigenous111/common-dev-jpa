package in.indigenous.common.jpa;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import in.indigenous.common.jpa.config.PMConfig;
import in.indigenous.common.jpa.config.QAConfig;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "in.indigenous.common.jpa" })
@Import(value= {PMConfig.class, QAConfig.class})
public class Application {
	
}
