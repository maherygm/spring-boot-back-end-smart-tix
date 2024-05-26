package com.mahery.backendjavasmarttix.controller;


import com.mahery.backendjavasmarttix.model.Produitss;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.ProductCreateParams;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stripe/product")
@AllArgsConstructor
public class StripeCreateProducts {
    @PostMapping
    public Produitss create (@RequestBody Produitss prod ) throws StripeException {

        Stripe.apiKey = "sk_test_51PJbJVFCA4Yw8qTq8YMSAMpQhdqPq5Ll7mtnidXBRkaf0q4hByCN9F5Jldmu93DYu1qLDfAMPZTAkYrs10jn95HH00zClN7rCc";
        ProductCreateParams params =
                ProductCreateParams.builder()
                        .setName("Starter Setup")
                        .setDefaultPriceData(
                                ProductCreateParams.DefaultPriceData.builder()
                                        .setUnitAmount(prod.getUnitAmount())
                                        .setCurrency("mga")
                                        .build()
                        )
                        .addExpand("default_price")
                        .build();
        Product product = Product.create(params);
        Price defaultPrice = product.getDefaultPriceObject();

        System.out.println("Default Price ID: " + defaultPrice.getId());
        System.out.println("Currency: " + defaultPrice.getCurrency());
        System.out.println("Unit Amount: " + defaultPrice.getUnitAmount());

        prod.setId(product.getId());
        prod.setUnitAmount(defaultPrice.getUnitAmount());
        prod.setPriceID(defaultPrice.getId());
        return prod;
    }
}
