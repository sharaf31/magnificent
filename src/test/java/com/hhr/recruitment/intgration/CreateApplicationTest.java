package com.hhr.recruitment.intgration;

/**
 * Created by sharaf on 12/6/17.
 */

import java.io.IOException;
import org.apache.http.client.fluent.*;
import org.apache.http.entity.ContentType;

public class CreateApplicationTest
{
    public static void main(String[] args) {
        sendRequest();
    }

    private static void sendRequest() {

        // Application PUT (PUT )

        try {

            // Create request
            Content content = Request.Put("http://localhost:7070/application")

                    // Add headers
                    .addHeader("Content-Type", "application/json")

                    // Add body
                    .bodyString("{\"relatedOffer\": \"SE\",\"email\": \"" +
                            "sharaf.navas@gmail.com\",\"resume\": \"sample 1\"}", ContentType.APPLICATION_JSON)

                    // Fetch request and return content
                    .execute().returnContent();

            // Print content
            System.out.println(content);
        }
        catch (IOException e) { System.out.println(e); }
    }
}


