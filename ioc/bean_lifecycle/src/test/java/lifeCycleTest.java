import com.nasus.bean.Person;
import java.awt.print.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Project Name:review_spring <br/>
 * Package Name:PACKAGE_NAME <br/>
 * Date:2019/9/1 16:38 <br/>
 *
 * @author <a href="turodog@foxmail.com">chenzy</a><br/>
 */
public class lifeCycleTest {

    @Test
    public void testLifeCycle(){
        // 为面试而准备的Bean生命周期加载过程
        ApplicationContext context = new ClassPathXmlApplicationContext("bean_lifecycle.xml");
        Person person = (Person)context.getBean("person");
        //System.out.println("person对象：" + person);
        // 使用属性
        System.out.println("11、实例化完成使用属性：Person name = " + person.getName());
        // 关闭容器
        ((ClassPathXmlApplicationContext) context).close();
    }

}
