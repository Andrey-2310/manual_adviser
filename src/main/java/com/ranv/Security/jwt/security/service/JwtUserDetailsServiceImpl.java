package com.ranv.Security.jwt.security.service;

//@Service
//@RequiredArgsConstructor
//public class JwtUserDetailsServiceImpl implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User byUsername = this.userRepository.findByUsername(username);
//
//        return Optional.ofNullable(byUsername)
//                .map(JwtUserDetails::new)
//                .orElseThrow(() -> new JsonException("User nor found."));
//    }
//}
