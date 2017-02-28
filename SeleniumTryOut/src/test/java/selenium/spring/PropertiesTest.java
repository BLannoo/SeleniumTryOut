package selenium.spring;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringContext.class)
public class PropertiesTest {

    @Autowired
    private User user;

    @Test
    public void givenSpringContextLoaded_WhenAskingUserName_ThenUserNameIsBruno() throws Exception {
        Assertions.assertThat(user.getUserName()).isEqualTo("bruno");
    }

    @Test
    public void givenSpringContextLoaded_WhenAskingUserPassword_ThenPasswordIsPass() throws Exception {
        Assertions.assertThat(user.getPassword()).isEqualTo("pass");
    }
}
