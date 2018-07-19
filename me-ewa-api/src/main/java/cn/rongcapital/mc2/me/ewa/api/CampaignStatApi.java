package cn.rongcapital.mc2.me.ewa.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;

import org.apache.ignite.services.Service;

import cn.rongcapital.mc2.me.commons.api.ApiResult;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatCreateIn;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatFinaledIn;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatFindIn;
import cn.rongcapital.mc2.me.ewa.api.dto.CampaignStatFindOut;

@ValidateOnExecution
public interface CampaignStatApi extends Service {

	ApiResult<List<CampaignStatFindOut>> find(@NotNull(message = "4000") @Valid CampaignStatFindIn in);

	ApiResult<Void> create(CampaignStatCreateIn in);

	ApiResult<Void> isFinaled(CampaignStatFinaledIn in);

}
