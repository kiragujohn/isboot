
package com.njoroge.is.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value( "${security.signing-key}" )
    private String signingKey;

    @Value( "${security.encoding-strength}" )
    private Integer encodingStrength;

    @Value( "${security.security-realm}" )
    private String securityRealm;

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {

        return super.authenticationManager();
    }


    @Override
    protected void configure( AuthenticationManagerBuilder auth )
            throws Exception {

        auth.userDetailsService( userDetailsService ).passwordEncoder(
                new BCryptPasswordEncoder() );
    }


    @Override
    public void configure( WebSecurity web ) throws Exception {

        web.ignoring().antMatchers( "/is/config/getinitialdata",
                "/is/buyer/register",
                "/is/buyer/register/getbuyerregisterInitialData",
                "/is/title/getinitialdata", "/is/home/getinitialdata",
                "/is/user/email/activateuseremail",
                "/is/user/email/sendforgottenpasswordemail",
                "/is/user/email/validatepassword",
                "/is/user/resetforgottenpassword",
                "/is/user/getforgottenpasswordinitialdata",
                "/is/user/verifyforgottenpasswordcode" );

    }


    @Override
    protected void configure( HttpSecurity http ) throws Exception {

        http.sessionManagement().sessionCreationPolicy(
                SessionCreationPolicy.STATELESS ).and().authorizeRequests()
                .antMatchers( "/actuator/**", "/api-docs/**" ).permitAll()
                .antMatchers( "/is/**" ).authenticated().and().httpBasic()
                .realmName( securityRealm ).and().csrf().disable();
    }


    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey( signingKey );
        return converter;
    }


    @Bean
    public TokenStore tokenStore() {

        return new JwtTokenStore( accessTokenConverter() );
    }


    @Bean
    public DefaultTokenServices tokenServices() {

        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore( tokenStore() );
        defaultTokenServices.setSupportRefreshToken( true );
        return defaultTokenServices;
    }
}
