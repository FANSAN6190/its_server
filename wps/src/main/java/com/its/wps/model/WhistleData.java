package com.its.wps.model;

import com.its.wps.dto.JsonObjectStringConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.Id;
import org.json.JSONObject;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WhistleData {
    @Id
    private String whistle_id;
    private String user_id;
    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonObjectStringConverter.class)
    private JSONObject whistle_object;
    private String bs64_image;
    private String timestamp;
}
