package cn.rongcapital.mc2.me.ewa.domain.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.google.gson.annotations.Expose;

import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteEntity;
import cn.rongcapital.mc2.me.ewa.domain.FieldName;

@Document(collection = "campaign_log")
public class CampaignLog extends IgniteEntity {

	@Expose
	@Field(FieldName.FIELD_MID)
	private int mid;

	@Expose
	@Field(FieldName.FIELD_TYPE)
	private String type;

	@Expose
	@QuerySqlField(index = true)
	@Field(FieldName.FIELD_FLOW_ID)
	private String flowId;

	@Expose
	@QuerySqlField(index = true)
	@Field(FieldName.FIELD_NODE_ID)
	private String nodeId;

	@Expose
	@Field(FieldName.FIELD_NODE_TYPE)
	private String nodeType;

	@Expose
	@Field(FieldName.FIELD_DETAIL)
	private CampaignLogDetail detail;

	public CampaignLog() {}

	public CampaignLog(int mid, String type, String flowId, String nodeId, String nodeType, int code, String message) {
		this.mid = mid;
		this.type = type;
		this.flowId = flowId;
		this.nodeId = nodeId;
		this.nodeType = nodeType;
		this.detail = new CampaignLogDetail(code, message);
	}

	public boolean isStartNodeLog() {
		return CampaignStatNodeType.START.equals(CampaignStatNodeType.valueOf(this.nodeType));
	}

}
