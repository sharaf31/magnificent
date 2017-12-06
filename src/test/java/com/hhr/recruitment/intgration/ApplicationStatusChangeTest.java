package com.hhr.recruitment.intgration;

/**
 * Created by sharaf on 12/6/17.
 */


import java.io.IOException;
import org.apache.http.client.fluent.*;
import org.apache.http.entity.ContentType;

public class ApplicationStatusChangeTest
{
    public static void main(String[] args) {
        sendRequest();
    }

    private static void sendRequest() {

        // Application change Status  (POST )

        try {

            // Create request
            Content content = Request.Post("http://localhost:7070/application/SE/sharaf.navas2@gmail.com")

                    // Add headers
                    .addHeader("Content-Type", "application/json")

                    // Add body
                    .bodyString("{\"nextStatus\": \"INVITED\"}", ContentType.APPLICATION_JSON)

                    // Fetch request and return content
                    .execute().returnContent();

            // Print content
            System.out.println(content);
        }
        catch (IOException e) { System.out.println(e); }
    }
}


