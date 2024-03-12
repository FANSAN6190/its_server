package com.its.wsms.models;

import com.its.wsms.dto.JsonObjectStringConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "whistle_data")
public class WhistleData implements Serializable {
    @Id
    @Builder.Default
    @Column(name = "whistle_id")
    private String whistleId = UUID.randomUUID().toString();

    @Column(name = "user_id")
    private String userId;
    @Column(name = "whistle_obj",columnDefinition = "jsonb")
    @Convert(converter = JsonObjectStringConverter.class)
    @ColumnTransformer(write = "?::jsonb")
    private Whistle whistleObj;
    @Column(name = "binary_image")
    private String binaryImage;
    @Column(name = "timestamp")
    private String timestamp;
}
