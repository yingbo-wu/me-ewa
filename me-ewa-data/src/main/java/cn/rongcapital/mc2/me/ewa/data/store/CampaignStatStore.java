package cn.rongcapital.mc2.me.ewa.data.store;

import java.util.List;

import javax.cache.Cache.Entry;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.lang.IgniteBiInClosure;

import cn.rongcapital.mc2.me.commons.infrastructure.spring.BeanContext;
import cn.rongcapital.mc2.me.ewa.data.dao.CampaignStatDao;
import cn.rongcapital.mc2.me.ewa.domain.model.CampaignStat;

public class CampaignStatStore extends CacheStoreAdapter<Object, CampaignStat> {

	@Override
	public void loadCache(IgniteBiInClosure<Object, CampaignStat> clo, Object... args) {
		CampaignStatDao dao = BeanContext.build().getBean(CampaignStatDao.class);
		List<CampaignStat> entities = dao.findAll();
		entities.parallelStream().forEach(entity -> {
			clo.apply(entity.getId(), entity);
		});
	}

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