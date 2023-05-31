package project.data;
import java.sql.*;

/**
 * 数据库连接器
 *
 * @author HEX9CF
 * @date 2023/05/31
 */
public class DatabaseConnector {
    public static Connection connect() {
        Connection con = null;
        try {
            // 加载驱动
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch(Exception e) {
            System.out.println(e);
        }
        try {
            // 连接数据库
            String uri = "jdbc:derby:MyDictionary;create=false";
        } catch(Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
