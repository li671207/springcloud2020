package com.lihl.springcloud;


import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;


@Slf4j
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {

	@Resource
	private MessageChannel output;


	@Override
	public String send() {
		String uuid = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(uuid).build());
		log.info("uuid...." + uuid);
		return null;
	}
}
