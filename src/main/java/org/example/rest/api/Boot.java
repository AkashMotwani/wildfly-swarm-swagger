package org.example.rest.api;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.config.Mail;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.logging.LoggingFraction;
import org.wildfly.swarm.swagger.SwaggerArchive;


public class Boot {

    public static void main(String[] args) throws Exception {

        Swarm swarm = new Swarm();

        SwaggerArchive archive = ShrinkWrap.create(SwaggerArchive.class, "swagger-ui-app.war");
        JAXRSArchive deployment = archive.as(JAXRSArchive.class).addPackage(Boot.class.getPackage());

        archive.setResourcePackages("org.example.rest.api");

        deployment.addAllDependencies();
        swarm
                .fraction(LoggingFraction.createDefaultLoggingFraction())
                .start()
                .deploy(deployment);
    }
}
