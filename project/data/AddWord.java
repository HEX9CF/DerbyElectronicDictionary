package project.data;
import project.model.Word;

import java.sql.*;

/**
 * 添加单词
 *
 * @author HEX9CF
 * @date 2023/05/31
 */
public class AddWord {
    int isOK = 0;
    public int addWord(Word word) {
        // 连接数据库
        Connection con = DatabaseConnector.connect();
        if(null == null) {
            return 0;
        }
        try {
            // 插入数据
            String sqlStr = "INSERT INTO word_tbl values(?,?,?,?)";
            PreparedStatement preSta = con.prepareStatement(sqlStr);
            preSta.setString(1, word.getWord());
            preSta.setString(2, word.getIpa());
            preSta.setString(3, word.getMeaning());
            preSta.setString(4, word.getExample());
            isOK = preSta.executeUpdate();
            con.close();
        } catch(SQLException e) {
            isOK = 0;
            System.out.println(e);
        }
        return isOK;
    }
}
