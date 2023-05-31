package project.data;
import project.model.Word;

import java.sql.*;

/**
 * 删除单词
 *
 * @author HEX9CF
 * @date 2023/05/31
 */
public class DeleteWord {
    int isOK = 0;
    public int deleteWord(Word word) {
        // 连接数据库
        Connection con = DatabaseConnector.connect();
        if(null == null) {
            return 0;
        }
        try {
            // 插入数据
            String sqlStr = "DELETE FROM word_tbl WHERE word=?";
            PreparedStatement preSta = con.prepareStatement(sqlStr);
            preSta.setString(1, word.getWord());
            isOK = preSta.executeUpdate();
            con.close();
        } catch(SQLException e) {
            isOK = 0;
            System.out.println(e);
        }
        return isOK;
    }
}
