package cn.rongcapital.mc2.me.ewa.data.cao;

import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import cn.rongcapital.mc2.me.ewa.data.CacheName;
import cn.rongcapital.mc2.me.ewa.domain.repository.CampaignLogRepository;

@RepositoryConfig(cacheName = CacheName.CAMPAIGN_LOG_CACHE_NAME)
public interface CampaignLogCao extends CampaignLogRepository {

}
