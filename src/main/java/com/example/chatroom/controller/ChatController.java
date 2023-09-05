package com.example.chatroom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.chatroom.model.Message;

@Controller
public class ChatController {

	@Autowired
	public SimpMessagingTemplate simpleMessagingTemplate;
	
	
	@MessageMapping("/message") // API should be /app/message (whenever user want to send message using websocket)
	@SendTo("/chatroom/public") // receive message from public chat
	public Message receivePublicMessage(@Payload Message message) {
		return message;
		
	}
//	@MessageMapping("/private-message")
//	public Message recievePrivateMessage(@Payload Message message) {
//		simpleMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);  //user/david/private
//		return message;
//	}
}
