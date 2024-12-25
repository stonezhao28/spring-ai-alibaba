/*
 * Copyright 2024-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.cloud.ai.functioncalling.toutiaonews;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

/**
 * @author XiaoYunTao
 * @since 2024/12/18
 */
@Configuration
@ConditionalOnClass(ToutiaoNewsService.class)
@ConditionalOnProperty(prefix = "spring.ai.alibaba.plugin.toutiaonews", name = "enabled", havingValue = "true")
public class TiaotiaoNewsAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	@Description("Get the news from the toutiao news (获取今日头条新闻).")
	public ToutiaoNewsService getToutiaoNewsFunction() {
		return new ToutiaoNewsService();
	}

}