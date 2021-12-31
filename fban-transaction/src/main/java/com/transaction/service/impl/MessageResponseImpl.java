package com.transaction.service.impl;

import com.transaction.service.MessageResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageResponseImpl implements MessageResponse{	

	private String message;
	
	@Override
	public MessageResponseImpl createMessageResponse(Long id, String text) {		
		return new MessageResponseImpl(text);
	}
}
