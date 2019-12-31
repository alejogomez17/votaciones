package com.desarrollo.votaciones.main;

import com.desarrollo.votaciones.api.EleccionController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {PersistenceJPAConfig.class,EleccionController.class})
public class AdminhorasApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(AdminhorasApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(AdminhorasApplication.class);
    }
}
