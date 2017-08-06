package com.ranv.Security.jwt.service;

import com.ranv.model.DB.User;
import com.ranv.model.DTO.UserDTO;
import com.ranv.Security.jwt.security.SecurityHelper;
import com.ranv.repository.UserRepository;
import com.ranv.service.serviceDTO.ServiceUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ikatlinsky
 * @since 5/12/17
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final ServiceUserDTO serviceUserDTO;

    /**
     * Get user info.
     * @return user info.
     */
    @Transactional(readOnly = true)
    public UserDTO getMe() {
        Authentication authentication = SecurityHelper.getAuthenticationWithCheck();
        User user = userRepository.findBySub(authentication.getName());

        return serviceUserDTO.convertToItemDTO(user);
    }
}
