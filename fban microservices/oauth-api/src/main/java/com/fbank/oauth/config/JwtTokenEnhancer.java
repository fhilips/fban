package com.fbank.oauth.config;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.fbank.oauth.feign.UserFeignClient;
import com.fbank.oauth.model.User;

@Component
public class JwtTokenEnhancer implements TokenEnhancer{

	@Autowired
	private UserFeignClient userFeignClient;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		User user = userFeignClient.findByEmail(authentication.getName()).getBody();
		Map<String, Object> map = new HashMap<>();		
		map.put("userId", user.getId());
		
		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		return accessToken;
	}

	
}