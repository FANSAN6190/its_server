package com.its.wps.Service;

import com.its.wps.Repository.WhistleDataRepository;
import com.its.wps.model.Whistle;
import com.its.wps.model.WhistleData;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class StoreService {
    private final WhistleDataRepository repository;
    @SneakyThrows
    public void storeWhistleData(Whistle whistle){

        JSONObject whistleObj = new JSONObject();
                whistleObj.put("whistle_id", whistle.getWid());
                whistleObj.put("category", whistle.getCategory());
                whistleObj.put("subcategory", whistle.getSubcategory());
                whistleObj.put("Latitude", whistle.getLatitude());
                whistleObj.put("Longitude", whistle.getLongitude());
                whistleObj.put("userRating", whistle.getUser_rating());
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
