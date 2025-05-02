import com.tuanfans.service.UserService;
import org.junit.jupiter.api.Test;

/**
 * @author TuanFans
 * &#064;date 2025/4/9
 * &#064description
 */
public class UserTest {
    @Test
    public void testUser(){
        UserService us = new UserService();
        us.getUser();
    }
}
