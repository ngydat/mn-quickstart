package com.ngydat.udemy.hello;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("/hello")
public class HelloWorldController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    //Field based dependency injection
    /*@Inject
    private HelloWorldService service*/;

    //Constructor based dependency injection
    private final MyService service;
    private final String helloFromConfig;
    private final HelloWorldConfigTranslation translationConfig;

    public HelloWorldController(MyService service,
                                @Property(name = "hello.world.message") String helloFromConfig,
                                HelloWorldConfigTranslation translationConfig) {
        this.service = service;
        this.helloFromConfig = helloFromConfig;
        this.translationConfig = translationConfig;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String helloWorld() {
        LOG.debug("Called the hello World API");
        return service.helloFromService();
    }

    @Get(uri = "/config", produces = MediaType.TEXT_PLAIN)
    public String helloConfig() {
        LOG.debug("Return Hello From Config Message : {}", helloFromConfig);
        return helloFromConfig;
    }

    @Get(uri = "/translation", produces = MediaType.APPLICATION_JSON)
    public HelloWorldConfigTranslation helloTranslation() {
        return translationConfig;
    }
}
