package org.api.ai.webhook.helloworld;

public class WebhookAge {

    private final String amount;
    private final String unit;

    public WebhookAge(String amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public String getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }
}
