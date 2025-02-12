package com.micronaut.sandbox

import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class HelloControllerSpec extends Specification {

    @Inject
    @Client("/")
    HttpClient client;

    void 'test it works'() {
        expect:
        client.toBlocking().retrieve('/hello') == 'Hello World'
    }

}
