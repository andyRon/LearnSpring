import com.andyron.pojo.User;
import com.andyron.pojo.User2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;


/**
 * @author Andy Ron
 */
public class MyTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = (User) context.getBean("user");
        user.show();
        User user_1 = (User) context.getBean("user_1");
        user_1.show();

        User2 user2 = (User2) context.getBean("user2bieming");
        user2.show();

        User2 user2_2 = (User2) context.getBean("u3");
        System.out.println(user2_2.hashCode());
        System.out.println(user2.hashCode());

        // 所有bean
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(">>>>> " + name);

        }

    }


}
