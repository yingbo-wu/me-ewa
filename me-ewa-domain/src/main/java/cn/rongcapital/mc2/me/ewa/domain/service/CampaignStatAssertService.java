package cn.rongcapital.mc2.me.ewa.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.ewa.domain.model.CampaignStat;
import cn.rongcapital.mc2.me.ewa.domain.model.CampaignStatNodeType;
import cn.rongcapital.mc2.me.ewa.domain.repository.CampaignStatRepository;

@Service
public class CampaignStatAssertService {

	@Autowired
	private CampaignStatRepository campaignStatRepository;

	public boolean isFinaled(String flowId) {
		// 1.start节点无停留数据
		List<CampaignStat> startNodeStats = campaignStatRepository.findByFlowIdAndNodeType(flowId, CampaignStatNodeType.START.name());
		long startNodeStayCount = startNodeStats.stream().filter(stat -> stat.hasStayed()).count();
		if (0 == startNodeStayCount) {
			// 2.delay节点无停留数据
			List<CampaignStat> delayNodeStats = campaignStatRepository.findByFlowIdAndNodeType(flowId, CampaignStatNodeType.DELAY.name());
			long delayNodeStayCount = delayNodeStats.stream().filter(stat -> stat.hasStayed()).count();
			if (0 == delayNodeStayCount) {
				// 3.除end节点外所有节点连续2次无停留数据
				List<CampaignStat> nodeStats = campaignStatRepository.findByFlowIdAndNodeTypeNot(flowId, CampaignStatNodeType.END.name());
				long stayCount = nodeStats.stream().filter(stat -> stat.hasStayed()).count();
				if (0 == stayCount) {
					nodeStats = campaignStatRepository.findByFlowIdAndNodeTypeNot(flowId, CampaignStatNodeType.END.name());
					stayCount = nodeStats.stream().filter(stat -> stat.hasStayed()).count();
					if (0 == stayCount) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
