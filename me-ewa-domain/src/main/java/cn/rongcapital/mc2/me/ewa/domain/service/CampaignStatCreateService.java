package cn.rongcapital.mc2.me.ewa.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.ewa.domain.model.CampaignStat;
import cn.rongcapital.mc2.me.ewa.domain.repository.CampaignStatRepository;

@Service
public class CampaignStatCreateService {

	@Autowired
	private CampaignStatRepository campaignStatRepository;

	public void create(String flowId, String nodeId, String nodeType, int stayCount) {
		CampaignStat campaignStat = new CampaignStat(flowId, nodeId, nodeType, stayCount);
		campaignStatRepository.save(campaignStat);
	}

}
