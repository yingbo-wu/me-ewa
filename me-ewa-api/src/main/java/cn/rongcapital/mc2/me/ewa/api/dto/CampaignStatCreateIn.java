package cn.rongcapital.mc2.me.ewa.api.dto;

import cn.rongcapital.mc2.me.commons.api.ApiIn;

public class CampaignStatCreateIn implements ApiIn {

	private String flowId;

	private String nodeId;

	private String type;

	private int stayCount;

	public CampaignStatCreateIn() {}

	public CampaignStatCreateIn(String flowId, String nodeId, String type, int stayCount) {
		this.flowId = flowId;
		this.nodeId = nodeId;
		this.type = type;
		this.stayCount = stayCount;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStayCount() {
		return stayCount;
	}

	public void setStayCount(int stayCount) {
		this.stayCount = stayCount;
	}

}
