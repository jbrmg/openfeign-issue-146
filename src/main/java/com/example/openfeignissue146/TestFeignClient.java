package com.example.openfeignissue146;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "issue-146", url = "localhost:12345")
public interface TestFeignClient {

    @GetMapping(path = "/page")
    void performRequest(Pageable page);

}
