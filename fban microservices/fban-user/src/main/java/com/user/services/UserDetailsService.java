package com.user.services;

import com.user.domain.model.UserDetails;
import com.user.web.dto.request.UserDetailsRequest;

public interface UserDetailsService {

	UserDetails findById(Long id);

	UserDetails create(UserDetailsRequest user);

}
