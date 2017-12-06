package com.hhr.recruitment.intgration;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

/**
 * Created by sharaf on 12/6/17.
 */


public class GetAllApplicationTest {
    public static void main(String[] args) {
        sendRequest();
    }

    private static void sendRequest() {

        // Application GET All (GET )

        try {

            // Create request
            Content content = Request.Get("http://localhost:7070/application/")

                    // Add headers
                    .addHeader("Content-Type", "application/json")

                    // Fetch request and return content
                    .execute().returnContent();

            // Print content
            System.out.println(content);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

