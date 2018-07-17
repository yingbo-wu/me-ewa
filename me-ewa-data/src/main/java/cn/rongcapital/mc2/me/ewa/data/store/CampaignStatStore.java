package cn.rongcapital.mc2.me.ewa.data.store;

import javax.cache.Cache.Entry;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

import org.apache.ignite.cache.store.CacheStoreAdapter;

import cn.rongcapital.mc2.me.commons.infrastructure.spring.BeanContext;
import cn.rongcapital.mc2.me.ewa.data.dao.CampaignStatDao;
import cn.rongcapital.mc2.me.ewa.domain.model.CampaignStat;

public class CampaignStatStore extends CacheStoreAdapter<Object, CampaignStat> {

	@Override
	public CampaignStat load(Object key) throws CacheLoaderException {
		CampaignStatDao dao = BeanContext.build().getBean(CampaignStatDao.class);
		return dao.findOne((String) key);
	}

	@Override
	public void write(Entry<? extends Object, ? extends CampaignStat> entry) throws CacheWriterException {
		CampaignStatDao dao = BeanContext.build().getBean(CampaignStatDao.class);
		CampaignStat entity = entry.getValue();
		entity.setId((String) entry.getKey());
		dao.save(entry.getValue());
	}

	@Override
	public void delete(Object key) throws CacheWriterException {
		CampaignStatDao dao = BeanContext.build().getBean(CampaignStatDao.class);
		dao.delete(load(key));
	}

}