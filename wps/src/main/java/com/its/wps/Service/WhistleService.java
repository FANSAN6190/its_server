package com.its.wps.Service;

import com.its.wps.Repository.WhistleDataRepository;
import com.its.wps.dto.WhistleRequest;
import com.its.wps.dto.WhistleResponse;
import com.its.wps.models.Whistle;
import com.its.wps.models.WhistleData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class WhistleService {
    private final WhistleDataRepository whistleDataRepository;
    public void createWhistle(WhistleRequest whistleRequest){
        Whistle whistleObj = Whistle.builder()
                .category(whistleRequest.getCategory())
                .subcategory(whistleRequest.getSubcategory())
                .latitude(whistleRequest.getLatitude())
                .longitude(whistleRequest.getLongitude())
                .userRating(whistleRequest.getUserRating())
                .build();

        WhistleData whistleData = WhistleData.builder()
                .userId(whistleRequest.getUserId())
                .whistleObj(whistleObj)
                .binaryImage(whistleRequest.getBinaryImage())
                .timestamp(whistleRequest.getTimestamp())
                .build();
        whistleDataRepository.save(whistleData);
    }

    public List<WhistleResponse> getAllWhistles(){
        List<WhistleData> whistles = whistleDataRepository.findAll();
        return whistles.stream().map(this::mapToWhistleResponse).toList();
    }

    private WhistleResponse mapToWhistleResponse(WhistleData whistleData) {
        JSONObject whistleObj = new JSONObject(whistleData.getWhistleObj());
        return WhistleResponse.builder()
                .whistleId(whistleData.getWhistleId())

                .category(whistleObj.getString("category"))
                .subcategory(whistleObj.getString("subcategory"))
                .latitude(String.valueOf(whistleObj.getDouble("latitude")))
                .longitude(String.valueOf(whistleObj.getDouble("longitude")))
                .userRating(String.valueOf(whistleObj.getDouble("userRating")))

                .timestamp(whistleData.getTimestamp())
                .build();
    }

}
