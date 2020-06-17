package com.mypro.demo.oauth_client1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.endpoint.AbstractOAuth2AuthorizationGrantRequest;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;

//@Configuration
@EnableWebSecurity(debug = true)
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
                .antMatchers("/user/zhouhu1").permitAll()
                .antMatchers("/user/zhouhu2").authenticated()
                .anyRequest().authenticated()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
                .and()
                .oauth2Login();
//                .successHandler();
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
