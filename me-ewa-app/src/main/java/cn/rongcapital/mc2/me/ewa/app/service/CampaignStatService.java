package cn.rongcapital.mc2.me.ewa.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.ignite.resources.SpringResource;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.commons.api.ApiResult;
import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteService;
import cn.rongcapital.mc2.me.ewa.api.CampaignStatApi;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatCreateIn;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatFinaledIn;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatFindIn;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatFindOut;
import cn.rongcapital.mc2.me.ewa.domain.model.CampaignStat;
import cn.rongcapital.mc2.me.ewa.domain.service.CampaignStatAssertService;
import cn.rongcapital.mc2.me.ewa.domain.service.CampaignStatCreateService;
import cn.rongcapital.mc2.me.ewa.domain.service.CampaignStatFindService;

@Service
public class CampaignStatService extends IgniteService implements CampaignStatApi {

	private static final long serialVersionUID = 1L;

	@SpringResource(resourceName = "campaignStatCreateService")
	private transient CampaignStatCreateService campaignStatCreateService;

	@SpringResource(resourceName = "campaignStatAssertService")
	private transient CampaignStatAssertService campaignStatAssertService;

	@SpringResource(resourceName = "campaignStatFindService")
	private transient CampaignStatFindService campaignStatFindService;

	@Override
	public ApiResult<Void> create(CampaignStatCreateIn in) {
		String campaignId = in.getCampaignId();
		String flowId = in.getFlowId();
		String nodeId = in.getNodeId();
		String nodeType = in.getType();
		int stayCount = in.getStayCount();
		campaignStatCreateService.create(campaignId, flowId, nodeId, nodeType, stayCount);
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

	@Override
	public ApiResult<List<CampaignStatFindOut>> find(CampaignStatFindIn in) {
		String campaignId = in.getCampaignId();
		List<CampaignStat> list = campaignStatFindService.find(campaignId);
		List<CampaignStatFindOut> outList = list.stream().map(stat -> stat.toFindOut(CampaignStatFindOut.class)).collect(Collectors.toList());
		return ApiResult.success(outList);
	}

}
