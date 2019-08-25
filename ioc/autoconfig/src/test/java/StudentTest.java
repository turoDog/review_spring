import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import student.StudentService;

/**
 * Project Name:review_spring <br/>
 * Package Name:PACKAGE_NAME <br/>
 * Date:2019/8/25 0:27 <br/>
 *
 * @author <a href="turodog@foxmail.com">chenzy</a><br/>
 */
public class StudentTest {

    @Test
    public void testSave() {

        ApplicationContext context = new ClassPathXmlApplicationContext("autoConfig.xml");
        StudentService studentService = (StudentService) context.getBean("studentService", StudentService.class);
        Assert.assertNotNull(studentService.save());

    }
}
