package com.ranv.Security.jwt;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@RequiredArgsConstructor
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private static final String[] allowedUrlsForPost = new String[]{ "/auth/login" };
//
//    private final JwtAuthenticationProvider jwtAuthenticationProvider;
//    private final UserDetailsService userDetailsService;
//
//    @Autowired
//    public void configureAuthentication(final AuthenticationManagerBuilder authenticationManagerBuilder)
//            throws Exception {
//        authenticationManagerBuilder
//                .userDetailsService(this.userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new StandardPasswordEncoder();
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authorizeRequests()
//                .antMatchers("/**")
//                .permitAll()
//                .and()
//                .csrf().disable()
//                .addFilterAfter(new JwtAuthenticationFilter(authenticationManagerBean()),
//                        BasicAuthenticationFilter.class)
//                .exceptionHandling()
//                .authenticationEntryPoint(new RestAuthenticationEntryPoint())
//                .accessDeniedHandler(new RestAccessDeniedHandler());
//    }
//
//    @Override
//    public void configure(final WebSecurity web) throws Exception {
//        web.ignoring()
//                .antMatchers(HttpMethod.POST, allowedUrlsForPost)
//                .antMatchers(HttpMethod.OPTIONS, "/**");
//    }
//
//    @Override
//    protected void configure(final AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                .authenticationProvider(this.jwtAuthenticationProvider)
//                .userDetailsService(this.userDetailsService)
//                .passwordEncoder(this.passwordEncoder());
//    }
//}
