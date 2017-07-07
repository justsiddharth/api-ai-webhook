package org.api.ai.webhook.helloworld;

import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Basic integration tests for service demo application.
 *
 * @author Siddharth Jain
 */
@ContextConfiguration(classes = {HelloWorldApplication.class},
        initializers = {ConfigFileApplicationContextInitializer.class})
@RunWith(SpringRunner.class)
public class HelloWorldApplicationIntegrationTest {

    @Value("${server.port}")
    private int port;

    @Value("${management.port}")
    private int management;

    @Test
    public void testInfo() throws Exception {
        ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.management + "/info", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

}
