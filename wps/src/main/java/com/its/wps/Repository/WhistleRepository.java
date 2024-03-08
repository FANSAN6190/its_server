package com.its.wps.Repository;

import com.its.wps.model.Whistle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WhistleRepository extends MongoRepository<Whistle, String> {

}
