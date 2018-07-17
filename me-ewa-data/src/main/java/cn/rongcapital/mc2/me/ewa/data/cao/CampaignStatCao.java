package cn.rongcapital.mc2.me.ewa.data.cao;

import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import cn.rongcapital.mc2.me.ewa.data.Consts;
import cn.rongcapital.mc2.me.ewa.domain.repository.CampaignLogRepository;

@RepositoryConfig(cacheName = Consts.CAMPAIGN_STAT_CACHE_NAME)
public interface CampaignStatCao extends CampaignLogRepository {

}
