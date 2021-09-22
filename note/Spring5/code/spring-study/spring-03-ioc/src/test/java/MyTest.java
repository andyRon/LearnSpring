import com.andyron.pojo.User;
import com.andyron.pojo.User2;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author Andy Ron
 */
public class MyTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        User user = (User) context.getBean("user");
//
//        user.show();

        User2 user2 = (User2) context.getBean("u3");
        user2.show();
    }

}
