package cn.rongcapital.mc2.me.ewa.domain.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteEntity;
import cn.rongcapital.mc2.me.ewa.domain.FieldName;

@SuppressWarnings("serial")
@Document(collection = "campaign_error")
public class CampaignError extends IgniteEntity {

	@Field(FieldName.FIELD_NODE_ID)
	private String nodeId;

	@Field(FieldName.FIELD_CODE)
	private int code;

	@Field(FieldName.FIELD_MESSAGE)
	private String message;

	@Field(FieldName.FIELD_COUNT)
	private int count;

	public CampaignError() {}

	public CampaignError(String nodeId, int code, String message) {
		this.nodeId = nodeId;
		this.code = code;
		this.message = message;
	}

}
