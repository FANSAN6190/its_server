package com.its.wsms.service;

import com.its.wsms.models.User;
import com.its.wsms.models.UserWhistleList;
import com.its.wsms.models.WState;
import com.its.wsms.repository.UserRepository;
import com.its.wsms.repository.WStateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WStateService {
    private final WStateRepository wStateRepository;
    private final UserRepository userRepository;
    public char getWhistleStatus(String whistleId){
        return wStateRepository.findById(whistleId)
                .map(WState::getStatus)
                .orElseThrow(() -> new RuntimeException("Entity not found with id " + whistleId));
    }

    public void incrementUpvoteCount(String whistleId) {
        WState wState = wStateRepository.findById(whistleId)
                .orElseThrow(() -> new RuntimeException("Entity not found with id " + whistleId));
        wState.setUpvote_count(wState.getUpvote_count() + 1);
        wStateRepository.save(wState);
    }


    public UserWhistleList findAllWhistleForGivenUser(String userId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));
        return null;
    }

//    public User findAllWhistleForGivenUser(String userId) {
//        return userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));
//    }
}
