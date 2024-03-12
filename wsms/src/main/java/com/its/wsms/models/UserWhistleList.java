package com.its.wsms.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserWhistleList {
    private String userId;
    List<Whistle> whistleList;

}
