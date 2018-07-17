package cn.rongcapital.mc2.me.ewa.app.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.rongcapital.mc2.me.commons.communication.command.CampaignNodeStayCommand;
import cn.rongcapital.mc2.me.commons.infrastructure.redisson.RedissonCommandReceiver;
import cn.rongcapital.mc2.me.commons.model.EwpContext;
import cn.rongcapital.mc2.me.commons.util.GsonUtils;
import cn.rongcapital.mc2.me.ewa.domain.service.CampaignLogEnterService;
import cn.rongcapital.mc2.me.ewa.domain.service.CampaignStatCountService;

@Component
public class CampaignNodeStayReceiver extends RedissonCommandReceiver<CampaignNodeStayCommand> {

	@Autowired
	private CampaignLogEnterService campaignLogEnterService;

	@Autowired
	private CampaignStatCountService campaignStatCountService;

	@Override
	public void listen(CampaignNodeStayCommand event) {
		String contextJson = (String) event.getSource();
		EwpContext context = GsonUtils.create().fromJson(contextJson, EwpContext.class);
		campaignLogEnterService.logMove(context);
		campaignStatCountService.addStay(context.lookupNodeId());
	}

	@Override
	public String getCommandName() {
		return CampaignNodeStayCommand.COMMAND_NAME;
	}

}
