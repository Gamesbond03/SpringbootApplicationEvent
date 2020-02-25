package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoCache implements ApplicationListener<CacheRefreshEvent>, ApplicationEventPublisherAware {
	
	private ApplicationEventPublisher appEventpublisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.appEventpublisher = applicationEventPublisher;
	}

	@Autowired
	public DemoCache() {
//		appEventpublisher.publishEvent(
//				new CachedModelDataRefreshCompleteEvent(this, "event triggered from CachedModelDataAccess"));
	}

	public void onApplicationEvent(CacheRefreshEvent cs) {
		triggerCacheRefreshCompleteEvent();
	}

	private void triggerCacheRefreshCompleteEvent() {
		appEventpublisher.publishEvent(
				new CacheRefreshCompleteEvent(this, "event triggered from CachedModelDataAccess"));
	}
	


}
