package org.api.ai.webhook.helloworld;

public class WebhookRequest {

    private final WebhookAge age;

    private final String animal;

    public WebhookRequest(WebhookAge age, String animal) {
        this.age = age;
        this.animal = animal;
    }

    public WebhookAge getAge() {
        return age;
    }

    public String getAnimal() {
        return animal;
    }
}
