package cn.rongcapital.mc2.me.ewa.domain.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;

import cn.rongcapital.mc2.me.ewa.domain.model.CampaignError;

public interface CampaignErrorRepository extends IgniteRepository<CampaignError, String> {

}
