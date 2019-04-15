import com.twu.biblioteca.Authorizer;
import com.twu.biblioteca.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class AuthorizerTest {

    @Test
    public void validLogin() {
        //given
        Authorizer classUnderTest = new Authorizer();
        //when
        User user = classUnderTest.validateCredentials("123-1234", "password123");
        //then
        assertThat(user, is(notNullValue()));
    }
}
