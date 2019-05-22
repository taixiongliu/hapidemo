package com.github.taixiongliu.hapidemo;

import java.io.File;

import com.github.taixiongliu.hapi.HapiHttpContextFactory;
import com.github.taixiongliu.hapi.ssl.KeystoreEntity;
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
        //HapiHttpContextFactory.getInstance().createContext("hapi-context.xml");
        
        //File file = new File("src/main/resources/hapi.keystore");//--test
        File file = new File("hapi.keystore");//--release
        System.out.println(file.exists());
        
        //support protocol https.
        KeystoreEntity entity = new KeystoreEntity("hapi.keystore","123456","123456");
        HapiHttpContextFactory.getInstance().buildHttps(entity).createContext("hapi-context.xml");
        
        //request http test url: http://127.0.0.1:8100/index?parameter=123
        //request https test url: https://127.0.0.1:8100/index?parameter=123
    }
}
