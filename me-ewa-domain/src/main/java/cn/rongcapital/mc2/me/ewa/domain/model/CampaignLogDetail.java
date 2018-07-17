package cn.rongcapital.mc2.me.ewa.domain.model;

import org.springframework.data.mongodb.core.mapping.Field;

import com.google.gson.annotations.Expose;

import cn.rongcapital.mc2.me.ewa.domain.FieldName;

public class CampaignLogDetail {

	@Expose
	@Field(FieldName.FIELD_CODE)
	private int code;

	@Expose
	@Field(FieldName.FIELD_MESSAGE)
	private String message;

	public CampaignLogDetail() {}

	public CampaignLogDetail(int code, String message) {
		this.code = code;
		this.message = message;
	}

}
