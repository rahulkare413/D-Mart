package SmartMart.SmartMart.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails rahul = User.builder().username("RAHUL").password("{noop}123").roles("ADMIN").build();

        UserDetails rohit = User.builder().username("ROHIT").password("{noop}456").roles("USER").build();

        return new InMemoryUserDetailsManager(rahul,rohit);
    }
    @Bean
    public DefaultSecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                config -> config.requestMatchers("/product/display").hasAnyRole("ADMIN","USER")
                        .requestMatchers("/product/updateProduct/{id}",
                                "/product/deleteProduct/{id}","/product/updateProduct","/product/addProduct")
                        .hasRole("ADMIN")
                        .requestMatchers("/cart/addProductToTheCart/{id}",
                                "/cart/decreaseProductQty/{id}","/cart/increaseProductQty/{id}","/cart/displayCart")
                        .hasRole("USER")
                        .anyRequest().authenticated()
        )
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
