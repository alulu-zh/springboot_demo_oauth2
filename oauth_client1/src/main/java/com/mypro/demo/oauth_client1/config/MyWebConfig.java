package com.mypro.demo.oauth_client1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity(debug = true)
public class MyWebConfig extends WebSecurityConfigurerAdapter {
//    private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
//    private final ClientRegistrationRepository clientRegistrationRepository;
//    private final AuthorizationRequestRepository<OAuth2AuthorizationRequest> authorizationRequestRepository;
//    public MyWebConfig(OAuth2AuthorizedClientService oAuth2AuthorizedClientService, ClientRegistrationRepository clientRegistrationRepository, AuthorizationRequestRepository<OAuth2AuthorizationRequest> authorizationRequestRepository) {
//        this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
//        this.clientRegistrationRepository = clientRegistrationRepository;
//        this.authorizationRequestRepository = authorizationRequestRepository;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/login**", "/error**").permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .and().oauth2Login();
//                .loginPage("/loginoauth")
//                .defaultSuccessUrl("/loginsucess")
//                .authorizationEndpoint()
//                .baseUri("/oauth2/authorize")
//                .authorizationRequestRepository(authorizationRequestRepository)
//                .and()
//                .clientRegistrationRepository(clientRegistrationRepository)
//                .authorizedClientService(oAuth2AuthorizedClientService)
//                .and().oauth2Client();
    }
}
