import com.andyron.dao.UserDaoSqlserverImpl;
import com.andyron.service.*;

/**
 * @author Andy Ron
 */
public class MyTest {

    public static void main(String[] args) {

        // 用户实际调用的是业务层，他们不需要接触dao层
        UserService userService = new UserServiceImpl();

        ((UserServiceImpl) userService).setUserDao(new UserDaoSqlserverImpl());

        userService.getUser();
    }
}
