package cn.rongcapital.mc2.me.ewa.data;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import cn.rongcapital.mc2.me.commons.infrastructure.ignite.IgniteCacheLoader;

@Component
public class Loading implements ApplicationListener<ApplicationReadyEvent> {

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		IgniteCacheLoader.load(CacheName.CAMPAIGN_ERROR_CACHE_NAME);
		IgniteCacheLoader.load(CacheName.CAMPAIGN_STAT_CACHE_NAME);
	}

}
