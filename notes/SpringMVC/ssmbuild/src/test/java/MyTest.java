import com.andyron.dao.BooksMapper;
import com.andyron.pojo.Books;
import com.andyron.service.BooksServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Andy Ron
 */
public class MyTest {

    @Test
    public void  test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BooksServiceImpl booksServiceImpl = context.getBean("booksServiceImpl", BooksServiceImpl.class);
        for (Books books : booksServiceImpl.queryAllBooks()) {
            System.out.println(books);
        }
    }

}
