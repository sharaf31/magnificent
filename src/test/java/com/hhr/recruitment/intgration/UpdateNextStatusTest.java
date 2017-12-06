package com.hhr.recruitment.intgration;


import java.io.IOException;
import org.apache.http.client.fluent.*;
import org.apache.http.entity.ContentType;
/**
 * Created by sharaf on 12/6/17.
 */





public class UpdateNextStatusTest
{
    public static void main(String[] args) {
        sendRequest();
    }

    private static void sendRequest() {

        // Application change Status  (POST )

        try {

            // Create request
            Content content = Request.Post("http://localhost:7070/application/sharaf.navas@gmail.com/SE")
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

