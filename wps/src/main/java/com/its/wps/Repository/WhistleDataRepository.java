package com.its.wps.Repository;

import com.its.wps.dto.WhistleResponse;
import com.its.wps.models.WhistleData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhistleDataRepository extends JpaRepository<WhistleData, String> {
    List<WhistleData> findAllByUserId(String userId);
}
