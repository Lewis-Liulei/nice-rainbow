package rt.lewis;

//import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rt.lewis.business.user.UserService;
import rt.lewis.common.entity.user.User;
import rt.lewis.common.entity.user.enums.StatusEnum;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
   @Resource
   private UserService userService;

   /* @Test
    public void getUserById()
    {
        //assertTrue( true );
        User user = userService.getUserById("a");
        Assert.assertEquals("zhangsan",user.getName());
        Assert.assertTrue(StatusEnum.失败==user.getStatus());
        System.out.println("状态===========:  "+user.getStatus());
    }*/
    /*@Test
    public void insertUser(){

        User user = new User();
        user.setId("abcd22");
        user.setName("lisi223");
        user.setAddress("sabsdfsq");
        user.setStatus(StatusEnum.成功);
        //user.setCtime(new Date());
        //user.setCdate(new Date());
        //user.setCdt(new Date());
        System.out.println(userService.insertUser(user));

    }*/

    @Test
    public void getListByPage(){
        System.out.println(userService.getListByPage());

    }

    @Test
    public void insertnewUser(){
        User user= new User();
            user.setId("liset12")
                .setName("zhangsa112")
                .setAddress("sfdsf")
                .setCtime(LocalDateTime.now())
                    .setCdate(LocalDate.now())
                    .setCdt(LocalDateTime.now());

        System.out.println(userService.insertUser(user));

    }
}
