package com.transaction.service;

import com.transaction.service.impl.MessageResponseImpl;

public interface MessageResponse {

	MessageResponseImpl createMessageResponse(Long id, String text);
}
