package cn.rongcapital.mc2.me.ewa.data.store;

import javax.cache.Cache.Entry;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

import org.apache.ignite.cache.store.CacheStoreAdapter;

import cn.rongcapital.mc2.me.commons.infrastructure.spring.BeanContext;
import cn.rongcapital.mc2.me.ewa.data.dao.CampaignErrorDao;
import cn.rongcapital.mc2.me.ewa.domain.model.CampaignError;

public class CampaignErrorStore extends CacheStoreAdapter<Object, CampaignError> {

	@Override
	public CampaignError load(Object key) throws CacheLoaderException {
		CampaignErrorDao dao = BeanContext.build().getBean(CampaignErrorDao.class);
		return dao.findOne((String) key);
	}

	@Override
	public void write(Entry<? extends Object, ? extends CampaignError> entry) throws CacheWriterException {
		CampaignErrorDao dao = BeanContext.build().getBean(CampaignErrorDao.class);
		CampaignError entity = entry.getValue();
		entity.setId((String) entry.getKey());
		dao.save(entry.getValue());
	}

	@Override
	public void delete(Object key) throws CacheWriterException {
		CampaignErrorDao dao = BeanContext.build().getBean(CampaignErrorDao.class);
		dao.delete(load(key));
	}

}