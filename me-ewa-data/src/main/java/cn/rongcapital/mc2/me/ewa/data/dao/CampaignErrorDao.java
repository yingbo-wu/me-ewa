package cn.rongcapital.mc2.me.ewa.data.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import cn.rongcapital.mc2.me.ewa.domain.model.CampaignError;

@Repository
public interface CampaignErrorDao extends MongoRepository<CampaignError, String> {

}
