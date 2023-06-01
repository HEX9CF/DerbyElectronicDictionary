package dict.data;
import java.sql.*;

/**
 * 数据库初始化
 * 创建数据库和表
 *
 * @author HEX9CF
 * @date 2023/05/31
 */
public class DatabaseInitializer {
    Connection con;
    public DatabaseInitializer() {
        try {
            // 加载驱动
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch(Exception e) {
            System.out.println(e);
        }
        try {
            // 连接并创建数据库
            String uri = "jdbc:derby:MyDictionary;create=true";
            con = DriverManager.getConnection(uri);
        } catch(Exception e) {
            System.out.println(e);
        }
        if(null == con) {
            return;
        }
        try {
            // 创建表
            Statement sta = con.createStatement();
            String sqlStr = "CREATE TABLE word_tbl(" +
                    "word VARCHAR(32) PRIMARY KEY," +
                    "ipa VARCHAR(32)," +
                    "meaning VARCHAR(256)," +
                    "example VARCHAR(256)" +
                    ")";
            sta.executeUpdate(sqlStr);
            con.close();
        } catch(SQLException e) {
            System.out.println(e);
        }
    }
}
