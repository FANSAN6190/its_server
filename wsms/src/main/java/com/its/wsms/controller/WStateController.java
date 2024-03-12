package com.its.wsms.controller;

import com.its.wsms.models.WState;
import com.its.wsms.service.WStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wstate")
@RequiredArgsConstructor
public class WStateController {
    private final WStateService wStateService;
    @GetMapping("/status/{wid}")
    @ResponseStatus(HttpStatus.OK)

    public ResponseEntity<?> getWhistleStatus(@PathVariable String wid){
        try {
            char status = wStateService.getWhistleStatus(wid);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Entity not found with id " + wid, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/upvote/{whistleId}")
    public ResponseEntity<?> upvote(@PathVariable String whistleId) {
        try {
            wStateService.incrementUpvoteCount(whistleId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Entity not found with id " + whistleId, HttpStatus.NOT_FOUND);
        }
    }
}
