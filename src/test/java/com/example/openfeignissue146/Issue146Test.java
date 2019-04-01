package com.example.openfeignissue146;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Issue146Test {

    @Autowired
    private TestFeignClient feignClient;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(12345);

    @Test
    public void testSortRequest() {
        wireMockRule.stubFor(get(urlPathEqualTo("/page"))
                .withQueryParam("sort", equalTo("property,desc"))
                .willReturn(aResponse().withStatus(200)));

        feignClient.performRequest(PageRequest.of(1, 10, Sort.by(Sort.Order.desc("property"))));
    }

}
