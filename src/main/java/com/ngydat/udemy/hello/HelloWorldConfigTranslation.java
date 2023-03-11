package com.ngydat.udemy.hello;

import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("hello.world.translation")
public interface HelloWorldConfigTranslation {

    @NotBlank
    String getDe();

    @NotBlank
    String getEn();
}
