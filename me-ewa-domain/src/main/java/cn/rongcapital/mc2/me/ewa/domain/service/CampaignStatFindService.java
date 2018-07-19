package cn.rongcapital.mc2.me.ewa.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.ewa.domain.model.CampaignStat;
import cn.rongcapital.mc2.me.ewa.domain.repository.CampaignStatRepository;

@Service
public class CampaignStatFindService {

	@Autowired
	private CampaignStatRepository campaignStatRepository;

	public List<CampaignStat> find(String campaignId) {
		return campaignStatRepository.findByCampaignId(campaignId);
	}

}
