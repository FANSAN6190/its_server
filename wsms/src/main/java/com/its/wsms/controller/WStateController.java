package com.its.wsms.controller;

import com.its.wsms.models.User;
import com.its.wsms.models.UserWhistleList;
import com.its.wsms.models.WState;
import com.its.wsms.models.Whistle;
import com.its.wsms.service.WStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wstate")
@RequiredArgsConstructor
public class WStateController {
    private final WStateService wStateService;
    @GetMapping("/status/{whistleId}")
    @ResponseStatus(HttpStatus.OK)

    public ResponseEntity<?> getWhistleStatus(@PathVariable String whistleId){
        try {
            char status = wStateService.getWhistleStatus(whistleId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Entity not found with id " + whistleId, HttpStatus.NOT_FOUND);
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

    @GetMapping("/listwhistle/{userId}")
    public ResponseEntity<UserWhistleList> findAllWhistleForGivenUser(@PathVariable("userId") String userId){
        return ResponseEntity.ok(wStateService.findAllWhistleForGivenUser(userId));
    }

//    @GetMapping("/listwhistle/{userId}")
//    public User findAllWhistleForGivenUser(@PathVariable("userId") String userId){
//        return wStateService.findAllWhistleForGivenUser(userId);
//    }

}
