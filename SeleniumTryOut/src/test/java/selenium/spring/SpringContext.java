package selenium.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:properties")
public class SpringContext {

    @Bean
    public User user(@Value("${user.name}") String userName,@Value("${user.password}") String password) {
        return new User(userName, password);
    }
}
