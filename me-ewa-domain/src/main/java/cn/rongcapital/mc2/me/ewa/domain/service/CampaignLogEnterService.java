package cn.rongcapital.mc2.me.ewa.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.commons.model.EwpContext;
import cn.rongcapital.mc2.me.ewa.domain.model.CampaignLog;
import cn.rongcapital.mc2.me.ewa.domain.model.CampaignLogType;
import cn.rongcapital.mc2.me.ewa.domain.repository.CampaignLogRepository;

@Service
public class CampaignLogEnterService {

	@Autowired
	private CampaignLogRepository campaignLogRepository;

	public void logFail(EwpContext context) {
		int mid = context.lookupMid();
		String campaignId = context.getCampaignId();
		String flowId = context.getFlowId();
		String nodeId = context.lookupNodeId();
		String nodeType = context.lookupNodeType();
		int code = context.lookupResultCode();
		String message = context.lookupResultMessage();
		CampaignLog log = new CampaignLog(mid, CampaignLogType.FAILED.name(), campaignId, flowId, nodeId, nodeType, code, message);
		campaignLogRepository.save(log);
	}

	public void logMove(EwpContext context) {
		int mid = context.lookupMid();
		String campaignId = context.getCampaignId();
		String flowId = context.getFlowId();
		String nodeId = context.lookupNodeId();
		String nodeType = context.lookupNodeType();
		int code = context.lookupResultCode();
		String message = context.lookupResultMessage();
		CampaignLog log = new CampaignLog(mid, CampaignLogType.MOVED.name(), campaignId, flowId, nodeId, nodeType, code, message);
		campaignLogRepository.save(log);
	}

	public void logStay(EwpContext context) {
		int mid = context.lookupMid();
		String campaignId = context.getCampaignId();
		String flowId = context.getFlowId();
		String nodeId = context.lookupNodeId();
		String nodeType = context.lookupNodeType();
		int code = context.lookupResultCode();
		String message = context.lookupResultMessage();
		CampaignLog log = new CampaignLog(mid, CampaignLogType.STAYED.name(), campaignId, flowId, nodeId, nodeType, code, message);
		campaignLogRepository.save(log);
	}

}
