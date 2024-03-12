package com.its.wsms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WhistleResponse {
    private String whistleId;
    private String category;
    private String subcategory;
    private String latitude;
    private String longitude;
    private String userRating;
    private String timestamp;
}
