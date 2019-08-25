package student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project Name:review_spring <br/>
 * Package Name:PACKAGE_NAME <br/>
 * Date:2019/8/24 22:13 <br/>
 *
 * @author <a href="turodog@foxmail.com">chenzy</a><br/>
 */
@Component
public class StudentService {

    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public String save() {

        return studentDao.save();

    }
}
