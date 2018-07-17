package cn.rongcapital.mc2.me.ewa.domain.model;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.google.gson.annotations.Expose;

import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteEntity;
import cn.rongcapital.mc2.me.ewa.domain.FieldName;

@Document(collection = "campaign_stat")
public class CampaignStat extends IgniteEntity {

	@Expose
	@QuerySqlField(index = true)
	@Field(FieldName.FIELD_FLOW_ID)
	private String flowId;

	@Expose
	@QuerySqlField(index = true)
	@Field(FieldName.FIELD_NODE_ID)
	private String nodeId;

	@Field(FieldName.FIELD_TYPE)
	private String nodeType;

	@Field(FieldName.FIELD_FAIL_COUNT)
	private int failCount;

	@Field(FieldName.FIELD_STAY_COUNT)
	private int stayCount;

	public CampaignStat() {}

	public CampaignStat(String flowId, String nodeId, String nodeType, int stayCount) {
		this.flowId = flowId;
		this.nodeId = nodeId;
		this.nodeType = nodeType;
		this.stayCount = stayCount;
	}

	public boolean hasStayed() {
		return 0 != stayCount;
	}

}
