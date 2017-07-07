package org.api.ai.webhook.helloworld;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/helloworld")
public class HelloWorldController {

    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    public @ResponseBody WebhookResponse webhook(@RequestBody String request) {
        System.out.println(request);
        return new WebhookResponse("Hello! " + request, "Text " + request);
    }
}
