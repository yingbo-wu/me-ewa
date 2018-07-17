package cn.rongcapital.mc2.me.ewa.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.ewa.domain.FieldName;
import cn.rongcapital.mc2.me.ewa.domain.model.CampaignError;

@Service
public class CampaignErrorUpsertService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void upsert(String nodeId, int code, String message) {
		Query query = new Query(Criteria.where(FieldName.FIELD_NODE_ID).is(nodeId).and(FieldName.FIELD_CODE).is(code));
		Update update = new Update();
		update.setOnInsert(FieldName.FIELD_MESSAGE, message);
		update.inc(FieldName.FIELD_COUNT, 1);
		mongoTemplate.upsert(query, update, CampaignError.class);
	}

}
