package ma.xproce.emobile.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/telephone/**","/","/images/**","/accessoir","/accessoir/**","/arrlist","/arr","/arr/**"
                                ,"/livreur","/livreur/**",
                                "/cart","/cart/**",
                                "/categorie","/categorie/**",
                                "/comm","/comm/**","/afficher-commande","/ajouter-adresse","/passer-commande","/confirmation",
                                "/rolelist",
                                "/telephone","/telephone/**"
                        ).authenticated()
                        .requestMatchers("/home","/user/new" ,"/webjars/**","/h2-console/**","/user",
                                "/user/**","/**").permitAll())
//                .formLogin((form -> form.loginPage("/loginpage").permitAll()))
                .formLogin(form -> form
                        .defaultSuccessUrl("/telephone", true)) // Redirige vers /listeReclamations après une connexion réussie
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails admin = User.withUsername("admin")
//                .password("12345")
//                .authorities("admin")
//                .roles("admin")
//                .build();
//        UserDetails user = User.withUsername("user")
//                .password("12345")
//                .roles("user")
//                .build();
//        return new InMemoryUserDetailsManager( admin, user);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}