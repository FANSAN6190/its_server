package com.its.wps.Service;

import com.its.wps.Repository.WhistleRepository;
import com.its.wps.dto.WhistleRequest;
import com.its.wps.dto.WhistleResponse;
import com.its.wps.model.Whistle;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WhistleService {

    private final WhistleRepository whistleRepository;

    public void createWhistle(WhistleRequest whistleRequest){
        Whistle whistle = Whistle.builder()
                .category(whistleRequest.getCategory())
                .subcategory(whistleRequest.getSubcategory())
                .latitude(whistleRequest.getLatitude())
                .longitude(whistleRequest.getLongitude())
                .bs64_image(whistleRequest.getBs64_image())
                .user_rating(whistleRequest.getUser_rating())
                .timestamp(whistleRequest.getTimestamp())
                .build();
        whistleRepository.save(whistle);
        log.info("Whistle :: {} is Registered", whistle.getWid());
    }

    public List<WhistleResponse> getAllWhistles(){
        List<Whistle> whistles = whistleRepository.findAll();
        return whistles.stream().map(this::mapToWhistleResponse).toList();
    }

    private WhistleResponse mapToWhistleResponse(Whistle whistle) {
        return WhistleResponse.builder()
                .wid(whistle.getWid())
                .category(whistle.getCategory())
                .subcategory(whistle.getSubcategory())
                .latitude(whistle.getLatitude())
                .longitude(whistle.getLongitude())
                .bs64_image(whistle.getBs64_image())
                .user_rating(whistle.getUser_rating())
                .timestamp(whistle.getTimestamp())
                .build();
    }
}
