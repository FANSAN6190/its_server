package com.its.wps.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WhistleResponse {
    private String wid;
    private String category;
    private String subcategory;
    private String latitude;
    private String longitude;
    private String bs64_image;
    private String user_rating;
    private String timestamp;
}
