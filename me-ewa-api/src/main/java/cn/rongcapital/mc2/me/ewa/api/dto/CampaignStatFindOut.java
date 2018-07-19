package cn.rongcapital.mc2.me.ewa.api.dto;

public class CampaignStatFindOut {

	private String nodeId;

	private String nodeType;

	private int failCount;

	private int stayCount;

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	public int getStayCount() {
		return stayCount;
	}

	public void setStayCount(int stayCount) {
		this.stayCount = stayCount;
	}

}
