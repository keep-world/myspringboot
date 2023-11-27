package com.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyTest_druid {

    @Autowired
    @Qualifier("druid")
    private DataSource dataSource;

    @Test
    public void druidDatasourceTest() {
        String sql = "select * from t_emp t1 join t_user t2 where t1.emp_id=t2.user_id; ";
        Connection conn = null;
        Statement st = null;
        try {
            conn = dataSource.getConnection();
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            log.info("{} | {} | {} | {} | {} | {} ",
                    rsmd.getColumnName(1),
                    rsmd.getColumnName(2),
                    rsmd.getColumnName(3),
                    rsmd.getColumnName(4),
                    rsmd.getColumnName(5),
                    rsmd.getColumnName(6)
            );
            while (rs.next()) {
                log.info("{} | {} | {} | {} | {} | {} ",
                        rs.getObject(1),
                        rs.getObject(2),
                        rs.getObject(3),
                        rs.getObject(4),
                        rs.getObject(5),
                        rs.getObject(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
