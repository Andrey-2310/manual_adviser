package com.ranv.Security.jwt.security.service;


//@Component
//@RequiredArgsConstructor
//public class JwtAuthenticationProvider implements AuthenticationProvider {
//
//    private static final long MILLIS_IN_SECOND = 1000L;
//
//    private final UserRepository userRepository;
//    private final AuthenticationHelper authenticationHelper;
//
//    @Override
//    public Authentication authenticate(final Authentication authRequest) {
//        // Getting string token from authentication request object
//        String token = StringUtils.trimToNull((String) authRequest.getCredentials());
//
//        //  Deserialize token
//        AccessToken accessToken = authenticationHelper.decodeToken(token);
//
//
//        // Getting user id from token
//        String sub = accessToken.getSub();
//        if (Objects.isNull(sub)) {
//            throw new InvalidTokenAuthenticationException("Token does not contain a user id.");
//        }
//
//        // Getting user from database
//        User user = userRepository.findBySub(sub);
//        if (Objects.isNull(user)) {
//            throw new InvalidTokenAuthenticationException("Token does not contain existed user id.");
//        }
//
//        // Return authenticated Authentication
//        JwtUserDetails userDetails = new JwtUserDetails(user);
//        return new JwtAuthenticationToken(userDetails);
//    }
//
//    private void checkIsExpired(final Long tokenExpirationTime) {
//        if ((System.currentTimeMillis() / MILLIS_IN_SECOND) > tokenExpirationTime) {
//            throw new ExpiredTokenAuthenticationException();
//        }
//    }
//
//    @Override
//    public boolean supports(final Class<?> authentication) {
//        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
//    }
//}