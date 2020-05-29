import com.ssm.dao.UserDao;
import com.ssm.ectity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestJdbcTemplate {

    @Test
    public void addUserTest(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextJDBC.xml");

        UserDao userDao= (UserDao) context.getBean("userDAO");

        User user=new User();
        user.setUserName("wen");
        user.setPassword("123456");

        int result=userDao.addUser(user);
        if (result>0){
            System.out.println("成功插入"+result+"条数据");
        }else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void findAllUser(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextJDBC.xml");

        UserDao userDao= (UserDao) context.getBean("userDAO");

        List<User> users=userDao.findAllUser();

        for (User user:users
             ) {
            System.out.println(user);

        }
    }

}
