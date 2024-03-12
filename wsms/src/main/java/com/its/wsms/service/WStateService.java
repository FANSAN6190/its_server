package com.its.wsms.service;

import com.its.wsms.models.WState;
import com.its.wsms.repository.WStateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WStateService {
    private final WStateRepository wStateRepository;
    public char getWhistleStatus(String wid){
        return wStateRepository.findById(wid)
                .map(WState::getStatus)
                .orElseThrow(() -> new RuntimeException("Entity not found with id " + wid));
    }

    public void incrementUpvoteCount(String whistleId) {
        WState wState = wStateRepository.findById(whistleId)
                .orElseThrow(() -> new RuntimeException("Entity not found with id " + whistleId));
        wState.setUpvote_count(wState.getUpvote_count() + 1);
        wStateRepository.save(wState);
    }
}
