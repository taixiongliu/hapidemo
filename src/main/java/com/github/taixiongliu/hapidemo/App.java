package com.github.taixiongliu.hapidemo;

import com.github.taixiongliu.hapi.HapiHttpContextFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// create hapi context default auto
    	//HapiHttpContextFactory.getInstance().createContext("hapi-context.xml",JsonHapiHttpRequestImpl.class) post content json
    	//HapiHttpContextFactory.getInstance().createContext("hapi-context.xml",DefaultHapiHttpRequestImpl.class) post content http
    	//HapiHttpContextFactory.getInstance().createContext("hapi-context.xml",Self.class extends BaseHapiHttpRequestImpl) post content yourself
        HapiHttpContextFactory.getInstance().createContext("hapi-context.xml");
    }
}
