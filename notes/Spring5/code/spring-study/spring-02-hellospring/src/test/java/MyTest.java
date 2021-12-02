import com.andyron.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Andy Ron
 */
public class MyTest {
    public static void main(String[] args) {
        // 获取Spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 我们的对象现在都在Spring中管理了，我要需要使用，直接去里面取出来就可以！

        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }
}
