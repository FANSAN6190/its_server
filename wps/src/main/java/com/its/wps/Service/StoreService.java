package com.its.wps.Service;

import com.its.wps.Repository.WhistleDataRepository;
import com.its.wps.model.Whistle;
import com.its.wps.model.WhistleData;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class StoreService {
    private final WhistleDataRepository repository;
    @SneakyThrows
    public void storeWhistleData(Whistle whistle){
        Whistle whistleObj = Whistle.builder()
                .category(whistle.getCategory())
                .subcategory(whistle.getSubcategory())
                .latitude(whistle.getLatitude())
                .longitude(whistle.getLongitude())
                .user_rating(whistle.getUser_rating())
                .timestamp(whistle.getTimestamp())
                .build();

        WhistleData whistleData = new WhistleData();
        whistleData.setWhistle_id(whistle.getWid());
        whistleData.setUser_id("some_user1");
        whistleData.setWhistle_object(whistleObj);
        whistleData.setBs64_image(whistle.getBs64_image());
        whistleData.setTimestamp(whistle.getTimestamp());

        log.info("Whistle :: {} Stored in Database", whistle.getWid());
        repository.save(whistleData);
    }
    public List<WhistleData> findAllWhistleData(){
        return repository.findAll();
    }
}
