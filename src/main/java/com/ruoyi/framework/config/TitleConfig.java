package com.ruoyi.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.ruoyi.common.utils.MessageUtils;

/**
 * クライアント側の画面見出し(title.properties)
 * 
 * @author lnsylt
 *
 */
@Configuration("title")
@PropertySource("classpath:static/i18n/title.properties")
//@PropertySource("classpath:${temp.profiles.path}"+"${temp.profiles.prefix}"+"${temp.profiles.separator}"+"${temp.profiles.suffix}")
public class TitleConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "select.option.edu")
	SampleConfig configEdu() {
		return new SampleConfig();
	}
	
	public String getTitle(String code,Object...args) {
        return MessageUtils.message(code, args);
	}
}
