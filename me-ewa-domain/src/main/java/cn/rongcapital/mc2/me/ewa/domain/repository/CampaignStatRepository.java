package cn.rongcapital.mc2.me.ewa.domain.repository;

import java.util.List;

import org.apache.ignite.springdata.repository.IgniteRepository;

import cn.rongcapital.mc2.me.ewa.domain.model.CampaignStat;

public interface CampaignStatRepository extends IgniteRepository<CampaignStat, String> {

	List<CampaignStat> findByFlowIdAndNodeType(String flowId, String nodeType);

	List<CampaignStat> findByFlowIdAndNodeTypeNot(String flowId, String nodeType);

	List<CampaignStat> findByFlowId(String flowId);

	List<CampaignStat> findByCampaignId(String campaignId);

}
