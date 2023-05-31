package project.data;
import project.model.Word;

import java.sql.*;

/**
 * 更新单词
 *
 * @author HEX9CF
 * @date 2023/05/31
 */
public class UpdateWord {
    int isOK = 0;
    public int updateWord(Word word) {
        // 连接数据库
        Connection con = DatabaseConnector.connect();
        if(null == con) {
            return 0;
        }
        try {
            // 更新数据
            String sqlStr = "UPDATE word_tbl SET ipa=?,meaning=?,example=? WHERE word=?";
            PreparedStatement preSta = con.prepareStatement(sqlStr);
            preSta.setString(4, word.getWord());
            preSta.setString(1, word.getIpa());
            preSta.setString(2, word.getMeaning());
            preSta.setString(3, word.getExample());
            isOK = preSta.executeUpdate();
            con.close();
        } catch(SQLException e) {
            isOK = 0;
            System.out.println(e);
        }
        return isOK;
    }
}
