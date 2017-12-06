package com.hhr.recruitment.intgration;


import java.io.IOException;
import org.apache.http.client.fluent.*;


/**
 * Created by sharaf on 12/6/17.
 */
public class GetAllApplicationForOfferTest
{
    public static void main(String[] args) {
        sendRequest();
    }

    private static void sendRequest() {

        // Application GET ID (GET )

        try {

            // Create request
            Content content = Request.Get("http://localhost:7070/application/SE")

                    // Add headers
                    .addHeader("Content-Type", "application/json")

                    // Fetch request and return content
                    .execute().returnContent();

            // Print content
            System.out.println(content);
        }
        catch (IOException e) { System.out.println(e); }
    }
}


