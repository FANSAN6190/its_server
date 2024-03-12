package com.its.wps.Controller;

import com.its.wps.Service.WhistleService;
import com.its.wps.dto.WhistleRequest;
import com.its.wps.dto.WhistleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/whistle")
@RequiredArgsConstructor
public class WhistleController {
    private final WhistleService whistleService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createWhistle(@RequestBody WhistleRequest whistleRequest){
        whistleService.createWhistle(whistleRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<WhistleResponse> getAllWhistles(){
        return whistleService.getAllWhistles();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<WhistleResponse>> getAllWhistles(@PathVariable("userId") String userId){

        return ResponseEntity.ok(whistleService.findAllWhistleForGivenUser(userId));
    }
}
