package com.mahery.backendjavasmarttix.controller;

import com.mahery.backendjavasmarttix.model.Payement;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/stripe/payement")
@AllArgsConstructor
public class PayementController {
    @PostMapping
    public String createPayement (@RequestBody Payement pay ) throws StripeException {
        Stripe.apiKey = "sk_test_51PJbJVFCA4Yw8qTq8YMSAMpQhdqPq5Ll7mtnidXBRkaf0q4hByCN9F5Jldmu93DYu1qLDfAMPZTAkYrs10jn95HH00zClN7rCc";
        String YOUR_DOMAIN = "http://localhost:4242";
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(YOUR_DOMAIN + "?success=true")
                        .setCancelUrl(YOUR_DOMAIN + "?canceled=true")
                        .addLineItem(
                                SessionCreateParams.LineItem.builder()
                                        .setQuantity(1L)
                                        .setPrice(pay.getId())
                                        .build())
                        .build();
        Session session = Session.create(params);
        return "ok " + session.getUrl();
    }
}
