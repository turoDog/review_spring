/**
 * Project Name:review_spring <br/>
 * Package Name:PACKAGE_NAME <br/>
 * Date:2019/8/24 22:13 <br/>
 *
 * @author <a href="turodog@foxmail.com">chenzy</a><br/>
 */
public class StudentService {

    public static void main(String args[]) {

        StudentDao studentDao = new StudentDao();
        System.out.println(studentDao.save());

    }

}
