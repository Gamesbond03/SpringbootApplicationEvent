package com.example.demo;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CaptureCacheRefreshCompleteEvent implements ApplicationListener<CacheRefreshCompleteEvent> {

	private ApplicationEventPublisher applicationEventPublisher;

	void applicationEvent() throws InterruptedException {
		applicationEventPublisher.publishEvent(new CacheRefreshEvent(this, "event triggered from SolrUtilitiesTest()"));
		Thread.sleep(5000);
		System.out.println("Finished execution of test.");
	}

	public void onApplicationEvent(CacheRefreshCompleteEvent cs) {
		System.out.println("gotcha in CaptureCachedRefreshCompleteEvent");
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		this.applicationEventPublisher = arg0;
	}

}
