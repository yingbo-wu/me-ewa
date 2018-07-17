package cn.rongcapital.mc2.me.ewa.api;

import org.apache.ignite.services.Service;

import cn.rongcapital.mc2.me.commons.api.ApiResult;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatCreateIn;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatFinaledIn;

public interface CampaignStatApi extends Service {

	ApiResult<Void> create(CampaignStatCreateIn in);

	ApiResult<Void> isFinaled(CampaignStatFinaledIn in);

}
