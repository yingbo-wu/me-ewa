package cn.rongcapital.mc2.me.ewa.app.service;

import org.apache.ignite.resources.SpringResource;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.commons.api.ApiResult;
import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteService;
import cn.rongcapital.mc2.me.ewa.api.CampaignStatApi;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatCreateIn;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatFinaledIn;
import cn.rongcapital.mc2.me.ewa.domain.service.CampaignStatAssertService;
import cn.rongcapital.mc2.me.ewa.domain.service.CampaignStatCreateService;

@Service
public class CampaignStatService extends IgniteService implements CampaignStatApi {

	private static final long serialVersionUID = 1L;

	@SpringResource(resourceName = "campaignStatCreateService")
	private transient CampaignStatCreateService campaignStatCreateService;

	@SpringResource(resourceName = "campaignStatAssertService")
	private transient CampaignStatAssertService campaignStatAssertService;

	@Override
	public ApiResult<Void> create(CampaignStatCreateIn in) {
		String flowId = in.getFlowId();
		String nodeId = in.getNodeId();
		String nodeType = in.getType();
		int stayCount = in.getStayCount();
		campaignStatCreateService.create(flowId, nodeId, nodeType, stayCount);
		return ApiResult.success();
	}

	@Override
	public ApiResult<Void> isFinaled(CampaignStatFinaledIn in) {
		String flowId = in.getFlowId();
		boolean finaled = campaignStatAssertService.isFinaled(flowId);
		if (finaled) {
			return ApiResult.success();
		} else {
			return ApiResult.error(-1);
		}
	}

}
