package com.its.wsms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="whistle_status")
public class WState {
    @Id
    @Column(name = "whistle_id")
    private String whistleId;
    @Column(name = "upvote_count")
    private Integer upvote_count;
    @Column(name = "priority_score")
    private Double priority_score;
    @Column(name = "status")
    private Character status;
}
