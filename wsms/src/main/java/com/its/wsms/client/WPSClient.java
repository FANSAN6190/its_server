package com.its.wsms.client;

import com.its.wsms.models.Whistle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "wps-service", url = "${application.config.wps-url}")
public interface WPSClient {
    @GetMapping("/user/{userId}")
    List<Whistle> findAllWhistleForGivenUser(@PathVariable("userId") String userId);
}
