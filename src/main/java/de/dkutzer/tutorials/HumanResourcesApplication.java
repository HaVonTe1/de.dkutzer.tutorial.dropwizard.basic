package de.dkutzer.tutorials;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import de.dkutzer.tutorials.resources.PersonResource;

public class HumanResourcesApplication extends Application<HumanResourcesConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HumanResourcesApplication().run(args);
    }

    @Override
    public String getName() {
        return "HumanResources";
    }

    @Override
    public void initialize(final Bootstrap<HumanResourcesConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HumanResourcesConfiguration configuration,
                    final Environment environment) {

        environment.jersey().register(new PersonResource());
    }

}
