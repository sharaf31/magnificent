package com.hhr.recruitment.intgration;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;

/**
 * Created by sharaf on 12/6/17.
 */
public class CreateOfferTest {
    public static void main(String[] args) {
        sendRequest();
    }

    private static void sendRequest() {

        // Offer PUT (PUT )
        // Put 1st offer SSE = Senior Software Engineer
        try {

            // Create request
            Content content = Request.Put("http://localhost:7070/offer")

                    // Add headers
                    .addHeader("CONTENT-TYPE", "application/json")

                    // Add body
                    .bodyString("{\"jobTitle\": \"SSE\",\"startDate\": \"2017-12-01\"," +
                            "\"noOfApplication\": null}", ContentType.APPLICATION_JSON)

                    // Fetch request and return content
                    .execute().returnContent();

            // Print content
            System.out.println(content);

            // Put 2nd offer SE = Software Engineer
            Content content2 = Request.Put("http://localhost:7070/offer")
                    .addHeader("CONTENT-TYPE", "application/json")

                    // Add body
                    .bodyString("{\"jobTitle\": \"SE\",\"startDate\": \"2017-12-01\"," +
                            "\"noOfApplication\": null}", ContentType.APPLICATION_JSON)

                    // Fetch request and return content
                    .execute().returnContent();

            // Print content
            System.out.println(content2);

            // Put 3rd offer JSE = Junior Software Engineer
            Content content3 = Request.Put("http://localhost:7070/offer")
                    .addHeader("CONTENT-TYPE", "application/json")

                    // Add body
                    .bodyString("{\"jobTitle\": \"JSE\",\"startDate\": \"2017-12-01\"," +
                            "\"noOfApplication\": null}", ContentType.APPLICATION_JSON)

                    // Fetch request and return content
                    .execute().returnContent();

            // Print content
            System.out.println(content3);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

