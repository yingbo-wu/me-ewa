package cn.rongcapital.mc2.me.ewa.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import cn.rongcapital.mc2.me.ewa.domain.FieldName;
import cn.rongcapital.mc2.me.ewa.domain.model.CampaignStat;

@Service
public class CampaignStatCountService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public void addStay(String nodeId) {
		Query query = new Query(Criteria.where(FieldName.FIELD_NODE_ID).is(nodeId));
		Update update = new Update();
		update.inc(FieldName.FIELD_STAY_COUNT, 1);
		mongoTemplate.upsert(query, update, CampaignStat.class);
	}

	public void subStay(String nodeId) {
		Query query = new Query(Criteria.where(FieldName.FIELD_NODE_ID).is(nodeId));
		Update update = new Update();
		update.inc(FieldName.FIELD_STAY_COUNT, -1);
		mongoTemplate.upsert(query, update, CampaignStat.class);
	}

	public void addFail(String nodeId) {
		Query query = new Query(Criteria.where(FieldName.FIELD_NODE_ID).is(nodeId));
		Update update = new Update();
		update.inc(FieldName.FIELD_FAIL_COUNT, 1);
		mongoTemplate.upsert(query, update, CampaignStat.class);
	}

}
