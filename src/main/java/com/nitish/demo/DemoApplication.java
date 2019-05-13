package com.nitish.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication
public class DemoApplication {


    private static MyComponent component;

    /* autowiring a static member is a bad design */
    @Autowired
    private void setComponent(MyComponent component){
        this.component = component;
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println(component.getPropertiesValue());
	}


    @Component
    class MyComponent {
        private final Logger log = LoggerFactory.getLogger(MyComponent.class);
        @Value("${app.subdomain}")
        private String propertiesValue;

        public String getPropertiesValue(){
            return this.propertiesValue;
        }

        @Autowired
        public MyComponent(ApplicationArguments args) {
            boolean enable = args.containsOption("enable");
            if (enable)
                log.info("## > You are enabled!");
            List<String> _args = args.getNonOptionArgs();
            log.info("## > extra args ...");
            if (!_args.isEmpty())
                _args.forEach(file -> log.info(file));
        }
    }

}
