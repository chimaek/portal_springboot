package com.jejunu.portal.cooking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CookingApplicationTests {
    @Autowired
    private DataSource ds;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testconnection() throws Exception{
        System.out.println("ds:" + ds);
        Connection connection = ds.getConnection();
        System.out.println("con: "+connection);

        connection.close();
    }

}
