package com.github.taixiongliu.hapidemo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextFactory {
	private static SpringContextFactory factory = null;
	public static SpringContextFactory getInstance(){
		if(factory != null){
			return factory;
		}
		synchronized (SpringContextFactory.class) {
			if(factory == null){
				factory = new SpringContextFactory();
			}
		}
		return factory;
	}
	ApplicationContext actx = null;
	private SpringContextFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public void load(String configLocation){
		actx = new ClassPathXmlApplicationContext(configLocation);
	}
	
	public <T> T getBean(Class<T> clazz){
		return actx.getBean(clazz);
	}
}
