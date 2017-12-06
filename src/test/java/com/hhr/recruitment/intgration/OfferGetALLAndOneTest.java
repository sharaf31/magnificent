package com.hhr.recruitment.intgration;

/**
 * Created by sharaf on 12/6/17.
 */

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class OfferGetALLAndOneTest {
    public static void main(String[] args) {
        sendAllRequest();
        sendRequest();
    }

    private static void sendAllRequest() {

        // Offer get ALL (GET )

        try {

            // Create request
            Content content = Request.Get("http://localhost:7070/offer")
                    // Fetch request and return content
                    .execute().returnContent();

            // Print content
            System.out.println(content);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void sendRequest(){
        // Offer get ALL (GET )

        try {

            // Create request
            Content content = Request.Get("http://localhost:7070/offer/SE")
                    // Fetch request and return content
                    .execute().returnContent();

            // Print content
            System.out.println(content);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

