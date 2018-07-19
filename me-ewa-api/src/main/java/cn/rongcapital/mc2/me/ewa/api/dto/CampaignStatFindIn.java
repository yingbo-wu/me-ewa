package cn.rongcapital.mc2.me.ewa.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CampaignStatFindIn {

	@NotEmpty(message = "4001")
	private String campaignId;

	@NotNull(message = "4401")
	private Long tenantId;

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

}
