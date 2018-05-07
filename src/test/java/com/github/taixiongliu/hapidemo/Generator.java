package com.github.taixiongliu.hapidemo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/**
 * 生成数据映射对象及相关的实体mappper映射文件
 * 
 * @author admin
 *
 */
public class Generator {
	public Generator() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// 使用JDK日志
		org.mybatis.generator.logging.LogFactory.forceJavaLogging();
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		ConfigurationParser cp = new ConfigurationParser(warnings);
		File configFile = new File("src/main/resources/generatorConfig.xml");
		System.out.println(configFile);
		System.out.println(configFile.getAbsolutePath());
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		
	}
}
