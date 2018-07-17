package cn.rongcapital.mc2.me.ewa.data.store;

import javax.cache.Cache.Entry;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

import org.apache.ignite.cache.store.CacheStoreAdapter;

import cn.rongcapital.mc2.me.commons.infrastructure.spring.BeanContext;
import cn.rongcapital.mc2.me.ewa.data.dao.CampaignLogDao;
import cn.rongcapital.mc2.me.ewa.domain.model.CampaignLog;

public class CampaignLogStore extends CacheStoreAdapter<Object, CampaignLog> {

	@Override
	public CampaignLog load(Object key) throws CacheLoaderException {
		CampaignLogDao dao = BeanContext.build().getBean(CampaignLogDao.class);
		return dao.findOne((String) key);
	}

	@Override
	public void write(Entry<? extends Object, ? extends CampaignLog> entry) throws CacheWriterException {
		CampaignLogDao dao = BeanContext.build().getBean(CampaignLogDao.class);
		CampaignLog entity = entry.getValue();
		entity.setId((String) entry.getKey());
		dao.save(entry.getValue());
	}

	@Override
	public void delete(Object key) throws CacheWriterException {
		CampaignLogDao dao = BeanContext.build().getBean(CampaignLogDao.class);
		dao.delete(load(key));
	}

}