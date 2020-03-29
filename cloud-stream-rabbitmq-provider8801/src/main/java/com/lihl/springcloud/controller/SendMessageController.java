package com.lihl.springcloud.controller;


import com.lihl.springcloud.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

	@Autowired
	private IMessageProvider messageProvider;

	@GetMapping("/sendMessage")
	public String send() {
		return messageProvider.send();
	}

}
