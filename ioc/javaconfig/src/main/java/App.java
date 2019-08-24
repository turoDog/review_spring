import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project Name:review_spring <br/>
 * Package Name:PACKAGE_NAME <br/>
 * Date:2019/8/24 23:02 <br/>
 *
 * @author <a href="turodog@foxmail.com">chenzy</a><br/>
 */
public class App {

    public static void main(String srgs[]) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        System.out.println(studentService.save());
    }

}
