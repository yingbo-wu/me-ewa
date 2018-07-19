package cn.rongcapital.mc2.me.ewa.domain.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.google.gson.annotations.Expose;

import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteEntity;
import cn.rongcapital.mc2.me.commons.util.GsonUtils;
import cn.rongcapital.mc2.me.ewa.domain.FieldName;

@SuppressWarnings("serial")
@Document(collection = "campaign_stat")
public class CampaignStat extends IgniteEntity {

	@Expose
	@QuerySqlField(index = true)
	@Field(FieldName.FIELD_CAMPAIGN_ID)
	private String campaignId;

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

	public CampaignStat(String campaignId, String flowId, String nodeId, String nodeType, int stayCount) {
		this.campaignId = campaignId;
		this.flowId = flowId;
		this.nodeId = nodeId;
		this.nodeType = nodeType;
		this.stayCount = stayCount;
	}

	public boolean hasStayed() {
		return 0 != stayCount;
	}

	public <T> T toFindOut(Class<T> outType) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nodeId", this.nodeId);
		map.put("nodeType", this.nodeType);
		map.put("failCount", this.failCount);
		map.put("stayCount", this.stayCount);
		String json = GsonUtils.create().toJson(map);
		return GsonUtils.create().fromJson(json, outType);
	}

}
