import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project Name:review_spring <br/>
 * Package Name:PACKAGE_NAME <br/>
 * Date:2019/8/24 23:50 <br/>
 *
 * @author <a href="turodog@foxmail.com">chenzy</a><br/>
 */
/**
 * 声明这是一个配置类，程序运行时初始化这个类，把 @Bean 注解的 bean 加载到 ioc 容器备用
 */
@Configuration
public class StudentConfig {

    @Bean // 这是一个 bean
    public StudentDao studentDao() {
        return new StudentDao();
    }

    @Bean
    public StudentService studentService(StudentDao studentDao) {
        return new StudentService(studentDao);
    }

}
