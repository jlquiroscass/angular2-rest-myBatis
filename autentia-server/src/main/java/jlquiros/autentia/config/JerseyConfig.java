package jlquiros.autentia.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import jlquiros.autentia.controllers.CourseController;
import jlquiros.autentia.controllers.ProfessorController;
import jlquiros.autentia.controllers.UploadController;

@Component
@ApplicationPath("/")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CourseController.class);
        register(ProfessorController.class);
        register(UploadController.class);
    }
}