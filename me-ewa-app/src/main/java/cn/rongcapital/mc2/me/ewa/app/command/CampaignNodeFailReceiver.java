package cn.rongcapital.mc2.me.ewa.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.rongcapital.mc2.me.commons.communication.command.CampaignNodeFailCommand;
import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonCommandReceiver;
import cn.rongcapital.mc2.me.commons.model.EwpContext;
import cn.rongcapital.mc2.me.commons.util.GsonUtils;
import cn.rongcapital.mc2.me.ewa.domain.service.CampaignErrorUpsertService;
import cn.rongcapital.mc2.me.ewa.domain.service.CampaignLogEnterService;
import cn.rongcapital.mc2.me.ewa.domain.service.CampaignStatCountService;

@Component
public class CampaignNodeFailReceiver extends RedissonCommandReceiver<CampaignNodeFailCommand> {

	@Autowired
	private CampaignLogEnterService campaignLogEnterService;

	@Autowired
	private CampaignStatCountService campaignStatCountService;

	@Autowired
	private CampaignErrorUpsertService campaignErrorUpsertService;

	@Override
	public void listen(CampaignNodeFailCommand event) {
		String contextJson = (String) event.getSource();
		EwpContext context = GsonUtils.create().fromJson(contextJson, EwpContext.class);
		campaignLogEnterService.logFail(context);
		campaignStatCountService.addFail(context.lookupNodeId());
		campaignErrorUpsertService.upsert(context.lookupNodeId(), context.lookupResultCode(), context.lookupResultMessage());
	}

	@Override
	public String getCommandName() {
		return CampaignNodeFailCommand.COMMAND_NAME;
	}

}
