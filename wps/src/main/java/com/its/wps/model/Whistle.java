package com.its.wps.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="whistle")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Whistle {
    @Id
    private String wid;
    private String category;
    private String subcategory;
    private String latitude;
    private String longitude;
    private String bs64_image;
    private String user_rating;
    private String timestamp;
}
