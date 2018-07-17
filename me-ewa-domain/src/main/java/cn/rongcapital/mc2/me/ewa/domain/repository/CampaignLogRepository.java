package cn.rongcapital.mc2.me.ewa.domain.repository;

import org.apache.ignite.springdata.repository.IgniteRepository;

import cn.rongcapital.mc2.me.ewa.domain.model.CampaignLog;

public interface CampaignLogRepository extends IgniteRepository<CampaignLog, String> {

	CampaignLog findOneByNodeId(String nodeId);

	int countByNodeIdAndType(String nodeId, String type);

}
