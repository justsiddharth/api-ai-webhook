package org.api.ai.webhook.helloworld;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/helloworld")
public class HelloWorldController {

    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    public
    @ResponseBody
    WebhookResponse webhook(@RequestBody String request) {
        System.out.println(request);
        return calculateAnimalAge(request);
    }

    private WebhookResponse calculateAnimalAge(String request) {
        ObjectMapper mapper = new ObjectMapper();
        WebhookResponse response = new WebhookResponse("", "");
        try {
            Map<String, Object> requestMap = mapper.readValue(request, new TypeReference<Map<String, Object>>() {
            });
            Map<String, Object> results = (Map<String, Object>) requestMap.get("result");
            Map<String, Object> parameters = (Map<String, Object>) results.get("parameters");
            int age = (int) ((Map<String, Object>) parameters.get("age")).get("amount");
            String animal = (String) parameters.get("animal");
            response = animalAgeCalculator(age, animal);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private WebhookResponse animalAgeCalculator(int age, String animal) {
        String res = "";
        switch (animal) {
            case "cat":
                res = lifeSpanCalculator(3.64, age);
                break;
            case "dog":
                res = lifeSpanCalculator(3.2, age);
                break;
            case "bird":
                res = lifeSpanCalculator(4.21, age);
                break;
            case "rat":
                res = lifeSpanCalculator(26.67, age);
                break;
            default:
                res = "I cant figure out your " + animal + "age. But I think you are Young !";
                break;
        }
        String text = "Your age in " + animal + " years is " + res + " years.";
        return new WebhookResponse(text, text);
    }

    private String lifeSpanCalculator(double avgAge, int age) {
        return Double.toString(avgAge * age);
    }
}
