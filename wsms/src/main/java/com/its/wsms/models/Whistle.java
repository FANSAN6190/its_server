package com.its.wsms.models;

import lombok.*;

import java.io.Serializable;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Whistle implements Serializable {
    private String whistleId;
    private String category;
    private String subcategory;
    private String latitude;
    private String longitude;
    private String userRating;
    private String timestamp;
}
