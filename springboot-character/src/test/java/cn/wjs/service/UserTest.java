package cn.wjs.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    @Qualifier("userTwoServiceImpl")
    private UserService userService;

    @Autowired
    private ApplicationContext appContext;

//    @Resource(name = "userTwoServiceImpl")
//    private UserService userService;

    @Test
    public void UserTest() {
        System.out.println("=====: " + userService.select("1"));
    }
// https://blog.csdn.net/lbh199466/article/details/89156785
    // https://blog.51cto.com/u_15081050/2593112
    /**
     *
     */
    @Test
    public void appContextTest(){
       List<UserService> aaa = new ArrayList<>();
       aaa.addAll(appContext.getBeansOfType(UserService.class).values());

        aaa.forEach(e->{
            e.select("1");
        });
    }
    public static void main(String[] args) throws Exception {
        byte a = 127;
        byte b = 127;
       // a = a + b;
        System.out.println(a);
        String str = "20200805";
        System.out.println(str.substring(0, 4));
        System.out.println(str.substring(4, 8));
       // System.out.println(str.substring(8, 12));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(new java.sql.Timestamp(sdf.parse("2020-08-05").getTime()));

    }
    @Test
    public void jdbcTest() {
        Connection con;
       // public Connection getConnection(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("???????????????????????????");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root", "123456");
                String sql = "insert into user (name) values(?)"; // ????????????sql??????
                // ????????????Statment??????
                PreparedStatement ps = con.prepareStatement(sql);
                // ???sql??????????????????????????????
                ps.setString(1, "lisi");

                // ???sql??????????????????????????????
               // ps.setString(2, "aaa");
                // ??????sql??????
                ps.executeUpdate();
                // ???????????????????????????
                con.close();
                System.out.println("jjk?????????????????????");
                System.out.println("?????????????????????");
            } catch (SQLException e) {
                e.printStackTrace();
            }

      //  }
    }

}
