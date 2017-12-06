package com.hhr.recruitment;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hhr.recruitment.model.Offer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Created by sharaf on 12/6/17.
 */
@RunWith(SpringRunner.class)
@RestClientTest(OfferServiceClient.class)
public class OfferServiceClientTest {

    @Autowired
    private OfferServiceClient client;

    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        String detailsString =
                objectMapper.writeValueAsString(new Offer("SSE",new Date()));

        this.server.expect(requestTo("/SSE"))
                .andRespond(withSuccess(detailsString, MediaType.APPLICATION_JSON));
    }

    @Test
    public void whenCallingGetOffer_thenClientMakesCorrectCall()
            throws Exception {

        Offer offer = this.client.getOffer("SSE");

        assertThat(offer.getJobTitle()).isEqualTo("SSE");
        //assertThat(offer.getName()).isEqualTo("John Smith");
    }
}
