package com.github.taixiongliu.hapidemo;

import com.github.taixiongliu.hapi.HapiHttpContextFactory;
import com.github.taixiongliu.hapidemo.spring.SpringContextFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//add module spring
        SpringContextFactory.getInstance().load("spring-config.xml");
    	
    	// create hapi context default auto
    	//HapiHttpContextFactory.getInstance().createContext("hapi-context.xml",JsonHapiHttpRequestImpl.class) post content json
    	//HapiHttpContextFactory.getInstance().createContext("hapi-context.xml",DefaultHapiHttpRequestImpl.class) post content http
    	//HapiHttpContextFactory.getInstance().createContext("hapi-context.xml",Self.class extends BaseHapiHttpRequestImpl) post content yourself
        HapiHttpContextFactory.getInstance().createContext("hapi-context.xml");
    }
}
