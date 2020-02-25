package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext
@SpringBootTest
class DemoApplicationTests implements ApplicationEventPublisherAware, ApplicationListener<CacheRefreshCompleteEvent> {

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	@Test
	void applicationEvent() throws InterruptedException {
		applicationEventPublisher.publishEvent(new CacheRefreshEvent(this, "event triggered from Springboot test"));
		for(int i=0; i< 20; i ++) {
			Thread.sleep(1000);
		}
		System.out.println("Finished execution of test.");
	}

	public void onApplicationEvent(CacheRefreshCompleteEvent cs) {
		System.out.println("gotcha");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		this.applicationEventPublisher = arg0;
	}

}
