package com.its.wsms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WhistleRequest {
    private String userId;
    private String category;
    private String subcategory;
    private String latitude;
    private String longitude;
    private String binaryImage;
    private String userRating;
    private String timestamp;
}
